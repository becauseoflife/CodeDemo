package pers.servlet;

import pers.pojo.User;
import pers.utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, password, email);

        // 使用线程专门发送邮件，防止出现耗时，和网站注册人数过多的情况
        SendEmail sendEmail = new SendEmail(user);
        // 启动线程， 线程启动后会执行 run() 方法发送邮件
        sendEmail.start();

        // 转发
        req.setAttribute("msg", "注册成功，我们已经发送了一封邮件给你！");
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
