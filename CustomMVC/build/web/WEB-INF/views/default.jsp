<%-- 
    Document   : default
    Created on : Jul 14, 2016, 2:37:19 PM
    Author     : Rajesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Courses</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Fees</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${requestScope.courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.fees}</td>
                    <td>
                        <c:choose>
                            <c:when test="${course.status}">
                                Active
                            </c:when>
                            <c:otherwise>
                                Inactive
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>Edit Delete</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
