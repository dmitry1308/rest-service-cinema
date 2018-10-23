<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<br>

<h1 align="center">Выберите зал:</h1>

<div align="center">
    <form method="post" action="<c:url value='/cinemaHall1'/>">
        <input type="submit" value="Зaл 1" name="Ok">
    </form>

    <form method="post" action="<c:url value='/cinemaHall1'/>">
        <input type="submit" value="Зaл 2" name="Ok"><br>
    </form>
</div>


</body>
</html>

