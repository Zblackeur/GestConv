<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 06/02/2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
  <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/convention/ajout">Ajouter une convention</a></li>
  <li><a href="${pageContext.request.contextPath}/participant/ajout">Ajouter un Participant</a></li>
</ul>

<h1> Detail de la convention <b>${convention.getId()}</b> </h1>
<div class="detailConvention">
  <div>Id convention: ${convention.getId()}</div>
  <div>Date édition: ${convention.getDateEdition()}</div>
  <div>Date Entrée en vigueur: ${convention.getDateEntreeVigueur()}</div>
  <div>Date Expiration: ${convention.getDateExpiration()}</div>
  <div>Objet convention: ${convention.getObjetConvention()}</div>
  <div>Titre convention: ${convention.getTitreConvention()}</div>
  <div>Type convention: ${convention.getTypeConvention()}</div>
</div>
</body>
</html>
