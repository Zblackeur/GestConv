<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<main>
    <main>
        <ul>
            <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
            <li><a href="${pageContext.request.contextPath}/convention/ajout">Ajouter une convention</a></li>
            <li><a href="${pageContext.request.contextPath}/participant/ajout">Ajouter un Participant</a></li>
        </ul>
        <h3>Modifier une convention </h3>
        <p> ${errorMessage}</p>
        <form method="post" action="${pageContext.request.contextPath}/admin/convention/editer">
            <input type="hidden" name="idconv" value="${convention.getId()}">
            <div>
                <label for="titre_convention">Titre Convention :</label>
                <div>
                    <input type="text" name="titre_convention" id="titre_convention"
                           value="${convention.getTitreConvention()}">
                </div>
            </div>
            <div>
                <label for="type_convention">Selectionner un type :</label>
                <div>
                    <select name="type_convention" id="type_convention">
                        <option value="Universitaire">Universitaire</option>
                        <option value="Industrielle">Industrielle</option>
                        <option value="IndustrielleNationnale">Industrielle Nationnale</option>
                    </select>
                </div>
            </div>
            <div>
                <label for="objet_convention">Objet de la convention :</label>
                <div>
                    <textarea name="objet_convention"
                              id="objet_convention">${convention.getObjetConvention()}</textarea>
                </div>
            </div>
            <div>
                <label for="date_entree_vigueur">Date d'entrée en vigueur :</label>
                <div>
                    <input type="date" name="date_entree_vigueur" value="${convention.getDateEntreeVigueur()}"
                           id="date_entree_vigueur">
                </div>
            </div>
            <div>
                <label for="date_expiration">Date d'expiration :</label>
                <div>
                    <input type="date" name="date_expiration" value="${convention.getDateExpiration()}"
                           id="date_expiration">
                </div>
            </div>
            <div>
                <input type="submit" value="Valider">
            </div>
        </form>
    </main>
</main>
</body>
</html>
