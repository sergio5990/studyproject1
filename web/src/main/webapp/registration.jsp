<%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 30.03.2016
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${msg}</h1>
    <p>${error}</p>
    <%--registration form--%>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        Логин: <br />
        <input name="username" type="text" size="25" maxlength="30"/> <br />
        Пароль: <br />
        <input name="password" type="password" size="25" /> <br />
        <input type="submit" name="enter" value="Регистрация" />
    </form>
</body>
</html>
