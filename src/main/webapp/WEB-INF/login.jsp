<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>

 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script src="https://cdn.tailwindcss.com"></script>

 <style type="text/css">
 
 	fieldset {
 	
	display: flex;
	flex-direction: column;
	width: 50%;
	margin:50px  auto;
	font-family: "Roboto" arial vardana;
	font-size: 1.2rem;
	justify-content: center;
}
label {
	text-align: center;
	
}
input {
	border: 1px outset;
	box-shadow: 2px 2px 0px black inset;
	border-radius: 6px;
	padding: 10px;
}
.input{
	border: none;
	box-shadow: 6Px 6px 6px rgba(123,35,65,0.5);
	cursor: pointer;
	color: white;
	background: buttonshadow;
	background-color: skyblue;
	font-weight: bold;
	font-size: 1.1rem;
	transition: all 0.5s;
}
.input:hover {
	background-color: white;
	color: blue;
	transform:scale(1);
	
}
 

 </style>
  
</head>
<body>
	<form action="Login" method="post">
		<fieldset>
			<legend class="text-3xl font-bold underline text-blue-500">Connectez-vous</legend>
			 <p>Vous pouvez vous connecter via ce formulaire.</p>
			<label id="email">Votre email <span class="requis">*</span> </label>
			<input type="email" name="email" id="email" required size="50" value="<c:out value="${utilisateur.email}"/>" size="20" 
maxlength="60" autofocus="autofocus"/>
<br>
			<span class="erreur">${form.erreurs['email']}</span>
			<label id="pass">Votre mot de passe <span class="requis">*</span> </label>
			<input type="password" id="passe" name="passe"  value="" size="20" maxlength="20"/>
			<br>
			 <span class="erreur">${form.erreurs['motdepasse']}</span>
			<input type="submit" value="Se connecter" name="connexion" class="input">
			<c:if test="${param.error == 'passe' }">
				<p style="color: red;">Mot de passe incorrect</p>
			</c:if>
			<p> Si vous etes nouveau cliquez sur </p>
			<a href="Inscription">Creer un compte</a>
			<p class="${empty form.erreurs ? 'succes' :'erreur'}">${form.resultat}</p>
                
             <%-- Vérification de la présence d'un objet utilisateur en session 
             <c:if test="${!empty sessionScope.sessionUtilisateur}">
                     Si l'utilisateur existe en session, alors on affiche son adresse email. 
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p> </c:if> --%>
                
		</fieldset>
	
	</form>
</body>
</html>