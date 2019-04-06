<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css" href="NorthwindWebapp.css">
</head>
    <body>
        <nav>
            <ul>
                <a href="Task1"><li>Task 1</li></a>
                <a href="Task2"><li>Task 2</li></a>
                <a href="Task3"><li>Task 3</li></a>
                <a href="Task4"><li>Task 4</li></a>
                <a href="Task5"><li>Task 5</li></a>
            </ul>
        </nav>

        <div class="wrapper">
            <div class="container">
                <div class="containerhead">
                    <div class="title"><a href="">Task 5: query results</a></div>
                </div>
                <c:choose>
                  <c:when test="${fn:length(task5) == 0}">
                    <p> No company with the given name </p>
                  </c:when>
                  <c:otherwise>
                        <table>
                            <tr class = "tablehead">
                                <td> Company </td>
                                <td> Products </td>
                                <td> Unit Price </td>
                            </tr>
                            <c:forEach var="t5" items="${task5}">
                                <tr>
                                    <td><c:out value="${t5.getCompany()}"/></td>
                                    <td><c:out value="${t5.getProducts()}"/></td>
                                    <td><c:out value="${t5.getPrice()}"/></td>
                                </tr>
                            </c:forEach>
                        <table>
                  </c:otherwise>
                </c:choose>

                <div class="containerfoot"></div>
                <br>
                Filter by company:
                <form method="POST" action="Task5">
                    <input type="text" id="filter5" name="filter5">
                    <input type="submit" value="Filter">
                <form>
            </div>
        </div>
    </body>
</html>
