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
                    <div class="title"><a href="">Task 4: query results</a></div>
                </div>
                <c:choose>
                  <c:when test="${fn:length(task4) == 0}">
                    <p> No company with the given name </p>
                  </c:when>
                  <c:otherwise>
                        <table>
                            <tr class = "tablehead">
                                <td>Company</td>
                                <td>Order IDs</td>
                            </tr>
                             <c:forEach var="t4" items="${task4}">
                                <tr>
                                    <td><c:out value="${t4.getCompany()}"/></td>
                                    <td>
                                     <c:forEach var="t4OrderId" items="${t4.getOrderId()}">
                                            <c:out value="${t4OrderId}"/>
                                    </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                  </c:otherwise>
                </c:choose>

                <div class="containerfoot"></div>
                <br>
                Filter by company:
                <form method="POST" action="Task4">
                    <input type="text" id="filter4" name="filter4">
                    <input type="submit" value="Filter">
                <form>
            </div>
        </div>
    </body>
</html>
