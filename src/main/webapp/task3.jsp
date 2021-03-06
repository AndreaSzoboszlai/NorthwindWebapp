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
                    <div class="title"><a href="">Task 3: query results</a></div>
                </div>
                <c:choose>
                  <c:when test="${fn:length(task3) == 0}">
                    <p> No company with the given name </p>
                  </c:when>
                  <c:otherwise>
                        <table>
                            <tr class = "tablehead">
                                <td>Company</td>
                            </tr>
                            <c:forEach var="t3" items="${task3}">
                                <tr>
                                    <td><c:out value="${t3.getCompany()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                  </c:otherwise>
                </c:choose>

                <div class="containerfoot"></div>
                <br>
                Filter by company:
                <form method="POST" action="Task3">
                    <input type="text" id="filter3" name="filter3">
                    <input type="submit" value="Filter">
                <form>
            </div>
        </div>
    </body>
</html>
