package pers.utils;

// 多线程实现用户体验（异步）

import com.sun.mail.util.MailSSLSocketFactory;
import pers.pojo.User;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail extends Thread {
    // 用于给用户发送邮件的邮箱
    private String from = "1752196851@qq.com";
    // 邮箱的用户名
    private String username = "1752196851@qq.com";
    // 邮箱的密码
    private String password = "didcxceupmowbfcj";
    // 发送邮件的服务器地址
    private String host = "smtp.qq.com";

    private User user;

    public SendEmail(User user){
        this.user = user;
    }

    @Override
    public void run() {
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.host", host);  // 设置QQ邮件服务器
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
                    return new PasswordAuthentication(username, password);
                }
            });
            // 开启 Session 的 debug 模式，这样可以查看程序发送 email 的运行状态
            session.setDebug(true);


            // 2. 通过 session 得到 transport对象
            Transport ts = session.getTransport();


            // 3. 使用邮箱的用户名和授权码连上邮件服务器
            ts.connect(host, username, password);


            // 4. 创建邮件
            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);
            // 指明邮件的发送人，
            message.setFrom(new InternetAddress(from));
            // 指明邮件的收件人 现在发件人和收件人是一样的，就是自己发给自己
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            // 邮件的标题
            message.setSubject("只包含文本的简单邮件");

            // 邮件的文本内容
            message.setContent("Hello World!","text/html;charset=UTF-8");
            message.saveChanges();

            // 5. 发送邮件
            ts.sendMessage(message, message.getAllRecipients());

            // 关闭连接
            ts.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
