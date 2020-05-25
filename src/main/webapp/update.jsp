<%-- 
    Document   : update
    Created on : May 25, 2020, 7:09:17 PM
    Author     : sscerbatiuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating Employee</title>
    </head>
    <body>
        <h2>Update Employee</h2>
        <form method="post" action="update-employee">
            <c:forEach items="${employeeById}" var="val">
                <input type="hidden" name="id" value="${val.key}"/>
                <div>
                    <label>Name</label>
                    <input type="text" name="name" value="${val.value.name}"/>
                </div>
                <button type="submit">Update</button>
            </c:forEach>
        </form>
    </body>
</html>
