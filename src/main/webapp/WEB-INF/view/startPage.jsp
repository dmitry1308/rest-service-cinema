<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<br>

<h1 align="center">Кинотеатры</h1>

<div align="center">
    <form method="post" action="<c:url value='/add_user'/>">
        <input type="submit" value="Регистрация пользователя" name="Ok">
    </form>

    <form method="post" action="<c:url value='/user_login'/>">
        <input type="submit" value="Вход" name="Ok"><br>
    </form>
</div>


</body>
</html>
