<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Fiche d'Inventaire - Boutique Alimentaire</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<c:if test="${!empty linvtv }">

    <div class="fiche">
    <caption>Liste des déclarations : ${numRech } </caption>
        <h1>FICHE D’INVENTAIRE</h1>
        <h3>Boutique de Vente de Produits Alimentaires</h3>

        <div class="infos">
            <div>
                <p><strong>Nom de la boutique :</strong> ____________________</p>
                <p><strong>Adresse :</strong> ______________________________</p>
                <p><strong>Téléphone :</strong>${invtv.telephone}</p>
            </div>
            <div>
                <p><strong>Date d’inventaire :</strong>${invtv.dateInventaire}</p>
                <p><strong>Responsable :</strong> ${invtv.nom}</p>
                <p><strong>Référence fiche :</strong>${invtv.idinventaire}</p>
            </div>
        </div>
		
        <table>
            <thead>
            
                <tr>
                    <th>ID</th>
                    <th>Produit</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Montant</th>
                </tr>
            </thead>
            <tbody>
            <c:set var="total" value="0" />
            <c:forEach items="${linvtv}" var="item">
                <tr>
                    <td>${item.idligneInventaire}</td>
                    <td>${item.nomProduit}</td>
                    <td>${item.quantite}</td>
                    <td>${item.prix}</td>
                    <td>${item.prix * item.quantite}</td>
                    <c:set var="total" value="${total + (item.prix * item.quantite)}" />
                </tr>
                </c:forEach>
                <tr style="font-weight: bold; background: #f1f5f9;">
                    <td colspan="4" style="text-align: right;">Total Articles:</td>
                    <td>${total}</td>
                </tr>
            </tbody>
        </table>
        </c:if>

        <div class="footer">
            <div class="signature">
                <p>Signature du Responsable</p>
                ___________________________
            </div>
            </div>
            

          