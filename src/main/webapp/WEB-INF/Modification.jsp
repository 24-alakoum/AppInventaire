<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
<link rel="styleSheet" href="style.css" />
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<div class="main">
<%@ include file="/WEB-INF/asside.jsp" %>
<div class="content">
<center>
<form action="ModifierLigne" method="post" style="width:100%">
		
		<fieldset>
		<p>
		<label for="id">idLigne</label><br/>
		<input type="text" name="idLigne" id="id1" value="${list.idligneInventaire}" readOnly/><br/>
		
		
		<label for="id1">idinventaire</label><br/>
		<input type="text" name="idinventaire" id="id1" value="${list.idinventaire}"/><br/>
		
		<label for="id2">idproduit</label><br/>
		<input type="text" name="idproduit" id="id2"  value="${list.idproduit}"/><br/>
		
		<label for="id3">quantite</label><br/>
		<input type="text" name="quantite" id="id3" value="${list.quantite}"/><br/>
		
		<label for="id4">prix</label><br/>
		<input type="text" name="prix" id="id4" value="${list.prix}"/><br/>
		
		<p>
		<input type="submit" value="Enregistrer"/>
		<input type="reset" value="Annuler"/>
		</p>
		</fieldset>
		
		</form>
		</center>
		</br>
		<!-- 
		<c:if test="${!empty liste }">
		
		<center>
		<table border="2">
		<tr>
		<th>Id Ligne</th>
		<th>idinventaire</th>
		<th>idproduit</th>
		<th>quantite</th>
		<th>prix</th>
		<th>Action</th>
		</tr>
		<c:forEach items="${liste}" var="li">
		<tr>
		<td><center>${li.idligneInventaire }</center></td>
		<td><center>${li.idinventaire }</center></td>
		<td><center>${li.idproduit }</center></td>
		<td><center>${li.quantite }</center></td>
		<td><center>${li.prix }</center></td>
		<td> <a href="SupprimerLigne?param=${li.idinventaire }"/>Supprimer</a><br/>
		<a href="ModifierLigne?param=${li.idinventaire }"/>Modifier</a>
		</td>
		</tr>
		</c:forEach>
		</c:if>
		</table>
		*/
		</center>
		 -->
		 </div>	
	</div>	
</body>
</html>