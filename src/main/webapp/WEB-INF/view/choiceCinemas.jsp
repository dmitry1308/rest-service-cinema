<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<br>

<h1 align="center">Выберите кинотеатр:</h1>

<div align="center">
    <form method="get" action="<c:url value='/choiceHallsinCinema1'/>">
        <input type="submit" value="Кинотеатр 1" name="Ok">
    </form>

    <form method="get" action="<c:url value='/choiceHallsinCinema1'/>">
        <input type="submit" value="Кинотеатр 2" name="Ok"><br>
    </form>
</div>


</body>
</html>

