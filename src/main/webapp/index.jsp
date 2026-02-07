<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>

<link rel="stylesheet" type="text/css" href="../CSS/home.css">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <style type="text/css">
 	/* RESET */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

/* BODY */
body {
    background-color: #f1f5f9;
    color: #1e293b;
}

/* HEADER */
header {
    background-color: #0f172a;
    color: white;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 15px 40px;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}

/* LOGO */
header h2 {
    font-size: 26px;
    letter-spacing: 1px;
  background-color:buttonshadow;
    color: #cbd5e1;
    padding: 8px 15px;
    border-radius: 6px;
    text-decoration: none;
    transition: 0.3s;
    font-weight: 500;
}

/* NAVIGATION */
nav ul {
    list-style: none;
    display: flex;
    gap: 30px;
}

nav ul li a {
    text-decoration: none;
    color: #cbd5e1;
    font-weight: 500;
    transition: 0.3s;
}

nav ul li a:hover {
    color: #38bdf8;
}

/* BOUTON DECONNEXION */
.btn-deco {
    background-color: #ef4444;
    color: white;
    padding: 8px 15px;
    border-radius: 6px;
    text-decoration: none;
    transition: 0.3s;
    font-weight: 500;
}

.btn-deco:hover {
    background-color: #dc2626;
}

/* MESSAGE BIENVENUE */
.h2 {
    margin: 30px;
    font-size: 22px;
    color: #0f172a;
}

.succes {
    margin: 0 30px 20px 30px;
    padding: 12px;
    background-color: #dcfce7;
    border-left: 6px solid #22c55e;
    border-radius: 6px;
    color: #166534;
    font-weight: 500;
}

/* RESPONSIVE */
@media (max-width: 768px) {
    header {
        flex-direction: column;
        gap: 15px;
        text-align: center;
    }

    nav ul {
        flex-direction: column;
        gap: 10px;
    }
}

}

/* SECTION BIENVENUE */
.welcome-section {
    display: flex;
    justify-content: center;
    margin: 40px 20px;
}

.welcome-box {
    max-width: 900px;
    background-color: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.08);
    text-align: center;
}

.welcome-box h1 {
    font-size: 28px;
    color: #0f172a;
    margin-bottom: 20px;
}

.welcome-box h1 i {
    color: #38bdf8;
    margin-right: 10px;
}

.welcome-box p {
    font-size: 17px;
    line-height: 1.8;
    color: #475569;
    margin-bottom: 15px;
}

.welcome-highlight {
    margin-top: 20px;
    font-size: 18px;
    color: #16a34a;
    font-weight: 600;
}

/* CONTENEUR GENERAL */
.container {
    max-width: 1200px;
    margin: auto;
    padding: 20px 30px 60px 30px;
}

/* ESPACE APRES HEADER */
header {
    margin-bottom: 40px;
}

/* SECTION BIENVENUE AÉRÉE */
.welcome-section {
    display: flex;
    justify-content: center;
    margin-top: 20px;
    margin-bottom: 60px;
}

.welcome-box {
    width: 100%;
    background-color: #ffffff;
    padding: 50px 60px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.07);
    text-align: center;
}

/* TITRE */
.welcome-box h1 {
    font-size: 30px;
    color: #0f172a;
    margin-bottom: 25px;
}

/* PARAGRAPHES */
.welcome-box p {
    font-size: 18px;
    line-height: 1.9;
    color: #475569;
    margin-bottom: 18px;
}

/* TEXTE FINAL */
.welcome-highlight {
    margin-top: 25px;
    font-size: 19px;
    color: #16a34a;
    font-weight: 600;
}


 
 </style>
 <link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
 
</head>
<body>
<div>
	<c:if test="${ !empty sessionScope.sessionUtilisateur }">
	<h2 class="h2">Bienvenue  ${sessionScope.sessionUtilisateur.nom.toUpperCase() } sur notre site d'application d'inventaire</h2>
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	</c:if>
	
	<header class="text-3xl font-bold underline text-blue-500">
		<div>
			<h2 class="logo">
    <i class="fa-solid fa-boxes-stacked"></i> AppInv
</h2>

		</div>
		
		<nav>
    <ul>
        <li>
            <a href="Lister">
                <i class="fa-solid fa-list"></i> Afficher
            </a>
        </li>
        <li>
            <a href="#accueil">
                <i class="fa-solid fa-house"></i> Accueil
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa-solid fa-warehouse"></i> Inventaire
            </a>
        </li>
        <li>
            <a href="ListerProd">
                <i class="fa-solid fa-box-open"></i> Produits
            </a>
        </li>
    </ul>
</nav>

		<div>
			<a href="Deconnecter" class="btn-deco">
    <i class="fa-solid fa-right-from-bracket"></i> Se déconnecter
</a>
		
			</div>
	</header>
	<section class="welcome-section">
    <div class="welcome-box">
        <h1>
            <i class="fa-solid fa-hand-sparkles"></i>
            Bienvenue sur votre espace de gestion d’inventaire
        </h1>

        <p>
            Cette application a été conçue pour vous offrir une expérience simple,
            rapide et efficace dans la gestion de vos produits, de votre inventaire
            et du suivi de vos opérations quotidiennes.
        </p>

        <p>
            Grâce à une interface claire et intuitive, vous pouvez consulter,
            organiser et contrôler vos données en toute sérénité.
            Notre objectif est de vous faire gagner du temps et d’optimiser votre travail.
        </p>

        <p class="welcome-highlight">
            Nous vous souhaitons une excellente utilisation de <strong>AppInv</strong> 🚀
        </p>
    </div>
</section>

</div>	

</body>
</html>
