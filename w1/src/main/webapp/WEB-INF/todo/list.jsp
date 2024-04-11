<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jbs
  Date: 4/8/24
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
    <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach>
    </ul>
<%--    // ListController 의 req.setAttribute("list", dtoList)와 이름을 동일하게 해야된다.--%>
</body>
</html>
