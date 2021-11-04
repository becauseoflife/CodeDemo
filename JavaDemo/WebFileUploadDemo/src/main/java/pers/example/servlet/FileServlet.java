package pers.example.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 判断上传的表单是普通表单还是带文件的表单
        if (!ServletFileUpload.isMultipartContent(request)){
            return; // 结束，说明这是普通的表单
        }


        // 创建上传文件的保存路径，建议放在WEB-INF目录下，安全，用户无法直接访问上传的文件
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        // 第一次访问，upload 文件夹不存在，直接创建目录
        if (!uploadFile.exists()){
            uploadFile.mkdir();     // 创建目录
        }

        // 缓存，临时文件
        // 临时路径，加入文件超过预期的大小，我们就把他放到临时文件中去，过几天自动删除，或者提醒用户转为永久文件
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        // 第一次访问，temp 文件夹不存在，直接创建目录
        if (!tempFile.exists()){
            tempFile.mkdir();     // 创建目录
        }

        // 处理上传文件，一般都需要使用流来获取，我们可以使用 request.getInputStream() , 原生态的文件上传流获取，十分麻烦
        // 但是我们都建议使用 Apache 的文件上传组件来实现，commons-fileupload.jar 它需要依赖于 commons-io.jar 组件。

        /**
         * ServletFileUpload 负责处理上传文件的文件数据，并将表单中每个输入项封装成一个 FileItem 对象，
         * 在使用 ServletFileUpload 对象解析请求时需要 DiskFileItemFactory 对象。
         * 所以，我们需要在进行解析工作前构造好 ServletFileUpload 对象，
         * 通过 ServletFileUpload 对象的构造方法或 setFileItemFactory() 方法设置 ServletFileUpload 对象的 FileItemFactory 属性。
         */

        try {
            /* 1. 创建 DiskFileItemFactory 对象，处理文件 上传路径 或者 大小限制 */
            DiskFileItemFactory factory = getDiskFileItemFactory(tempFile);

            /* 2. 获取 ServletFileUpload */
            ServletFileUpload servletFileUpload = getServletFileUpload(factory);

            /* 3. 处理上传文件 */

            String msg = uploadParseRequest(servletFileUpload, request, uploadPath);

            // Servlet 请求转发消息
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("info.jsp").forward(request, response);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }



    }

    private static DiskFileItemFactory getDiskFileItemFactory(File file){
        /* 1. 创建 DiskFileItemFactory 对象，处理文件 上传路径 或者 大小限制 */
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区的时候，将他放到临时文件中：
        factory.setSizeThreshold(1024 * 1024); // 缓冲区大小为 1M
        factory.setRepository(file); // 临时目录的保存目录，需要一个File
        return factory;
    }

    private static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
        /* 2. 获取 ServletFileUpload */
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        // 监听文件上传速度
        servletFileUpload.setProgressListener(new ProgressListener() {
            /**
             *
             * @param lByteRead 已经读取到的文件大小
             * @param lContentLength 文件大小
             * @param i /
             */
            @Override
            public void update(long lByteRead, long lContentLength, int i) {
                System.out.println("总大小： " + lContentLength + "已经上传： " + lByteRead);
            }
        });
        // 处理乱码问题
        servletFileUpload.setHeaderEncoding("UTF-8");
        // 设置单个文件的最大值
        servletFileUpload.setFileSizeMax(1024 * 1024 * 10);
        // 设置总共能够上传文件的大小
        // 1024 = 1kb * 1024 = 1M * 10 = 10M
        servletFileUpload.setSizeMax(1024 * 1024 * 10);

        return servletFileUpload;
    }

    private static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath) throws FileUploadException, IOException {
        String msg = null;

        // 把前端请求解析，封装成一个 FileItem 对象。需要从 ServletFileUpload 对象中获取
        List<FileItem> fileItemList = upload.parseRequest(request);
        // 遍历
        for(FileItem fileItem : fileItemList)
        {
            // 判断上传文件是否是普通的表单还是带文件的表单
            if (fileItem.isFormField()){
                // getFileName() 是指前端表单控件的name
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8"); // 处理中文乱码
                System.out.println(name + " " + value);
            }else { // 文件

                //===============处理文件=================//
                String uploadFileName = fileItem.getName();
                System.out.println("文件名： " + uploadFileName);

                // 文件名可能不合法
                if (uploadFileName == null || uploadFileName.trim().equals("")){
                    continue;
                }

                // 获得上传的文件名
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                // 获得文件的后缀
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                /*
                 *  如果文件后缀 fileExtName 不是我们所需要的
                 *  就直接 return ，不处理，告诉用户文件类型不对
                 * */
                System.out.println("文件信息: [ 文件名： " + fileName + " <-->  文件类型： " + fileExtName + "]");

                // 可以使用 UUID （唯一识别通用码），保证文件名唯一
                // UUID.randomUUID() ，随机生成一个唯一识别的通用码
                // 网络传输的东西，都需要序列化
                String uuidPath = UUID.randomUUID().toString();


                //===============存放地址=================//

                // 存到哪 uploadPath
                // 文件真实存在的路径 readPath
                String realpath = uploadPath + "/" + uuidPath;
                // 给每个文件创建一个对应的文件夹
                File realPathFile = new File(realpath);
                if (!realPathFile.exists()){
                    realPathFile.mkdir();
                }


                //===============文件传输=================//

                // 获得文件上传的流
                InputStream inputStream = fileItem.getInputStream();

                // 创建一个文件输出流
                // realPath = 真实的文件夹
                // 差一个文件；加上输出文件的名字
                FileOutputStream fos = new FileOutputStream(realpath + "/" + fileName);

                // 创建一个缓冲区
                byte[] buffer = new byte[1024 * 1024];

                // 判断是否读取完毕
                int len = 0;
                // 如果大于0说明还存在数据
                while( (len = inputStream.read(buffer) ) > 0){
                    fos.write(buffer, 0, len);
                }
                // 关闭流
                fos.close();
                inputStream.close();

                msg = "文件上传成功！";
                fileItem.delete(); // 上传成功,清理临时文件

                //===============文件传输完成=================//
            }

        }

        return msg;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
