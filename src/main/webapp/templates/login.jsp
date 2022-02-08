<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Se connecter</title>
</head>
<body>
    <div style="color: #FF0000;">${errorMessage}</div>
    <div style="color: #00ff00;">${successMessage}</div>
    <h1 style="color: lime">${sessionScope.successMessage}</h1>
    <c:set var="successMessage" value="" scope="session" />
    <ul>
        <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
        <li><a href="${pageContext.request.contextPath}/convention/ajout">Ajouter une convention</a></li>
        <li><a href="${pageContext.request.contextPath}/participant/ajout">Ajouter un Participant</a></li>
        <c:if test="${empty user}">
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
        </c:if>
        <c:if test="${not empty user}">
            <li><a href="${pageContext.request.contextPath}/logout">Logout ${user.getId()}</a></li>
        </c:if>
    </ul>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <h1> Login: </h1>
        <br>
        <label for="username">
            Username: <input type="text" name="username" id="username" value="${username}">
        </label> <br>
        <label for="password">
            Password: <input type="text" name="password" id="password">
        </label>
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>
