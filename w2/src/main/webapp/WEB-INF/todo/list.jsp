<%--
  Created by IntelliJ IDEA.
  User: jbs
  Date: 4/11/24
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>

    <ul>
        <c:forEach items = "${dtoList}" var = "dto">
            <li>
                <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                <span>${dto.title}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished? "DONE" : "NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>

    <form action="/logout" method="post">
        <button>LOGOUT</button>
    </form>
</body>
</html>
