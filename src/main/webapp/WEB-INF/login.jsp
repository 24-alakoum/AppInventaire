<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Inventaire</title>

 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">


 <link rel="stylesheet" href="style.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
 <style>
    body {
        background: linear-gradient(135deg, #f8fafc 0%, #e2e8f0 100%);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    fieldset {
        margin: 0;
        width: 400px;
    }
    .logo-login {
        text-align: center;
        font-size: 2rem;
        font-weight: 800;
        margin-bottom: 20px;
        color: #0f172a;
    }
    .erreur {
        color: #ef4444;
        font-size: 0.875rem;
        margin-bottom: 10px;
        display: block;
    }
 </style>
  
</head>
<body>
	<form action="Login" method="post">
		<fieldset>
            <div class="logo-login">
                <i class="fa-solid fa-boxes-stacked"></i> AppInv
            </div>
			<legend>Connexion</legend>

			<label for="email">Email</label>
			<input type="email" name="email" id="email" required value="<c:out value="${utilisateur.email}"/>" maxlength="60" autofocus/>
			<span class="erreur">${form.erreurs['email']}</span>

			<label for="passe">Mot de passe</label>
			<input type="password" id="passe" name="passe" required maxlength="20"/>
			<span class="erreur">${form.erreurs['motdepasse']}</span>

			<button type="submit" name="connexion" class="btn-submit">Se connecter</button>

            <c:if test="${param.error == 'passe' }">
				<p class="erreur text-center mt-4">Mot de passe incorrect</p>
			</c:if>

			<p class="text-center mt-4">Nouveau ici ? <a href="Inscription">Créer un compte</a></p>
		</fieldset>
	</form>
</body>
</html>