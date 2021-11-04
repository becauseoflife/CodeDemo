<%--
  Created by IntelliJ IDEA.
  User: 17521
  Date: 2020/11/3
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post" >
        <p>用户名：
            <label>
                <input type="text" name="username">
            </label>
        </p>
        <p>密码：
            <label>
                <input type="password" name="password">
            </label>
        </p>
        <p>邮箱：
            <label>
                <input type="email" name="email">
            </label>
        </p>
        <p><input type="submit" name="提交"></p>
    </form>
</body>
</html>
