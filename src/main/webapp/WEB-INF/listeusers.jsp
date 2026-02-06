<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des inventaires</title>
<style type="text/css">
body{
	background-color: #f1f5f9;
}
	section{
	margin: 50px auto;
	width: 80%;
	background-color: #fff;
	box-shadow: 2px 2px 0 rgba(0,0,0,0.4);
	padding: 10px;
	border-radius: 10px 5px 0 5px;
	font-family: verdana ,Arial,sans-serif;
	font-size: 1rem;
	}
	table {
	border-collapse: collapse;
	width: 100%;
	margin: auto;
}
td,th{
border: 1px solid;
}
caption{
color:white;
margin-top: 10px;
margin-bottom: 10px;

}
</style>
</head>
<body>
	<section>
	 <c:if test="${!empty luser }">
	<table class="table table-striped table-dark table-hover container text-center table-bordered caption-top table-rounded-2 " >
		<caption class="text-center fw-bolder display-3 w-full">LISTE DES UTILISATEURS</caption>
		<tr>
			<th>Id user</th>
			<th>nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<th>Telephone</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${ luser }" var ="user">
			<tr>
				<td>${user.id} </td>
				<td>${user.nom}</td>
				<td>${user.prenom} </td>
				<td>${user.email}</td>
				<td>${user.telephone}  </td>
				<td>
					<a href="ModifierUser?param=${user.id }">Modifier</a>
					<a href="SupprimerUser?param=${user.id }" onclick="return confirm('Etez-vous sur')">Supprimer</a>
				</td>
				
			<tr>
		</c:forEach>
	</table>
</c:if> 
</section>
<div>
	<button><a href="">Ajouter un utilisateur</a></button>
	<a href="${pageContext.request.contextPath }/index.jsp">Accueil</a>
	
</div>
</body>
</html>