<%-- ajoutEmploye.jsp (Fig 6 : /ajoutEmploye) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Employé</title>
    <spring:url value="/bt/css" var="bts" />
    <link href="${bts}/bootstrap.min.css" rel="stylesheet">
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
                <a href="${cxt}/ajoutEmploye" class="list-group-item list-group-item-action active">
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
            <div class="card">
                <div class="card-header bg-success text-white">
                    <h5>Ajouter un Employé</h5>
                </div>
                <div class="card-body">
                    <form:form method="POST" action="${cxt}/saveEmploye" modelAttribute="employe">
                        <div class="mb-3">
                            <label>Nom</label>
                            <form:input path="nom" class="form-control" required="true"/>
                        </div>
                        <div class="mb-3">
                            <label>Fonction</label>
                            <form:select path="fonction" class="form-control" required="true">
                                <form:option value="manager">Manager</form:option>
                                <form:option value="ingénieur">Ingénieur</form:option>
                                <form:option value="technicien">Technicien</form:option>
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <label>Département</label>
                            <form:select path="dept.id" class="form-control" required="true">
                                <form:options items="${depts}" itemValue="id" itemLabel="nom"/>
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <label>Projet</label>
                            <form:select path="proj.id" class="form-control">
                                <form:option value="">Aucun</form:option>
                                <form:options items="${projs}" itemValue="id" itemLabel="titre"/>
                            </form:select>
                        </div>
                        <button type="submit" class="btn btn-primary">Enregistrer</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>