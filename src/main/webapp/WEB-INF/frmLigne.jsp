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
 
<!-- MENU -->
    <div class="menu-container">
        <ul class="menu">
            <li><a href="EnregistrerInventory">Créer un inventaire</a></li>
            <li><a href="#">Créer un produit</a></li>
            <li><a href="#">Utilisateur</a></li>
        </ul>
    </div>
    <!-- MAIN -->
   <div class="main">
	<%@ include file="/WEB-INF/asside.jsp" %>
	
<!-- MODAL -->
<div class="modal" id="modal">
   <div class="modal-content">	
   <button class="close" onclick="closeModal()">X</button>
           

<form action="EnregistrerLigne" method="post" style="align-text:center;">
	<fieldset style="width : 95%;">
		<p>
		<label>N° d'invantaire</label>
			<select name=idinventaire>
			<option value="#">Choisissez le N° d'invantaire</option>
			<c:forEach items="${linve}" var="inve">
				<option value="${inve.idinventaire }">${inve.idinventaire }&nbsp;${inve.dateInventaire }</option>
			</c:forEach>
		</select>
		</p>
		
		<p>
		<label>Produit</label>
			<select name=idproduit>
			<option value="#">Choisissez un produit</option>
			<c:forEach items="${lprod}" var="prod">
				<option value="${prod.idProduct }">${prod.productName }</option>
			</c:forEach>
		</select>
		</p>
		
		<p>
			<label>Quantité</label>
			<input type="number" size="10" name="quantite" style="width:95%"/>
		</p>
		
		<p>
			<label>Prix</label>
			<input type="number" size="10" name="prix" style="width:95%"/>
		</p>
		
		
	</fieldset>
	<br>
	
	<input type="submit" name="send" value="Envoyer" class="save" />
	<input type="reset" name="cancel" value="Réinitialiser"  />
	
</form>
</div>
  </div>

<c:if test="${!empty lister }">
<div class="content">
            <button class="add-btn" onclick="openModal()">+ Ajouter Inventaire</button>
            <h3>Nouvel Inventaire</h3>
            
            <form action="ViewBynumInvenaire" method="post" >
		
				<legend>Voir le fiche inventaire par N° inventaire :</legend>
				<input type="number" name="numRech" />
				<div class="form-btn">
					<input type="submit" name="ok2" value="Valider" />
				</div>
		</form>
	<table border="1px" style="border-collapse: collapse">
		<tr>
			<th>ID Linge Inventaire</th>
			<th>ID inventaire</th>
			<th>ID produit</th>
			<th>Quantité</th>
			<th>Prix unitaire</th>
			<th>Montant</th>
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${lister }" var="lginve">
			<tr>
				<td>${ lginve.idligneInventaire }</td>
				<td>${ lginve.idinventaire }</td>
				<td>${ lginve.idproduit }</td>
				<td>${ lginve.quantite }</td>
				<td>${ lginve.prix }</td>
				<td>${ lginve.montant }</td>
				<td class="icons">
						<a href="ModifierLigne?param=${lginve.idligneInventaire}" ><img height="24px" width="24px" alt="icon modifier" src="images/edit.png"></a>
						<a href="SupprimerLigne?param=${lginve.idligneInventaire }" ><img height="24px" width="24px" alt="icon supprimer" src="images/delete.png"></a>
				</td>
				
			</tr>	
		</c:forEach>
	</table>
	</div>
</c:if>
<c:if test="${empty linve }">
	<div style="margin-left : 12px;">
		<h4>Aucun Inventaire à afficher</h4>
	</div>
</c:if>
	<!-- <center>
	<fieldset>
		<legend>Informations de la ligne</legend>
<p>
<label for="id1">idinventaire</label><br/>
<input type="text" name="idinventaire" id="id1"/><br/>

<label for="id2">idproduit</label><br/>
<input type="text" name="idproduit" id="id2"/><br/>

<label for="id3">quantite</label><br/>
<input type="text" name="quantite" id="id3"/><br/>

<label for="id4">prix</label><br/>
<input type="text" name="prix" id="id4"/><br/>

<p>
<input type="submit" value="Enregistrer"/>
<input type="reset" value="Annuler"/>
</p>
</fieldset>
</center>
</form>
</br> 

<c:if test="${!empty lister }">
<center>
<table border="2">
<tr>
<th>Id Ligne</th>
<th>Id Inventaire</th>
<th>Id Produit</th>
<th>Quantité</th>
<th>Prix</th>
<th>Montant</th>
<th>Action</th>
</tr>
<c:forEach items="${lister}" var="li">
<tr>
<td><center>${li.idligneInventaire }</center></td>
<td><center>${li.idinventaire }</center></td>
<td><center>${li.idproduit }</center></td>
<td><center>${li.quantite }</center></td>
<td><center>${li.prix }</center></td>
<td><center>${li.montant } FCFA</center></td>
<td><a href="SupprimerLigne?param=${li.idligneInventaire }"/>Supprimer</a></br>
<a href="ModifierLigne?param=${li.idligneInventaire }"/>Modifier</a>
</td>
</tr>
</c:forEach>
</c:if>
</table>
</center>
 -->
 </div>
 
 <script>
        function openModal() {
            document.getElementById("modal").style.display = "flex";
        }

        function closeModal() {
            document.getElementById("modal").style.display = "none";
        }
    </script>
</body>
</html>