<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View employees</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${list}" var="emp">
                <li><c:out value="${emp}" /></li>
            </c:forEach>
        </ul>
    </body>
</html>
