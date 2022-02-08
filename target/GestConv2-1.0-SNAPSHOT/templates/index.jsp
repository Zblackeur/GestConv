<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
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

<form method="get" action="/index">
    <h4>Recherche simple: </h4>
    <input type="hidden" name="action" value="${q}">
    <input type="text" name="q" placeholder="Entrer un texte">
    <button>Recherche</button>
</form>
<form method="get" action="/index">
    <h4>Recherche Multiple: </h4>
    <input type="hidden" name="action" value="recherche_avancee">
    <input type="text" name="q" value="${q}" placeholder="Entrer un texte">
    <select name="type_convention" id="type_convention">
        <c:forEach items="${typeConventions}" var="typeConvention">
            <option value="${typeConvention}">${typeConvention}</option>
        </c:forEach>
    </select>
    <button>Recherche</button>
</form>
<div style="color: red"> ${errorMessage}</div>
<h2> Voici la liste des conventions: </h2>
<c:forEach items="${conventions}" var="convention">
    <div class="conv${convention.getId()}" style="border: 2px solid #FF0000; margin: 10px">
        <div class="form${convention.getId()}">
            <form method="post" action="/admin/convention/suprimer">
                <input type="hidden" name="idconv" value="${convention.getId()}">
                <button>Suprimer</button>
            </form>
            <form method="get" action="/admin/convention/editer">
                <input type="hidden" name="idconv" value="${convention.getId()}">
                <button> Editer</button>
            </form>
        </div>
        <h5>convention---${convention.getId()}</h5>
        <p>${convention.getObjetConvention()}</p>
        <div>
            <form method="get" action="/convention/detail">
                <input type="hidden" name="idconv" value="${convention.getId()}">
                <button type="submit">Voir Plus</button>
            </form>
        </div>
    </div>
</c:forEach>
</body>
</html>