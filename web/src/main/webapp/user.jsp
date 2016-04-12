<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${msg}</h1>

    <c:forEach items="${users}" var="user">
        <ul>
            <li><c:out value="${user.getUsername()}"/></li>
        </ul>
    </c:forEach>

</body>
</html>
