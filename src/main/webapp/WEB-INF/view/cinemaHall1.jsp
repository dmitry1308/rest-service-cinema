<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 22.10.2018
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор места</title>
</head>
<body>
<h2>Выберите место:</h2><br/>

<%--<c:out value="${requestScope.rowInHall.numberOfRow}"/>   получение конкретного поля сущности  --%>

<form method="post" action="">

    <label><input type="number" name="row"></label>Ряд<br>

    <label><input type="number" name="place"></label>Место<br>

    <input type="submit" value="Забронировать" name="Ok"><br>
</form>


<div align="center">
    <c:forEach var="row" items="${requestScope.rowInHall}">
        <ul>
            <li>Ряд: <c:out value="${row.numberOfRow}"/></li>
            <li>Место 1: <c:out value="${row.place1}"/></li>
            <li>Место 2: <c:out value="${row.place2}"/></li>
            <li>Место 3: <c:out value="${row.place3}"/></li>
        </ul>
        <hr />
    </c:forEach>

</div>
</body>
</html>
