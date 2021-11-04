<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    <p>
        用户名：<input type="text" name="username" />
    </p>
    <p>
        <input type="file" name="file" />
    </p>
    <p>
        <input type="file" name="file">
    </p>
    <p>
        <input type="submit">
    </p>

</form>


</body>
</html>
