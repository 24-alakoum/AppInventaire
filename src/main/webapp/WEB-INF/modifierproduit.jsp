<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Produit - AppInv</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <form action="ModifierProduit" method="post">
            <fieldset>
                <legend>Modifier Produit</legend>
                <input type="hidden" name="id" value="${produit.idProduct}">
                <label for="produit">Nom du Produit</label>
                <input type="text" name="produit" id="produit" value="${produit.productName}" required>
                <button type="submit" class="btn-submit">Mettre à jour</button>
                <a href="ListerProd" class="btn-submit" style="background: #64748b; text-align: center; text-decoration: none; display: block; margin-top: 10px;">Annuler</a>
            </fieldset>
        </form>
    </div>
</body>
</html>
