<%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 30.03.2016
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${msg}</h1>

<h2>Создать новую задачу</h2>
<%--input form--%>
    <form action="${pageContext.request.contextPath}/tasks" method="post">
        Название задачи: <br />
        <label>
            <input name="title" type="text" size="25" maxlength="50"/>
        </label> <br />
        Описание: <br />
        <label>
            <textarea name="description" rows="5"></textarea>
        </label> <br />
        <input type="submit" name="enter" value="создать" />
    </form>

    <h2>Текущие задачи</h2>
    <table border="2">
        <%--task list--%>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td><b><c:out value="${task.getTitle()}" /></b></td>
                <td><c:out value="${task.getDescription()}" /></td>
                <td><c:out value="${task.getCreateDate()}" /></td>
                <td><c:out value="${task.getStatus().getName()}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
