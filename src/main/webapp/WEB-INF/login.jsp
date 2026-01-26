<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>
</head>
<body>
	<form action="Login" method="post">
		<fieldset>
			<legend>Connectez-vous</legend>
			 <p>Vous pouvez vous connecter via ce formulaire.</p>
			<label id="email">Votre email <span class="requis">*</span> </label>
			<input type="text" name="email" id="email" required size="50" value="<c:out value="${utilisateur.email}"/>" size="20" 
maxlength="60"/>
<br>
			 <span class="erreur">${form.erreurs['email']}</span>
			<label id="pass">Votre mot de passe <span class="requis">*</span> </label>
			<input type="password" id="pass" name="pass"  value="" size="20" maxlength="20"/>
			<br>
			 <span class="erreur">${form.erreurs['motdepasse']}</span>
			<input type="submit" value="Se connecter" name="connexion">
			 <p class="${empty form.erreurs ? 'succes' :'erreur'}">${form.resultat}</p>
                
             <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
		</fieldset>
	
	</form>
</body>
</html>