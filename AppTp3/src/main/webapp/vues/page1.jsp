<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <spring:url value="/bt/css" var="bts" />
    <link href="${bts}/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container vh-100 d-flex justify-content-center align-items-center">
    <div class="card shadow-sm p-4" style="width: 100%; max-width: 400px;">
        <h2 class="text-center text-primary">Gestion des projets</h2>
        <h5 class="text-center text-success mb-4">Connectez-Vous</h5>
        <form method="POST" action="verif">
            <div class="mb-3">
                <label>Username</label>
                <input type="text" name="username" class="form-control" placeholder="Votre username" required>
            </div>
            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="Votre mot de passe" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Se Connecter</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>