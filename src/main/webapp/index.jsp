<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee manager</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <p>Please select action:</p>
        <ul>
            <!-- Update/delete in interiorul paginii View -->
            <li><a href="view">View</a></li>
            <li><a href="add">Create</a></li>
            <li>About</li>
        </ul>
    </body>
</html>
