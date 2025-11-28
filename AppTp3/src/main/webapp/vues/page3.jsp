<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des Projets</title>
    <spring:url value="/bt/css" var="bts" />
    <link href="${bts}/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<div class="container">
    <div class="row mt-2">
        <div class="col-12">
            <div class="card bg-info text-white">
                <div class="card-header">
                    <h1>Gestion des projets <font size="5pt">(Espace Administrateur)</font></h1>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <div class="alert alert-warning">
                Bienvenue Mr/Mlle <b>${sessionScope.u.nom}</b> <a href="${cxt}/logout" class="btn btn-link">(Déconnexion)</a>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top:10px;">
        <div class="col-3">
            <div class="list-group">
                <a href="${cxt}/home" class="list-group-item list-group-item-action">
                    <span class="fa fa-th-large"></span>
                    Gestion des départements
                </a>
                <a href="${cxt}/ajoutEmploye" class="list-group-item list-group-item-action">
                    <span class="fa fa-th-large"></span>
                    Ajouter un employé
                </a>
                <a href="${cxt}/ajoutProjet" class="list-group-item list-group-item-action">
                    <span class="fa fa-th-large"></span>
                    Ajouter un projet
                </a>
            </div>
        </div>
        <div class="col-9">
            <div class="card text-white">
                <div class="alert alert-primary"><h4>Département: ${dept.nom}</h4></div>
                <div class="card-header bg-success">
                    <h5>Liste des projets</h5>
                </div>
                <table class="table table-hover">
                    <thead class="thead-light">
                        <tr><th>ID</th><th>Titre</th><th>Etat</th><th>Action</th></tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${liste}" var="d">
                            <tr>
                                <td>${d.id}</td>
                                <td>${d.titre}</td>
                                <td>${d.etat}</td>
                                <td><a href="${cxt}/employes/proj/${d.id}" class="btn btn-primary">Liste des employés</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>