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
		<fieldset style="max-width: 800px;">
			<legend>Mise à jour Inventaire</legend>
			<input type="hidden" name="idinventaire" value="${inve.idinventaire}" />
			
            <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px;">
                <div>
                    <label>Nom du Comptable</label>
                    <input type="text" name="nomComptable" value="${inve.nomComptable}" required>

                    <label>Boutique</label>
                    <input type="text" name="nomBoutique" value="${inve.nomBoutique}" required>

                    <label>Quartier</label>
                    <input type="text" name="quartier" value="${inve.quartier}" required>
                </div>
                <div>
                    <label>Date d'Inventaire</label>
                    <input type="date" name="dateInventaire" value="<fmt:formatDate value='${inve.dateInventaire}' pattern='yyyy-MM-dd'/>" required>

                    <label>Crédits Clients</label>
                    <input type="number" step="0.01" name="creditsClients" value="${inve.creditsClients}">

                    <label>Dettes Fournisseurs</label>
                    <input type="number" step="0.01" name="dettesFournisseurs" value="${inve.dettesFournisseurs}">
                </div>
            </div>

            <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px; margin-top: 20px;">
                <div>
                    <label>Ancien Compte</label>
                    <input type="number" step="0.01" name="ancienCompte" value="${inve.ancienCompte}">

                    <label>Montant Total Articles</label>
                    <input type="number" step="0.01" name="montantTotal" value="${inve.montantTotal}">
                </div>
                <div>
                    <label>Bénéfice</label>
                    <input type="number" step="0.01" name="benefice" value="${inve.benefice}">

                    <label>Somme de départ</label>
                    <input type="number" step="0.01" name="departSomme" value="${inve.departSomme}">
                </div>
            </div>

            <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px;">
                 <div>
                    <label>Part Gérant</label>
                    <input type="number" step="0.01" name="partGerant" value="${inve.partGerant}">
                </div>
                <div>
                    <label>Part Propriétaire</label>
                    <input type="number" step="0.01" name="partProprietaire" value="${inve.partProprietaire}">
                </div>
            </div>

			<div class="form-btn" style="margin-top: 20px; display: flex; gap: 10px;">
				<button type="submit" class="btn-submit">Enregistrer</button>
				<a href="ListerInventaires" class="btn-submit" style="background: #64748b; text-align: center; text-decoration: none;">Annuler</a>
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