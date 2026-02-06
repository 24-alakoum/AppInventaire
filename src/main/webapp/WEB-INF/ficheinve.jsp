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
                    <th>ref</th>
                    <th>Produit</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Montant</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${linvtv }" var="invtv">
                <tr>
                    <td>ref</td>
                    <td>${invtv.nomProduit}</td>
                    <td>${invtv.quantite}</td>
                    <td>${invtv.prix}</td>
                    <td>${invtv.prix * quantite}</td>
                   
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
        </c:if>

        <div class="footer">
            <div class="signature">
                <p>Signature du Responsable</p>
                ___________________________
            </div>
            </div>
            

          