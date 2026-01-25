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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>
	<section class="contact">
	<h2>ENREGISTRER UN NOUVEL UTILISATEUR</h2>
	<div class="formAndTable">
	<form action="EnregistrerUser" method="post">
		<fieldset>
			<legend>Un nouvel utilisateur</legend>
			<p>
				<label for="name">Nom user</label>
				<input type="text" name="name" id="name"/>
			</p>
			<p>
				<label for="pass">Password</label>
				<input type="password" name="pass" id="pass"/>
			</p>
			<p class="btn">
				<input type="submit" name="ok" value="Ajouter"/>
				<input type="reset" name="Nok" value="Annuler"/>
			</p>
		</fieldset>
	</form>
	
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
				    	<a href="ModifierUser?param=${user.identifiant }" class="btn btn-primary btn-sm">Modifier</a>
				    	<a href="SupprimerUser?param=${user.identifiant }" onclick= " return supp('${user.username }')" class="btn btn-danger btn-sm">Supprimer</a>
				    </td>
			  	</tr>
			  </c:forEach>
		</table>
	</c:if>
</div>
</section>

<script type="text/javascript">
	function supp(name) {
		return confirm("Voulez-vous supprimer vraiment cet element ? ");
	}
</script>
</body>
</html>