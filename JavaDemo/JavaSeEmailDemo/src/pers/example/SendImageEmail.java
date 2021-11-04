package pers.example;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendImageEmail {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");  // 设置QQ邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp");  // 邮件发送协议
        properties.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码

        // 关于QQ邮箱，还需要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        // 使用 JavaMail 发送邮件的五个步骤


        // 1. 创建定义整个应用程序所需要的环境信息的 Session 对象。

        // QQ才有！！其他邮箱不用
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 发件人的邮箱用户名、授权码
                return new PasswordAuthentication("1752196851@qq.com", "didcxceupmowbfcj");
            }
        });
        // 开启 Session 的 debug 模式，这样可以查看程序发送 email 的运行状态
        session.setDebug(true);


        // 2. 通过 session 得到 transport对象
        Transport ts = session.getTransport();


        // 3. 使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "1752196851@qq.com", "didcxceupmowbfcj");


        // 4. 创建邮件
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发送人，
        message.setFrom(new InternetAddress("1752196851@qq.com"));

        // 指明邮件的收件人 现在发件人和收件人是一样的，就是自己发给自己
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1752196851@qq.com"));

        // 邮件的标题
        message.setSubject("只包含文本的简单邮件");

        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src/test.jpg"));
        image.setDataHandler(dh);
        image.setContentID("bz.jpg");   // 设置图片的名字

        // 附件数据
        MimeBodyPart ext = new MimeBodyPart();
        DataHandler dh1 = new DataHandler(new FileDataSource("src/test.txt"));
        ext.setDataHandler(dh1);
        ext.setFileName("");  // 设置附件的名字

        // 邮件的文本内容
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是邮件正文带图片的<img src='cid:bz.jpg'>的邮件", "text/html;charset=UTF-8");

        // 描述数据关系
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(text);
        multipart.addBodyPart(image);
        multipart.setSubType("related");        // 设置类型为 related 有内嵌图片的话

        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(multipart);

        // 拼接附件
        MimeMultipart file = new MimeMultipart();
        file.addBodyPart(ext);
        file.addBodyPart(contentText);
        file.setSubType("mixed");       // 这是类型为 mixed 有附件存在的话



        message.setContent(file);
        message.saveChanges();

        // 5. 发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        // 关闭连接
        ts.close();
    }
}
