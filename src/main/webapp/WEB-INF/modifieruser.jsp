<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GESTION DES INVENTAIRES</title>
<style type="text/css">
	.contact{
		color: white;
		height: 100vh;
		background-color: rgba(115,167,136,.8);
		
	}
	.contact h2,legend{
		font-family: "Roboto",sans-serif;
		font-size: 28px;
		color: white;
		text-shadow: 2px 2px black;
		margin: 0 0 40px 30px;
		padding-top: 40px;
			}
			
	legend{
	border: none;}		
			
	.formAndTable{
	display: flex;
	width: 100%;
	justify-content: space-evenly;
	
	}
	form{
		width: 40%;
		padding: 0 10px;
	}
	form label{
	font-family: "Roboto",sans-serif;
	color: white;
	text-shadow: 2px 2px black;
	display: block;
	margin-bottom: 10px;
}
form .btn input {
	font-family: "Roboto",sans-serif;
	font-size: 17px; 
	background-color: #135e46;
	color: white; 
	padding: 10px;  
	border: 0;
	border-radius: 10px;
	width: 100%; 
	margin-bottom: 10px;
	cursor: pointer;
	transition:0.3s all;
}
form .btn input:hover {
	background-color: white;
	color:  #135e46;
	transform:scale(0.9);
	box-shadow: 2px 2px black;
	font-family: "Roboto",sans-serif;
}

form p input {
	box-sizing:border-box;
	border: none;
	width: 100%;
	padding: 10px;
	border-radius: 10px;
	border-color: #135e46;
	
}
	

</style>
</head>
<body>
	<section class="contact">
	<h2>MODIFIER UN UTILISATEUR</h2>
	<div class="formAndTable">
	<form action="ModifierUser" method="post">
		<fieldset>
			<legend>Mise à jour utilisateur</legend>
			<p>
				<label for="name">id  user</label>
				<input type="text" name="identifiant" id="identifiant" value="${userid.identifiant }" readonly="readonly"/>
			</p>
			<p>
				<label for="name">Nom user</label>
				<input type="text" name="name" id="name" value="${userid.username }"/>
			</p>
			<p>
				<label for="pass">Password</label>
				<input type="password" name="pass" id="pass" value="${userid.password }"/>
			</p>
			<p class="btn">
				<input type="submit" name="mod" value="Valider"/>
				<input type="reset" name="res" value="Annuler"/>
			</p>
		</fieldset>
	</form>
	<p>${userid.username }</p>
	<p>${userid.password }</p>
	
	<!-- La table pour afficher les enregistrements -->
	<c:if test="${!empty luser }">
		<table>
			  <tr>
			    <th>Numero d'user</th>
			    <th>User name</th>
			    <th>Password</th>
			    <th>Actions</th>
			  </tr>
			  <c:forEach items="${ luser }" var="user">
			  	<tr>
				    <td>${user.identifiant }</td>
				    <td>${user.username }</td>
				    <td>${user.password}</td>
				    <td>
				    	<a href="ModifierUser?param=${user.identifiant }">Modifier</a>
				    	<a href="SupprimerUser?param=${user.identifiant }">Supprimer</a>
				    </td>
			  	</tr>
			  </c:forEach>
		</table>
	</c:if>
</div>
</section>
</body>
</html>