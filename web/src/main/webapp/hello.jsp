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
    <h2>${login_error}</h2>
    <%--login form--%>
    <form action="${pageContext.request.contextPath}/" method="post">
        Логин: <br />
        <input name="username" type="text" size="25" maxlength="30"/> <br />
        Пароль: <br />
        <input name="password" type="password" size="25" /> <br />
        <input type="submit" name="enter" value="Вход" />
    </form>
    <h1>${msg}</h1>
    <a href="${pageContext.request.contextPath}/">hello</a>
    <a href="${pageContext.request.contextPath}/registration">registr</a>
    <a href="${pageContext.request.contextPath}/user">user</a>
    <a href="${pageContext.request.contextPath}/group">group</a>
    <a href="${pageContext.request.contextPath}/tasks">task</a>
    <a href="${pageContext.request.contextPath}/404">404</a>
    <a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
