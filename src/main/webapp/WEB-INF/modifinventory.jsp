<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Inventory</title>
<link rel="styleSheet" href="style.css" />
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<div class="main">
<%@ include file="/WEB-INF/asside.jsp" %>
<div class="content">
<form action="ModifierInventaire" method="POST">
		<fieldset>
			<legend>Mise à jour Inventaire</legend>
			<div class="col">
				<label>N°  d'inventaire</label>
				<input type="number" name="idinventaire" id="idinventaire" size=20 placeholder="Entrez le numéro de la carte" value="${inve.idinventaire}" readonly  />
			</div>
			
			<div class="col">
				<select name=idutilisateur>
				<option value="#">Choisissez un utilisateur</option>
					<c:forEach items="${luser }" var="user">
						<option value="${user.id }">${user.prenom }&nbsp;${user.nom }</option>
					</c:forEach>
			</select>
			</div>
			
			<div class="ligne">
				<div class="col">
					<label>Date d'inventaire</label>
					<input type="date" name="dateinventaire"  value="<fmt:formatDate value='${inve.dateInventaire}' pattern='yyyy-MM-dd'/>">

				</div>
			</div>
			<div class="form-btn">
				<input type="submit" name="Ok" value="Enregistrer"  />
				<input type="reset" name="No_Ok" value="Annuler"  />
			</div>
		</fieldset>
	</form>
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
				<td>${ inve.idinventaire }</td>
				<td>${ inve.idutilisateur }</td>
				<td>${ inve.dateInventaire }</td>
				
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