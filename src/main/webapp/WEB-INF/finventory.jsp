<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="style.css" />
</head>
<body>

<%@ include file="/WEB-INF/header.jsp" %>
<div class="main">
<%@ include file="/WEB-INF/asside.jsp" %>
<div class="content">

<form action="EnregistrerInventory" method="POST" >
	<fieldset style="width : 100%;">
		<legend >Nouvelle  Inventaire</legend>
		<p>
			<label>Date d'inventaure</label>
			<input type="date" size="25" name="dateInventaire" />
		</p>
		
		<p>
			<label>Utilisateur</label>
			<select name=idutilisateur>
				<option value="#">Choisissez un usager</option>
					<c:forEach items="${luser }" var="user">
						<option value="${user.id }">${user.prenom }&nbsp;${user.nom }</option>
					</c:forEach>
			</select>
		</p>
		
		
		
	</fieldset>
	<input type="submit" name="send" value="Envoyer"  />
	<input type="reset" name="cancel" value="Réinitialiser"  />
</form>
<br />

<br />
<c:if test="${!empty linve }">
<h2>LISTE DES INVENTAIRE</h2>
	<table border="1px" style="border-collapse: collapse">
		<tr>
			<th>ID Inventaire</th>
			<th>Utilisateur</th>
			<th>Date Inventaire</th>
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${linve }" var="inve">
			<tr>
				<td>${inve.idinventaire }</td>
				<td>${inve.idutilisateur }</td>
				<td>${inve.dateInventaire }</td>
				
				<td class="icons">
						<a href="ModifierInventaire?param=${inve.idinventaire}" ><img height="24px" width="24px" alt="icon modifier" src="images/edit.png"></a>
						<a href="SupprimerInventaire?param=${inve.idinventaire }" ><img height="24px" width="24px" alt="icon supprimer" src="images/delete.png"></a>
				</td>
				
			</tr>	
		</c:forEach>
	</table>
</c:if>
<c:if test="${empty linve }">
	<div style="margin-left : 12px;">
		<h4>Aucun Inventaire à afficher</h4>
	</div>
</c:if>

</div>	
	</div>	
</body>
</html>