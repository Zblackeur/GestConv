<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/auth/login">
        <h1> Login: </h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <div style="color: #00ff00;">${successMessage}</div>
        <br>
        <label for="username">
            Username: <input type="text" name="username" id="username">
        </label>
        <label for="password">
            Password: <input type="text" name="password" id="password">
        </label>
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>
