<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>
<link rel="stylesheet" type="text/css" href="../CSS/home.css">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script src="https://cdn.tailwindcss.com"></script>
 <style type="text/css">
 	body {
	background-color: #f1f5f9;
	color: #1e293b;
}
 
 </style>
</head>
<body>
	<c:if test="${ !empty sessionScope.sessionUtilisateur }">
	<h2 class="h2">Bienvenue  ${sessionScope.sessionUtilisateur.nom.toUpperCase() } sur notre site d'application d'inventaire</h2>
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	</c:if>
	
	<header class="text-3xl font-bold underline text-blue-500">
		<div>
			<h2>AppInv</h2>
		</div>
		
		<nav>
			<ul>
				
       			<li><a href="Lister"> Afficher </a></li>
				<li><a href="#accueil">Accueil</a></li>
				<li><a href="#">Inventaire</a></li>
				<li><a href="#">Produits</a></li>
			</ul>
		</nav>
		<div>
			<button> <a href="Deconnecter">Se deconnecter</a></button> 		
			</div>
	</header>
</body>
</html>