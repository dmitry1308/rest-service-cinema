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
    <title>Вход пользователя</title>
</head>
<body>

<div align="center">
    <h2>Вход пользователя:</h2><br/>
</div>

<form method="post">
    <div align="center">
        <label>
            <input type="text" name="login">
        </label>Login<br><br>

        <label>
            <input type="password" name="password">
        </label>Password<br>

        <input  type="submit" value="Войти" name="Ok"><br><br>
        <a href="<c:url value="/"/>">Вернуться</a>
    </div>
</form>



</body>
</html>
