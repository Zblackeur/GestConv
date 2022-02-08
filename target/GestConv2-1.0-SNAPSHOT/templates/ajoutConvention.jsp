<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<main>
    <div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
            <li><a href="${pageContext.request.contextPath}/convention/ajout">Ajouter une convention</a></li>
            <li><a href="${pageContext.request.contextPath}/participant/ajout">Ajouter un Participant</a></li>
        </ul>
        <div>
            <h3>Ajouter une convention </h3>
            <p> Completez les champs pour créer une convention </p>
            <p> ${errorMessage}</p>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/convention/ajout">

            <div>
                <label for="nom_participant">NOM Participant :</label>
                <input type="text" name="nom_participant" id="nom_participant">
            </div>
            <div>
                <label for="type_convention">Selectionner un type :</label>
                <div>
                    <select name="type_convention" id="type_convention">
                        <c:forEach items="${typeConventions}" var="typeConvention">
                            <option value="${typeConvention}">${typeConvention}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div>
                <label for="objet_convention">Objet de la convention :</label>
                <div>
                    <textarea name="objet_convention" id="objet_convention" rows="5">Donner une bref description a cette convention</textarea>
                </div>
            </div>
            <div>
                <label for="date_entree_vigueur">Date d'entrée en vigueur :</label>
                <div>
                    <input type="date" name="date_entree_vigueur" id="date_entree_vigueur">
                </div>
            </div>
            <div>
                <label for="date_expiration">Date d'expiration :</label>
                <div>
                    <input type="date" name="date_expiration" id="date_expiration">
                </div>
            </div>
            <div>
                <input type="submit" value="Ajouter">
            </div>
        </form>
    </div>
</main>
</body>
</html>
