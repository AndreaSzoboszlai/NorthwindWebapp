<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <div class="title"><a href="">Task 2: query results</a></div>
                </div>
                <table>
                    <tr class = "tablehead">
                        <td>Company</td>
                        <td>Product number</td>
                    </tr>
                     <c:forEach var="t2" items="${task2}">
                        <tr>
                            <td><c:out value="${t2.getCompany()}"/></td>
                            <td><c:out value="${t2.getProductNum()}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="containerfoot"></div>
            </div>
        </div>
    </body>
</html>
