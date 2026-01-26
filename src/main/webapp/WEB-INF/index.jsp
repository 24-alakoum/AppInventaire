<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>
</head>
<body>
	<h2>Bienvenue sur notre ${sessionScope.sessionUtilisateur.nom }site d'application d'inventaire</h2>
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	<header>
		<div>
			<h2>AppInv</h2>
		</div>
		
		<nav>
			<ul>
				<li><a href="#accueil">Accueil</a></li>
				<li><a href="#">Inventaire</a></li>
				<li><a href="#">Produits</a></li>
			</ul>
		</nav>
		<div>
			<a href="Deconnecter">Se deconnecter</a>
		</div>
	</header>
</body>
</html>