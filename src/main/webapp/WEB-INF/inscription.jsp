<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <style type="text/css">
        
        
        body, p, legend, label, input {
    	font: normal 8pt verdana, helvetica, sans-serif;
}
fieldset {
    padding: 10px;
    border: 1px #0568CD solid;
}
legend {
    font-weight: bold;
    color: #0568CD;
}
/* Forms --------------------------------------------------------------------------------------- */
form label {
    float: left;
    width: 200px;
    margin: 3px 0px 0px 0px;
}
form input {
    margin: 3px 3px 0px 0px;
    border: 1px #999 solid;
}
form input.sansLabel {
    margin-left: 200px;
}
form .requis {
    color: #c00;
}

form .erreur {
    color: #900}
        
        </style>
    </head>
    <body>
        <form method="post" action="Inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                 <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom"  size="20" maxlength="20" value="${param.nom }" />
 				<span class="erreur">${erreurs['nom']}</span>
                <br />
                <label for="nom">Prenom d'utilisateur</label>
                <input type="text" id="prenom" name="prenom" value="${param.prenom }" size="20" maxlength="20" />
 				<span class="erreur">${erreurs['prenom']}</span>
 				<br>
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
	 			<span class="erreur">${erreurs['email']}</span>
                <br />
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />
 				 <label for="nom">Telephone d'utilisateur</label>
                <input type="text" id="telephone" name="telephone" value="" size="20" maxlength="20" />
 				<span class="erreur">${erreurs['prenom']}</span>
 				<br>
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
        </form>
        
        <c:if test="${ !empty luser }">
        
        	<table border="1">
        		<tr>
        			<th>ID</th>
        			<th>Nom</th>
        			<th>Prenom</th>
        			<th>Email</th>
        			<th>Mot de passe</th>
        			<th>Telephone</th>
        		</tr>
        		<c:forEach items="${ luser }" var="user">
        			<tr>
        				<td>${user.id }<td/>
        				<td>${user.nom }<td/>
        				<td>${user.prenom }<td/>
        				<td>${user.email }<td/>
        				<td>${user.mot_de_passe }<td/>
        				<td>${user.telephone }<td/>
        			</tr>
        		
        		</c:forEach>
        	</table>
        
        </c:if>
    </body>
</html>