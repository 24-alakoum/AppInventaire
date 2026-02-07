<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter</title>
<style type="text/css">
	.form-actions {
    display: flex;
    justify-content: center;
    margin-top: 25px;
}
.form-card {
    background-color: #ffffff;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.06);
    max-width: 600px;
    margin: 40px auto;
}

.form-card fieldset {
    border: 1px solid #cbd5e1;
    border-radius: 10px;
    padding: 30px;
}

.form-card legend {
    font-size: 22px;
    font-weight: 600;
    color: #0f172a;
}

.form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
}

.form-group label {
    margin-bottom: 6px;
    font-weight: 500;
    color: #334155;
}

.form-group input {
    padding: 10px 12px;
    border-radius: 6px;
    border: 1px solid #cbd5e1;
    font-size: 15px;
}

.form-group input:focus {
    outline: none;
    border-color: #38bdf8;
}

.btn-save {
    background-color: #16a34a;
    color: white;
    border: none;
    padding: 12px 22px;
    border-radius: 6px;
    cursor: pointer;
    font-weight: 500;
    font-size: 16px;
    display: flex;
    align-items: center;
    gap: 8px;
    transition: 0.3s;
     margin-left: 50px;
}

.btn-save:hover {
    background-color: #15803d;    
   
}

.btn-cancel {
    background-color: #64748b;
    color: white;
    padding: 10px 18px;
    border-radius: 6px;
    text-decoration: none;
}

.erreur {
    color: #ef4444;
    font-size: 14px;
    margin-top: 4px;
}

.succes {
    color: #16a34a;
    font-weight: 600;
    font-size: 16px;
    margin-top: 15px;
    text-align: center;
}
</style>
</head>
<body>
	 <form method="post" action="ListerProd" class="form-card">

    <fieldset>
        <legend>AJouter un produit</legend>
        <p>Vous pouvez ajouter un produit</p>

        <div class="form-group">
            <label for="produit">Produit</label>
            <input type="text" id="produit" name="produit" value="" maxlength="20" />
        </div>
		<div class="form-actions">
            <button type="submit" class="btn-save">
                <i class="fa-solid fa-user-plus"></i>Ajouter
            </button>
             <button type="reset" class="btn-save">
                <i class="fa-solid fa-user-plus"></i> Annuler
            </button>
            
            <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
        </div>
    </fieldset>
</form>


<c:if test="${!empty lprod }">
	<table class="styled-table">
        <thead>
            <tr>
                <th>Id Produit</th>
                <th>Nom</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="u" items="${lprod}">
                <tr>
                    <td>${u.idProduct}</td>
                    <td>${u.productName}</td>
                    <td class="actions">
                        <a href="ModifierProduit?param=${u.idProduct}" class="btn-edit">
                            <i class="fa-solid fa-pen"></i>
                        </a>

                        <a href="SupprimerProduit?param=${u.idProduct}" class="btn-delete" onclick="return confirm('Vous etez sur , cette action est irreversible !!!')">
                            <i class="fa-solid fa-trash"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
	
</c:if>
</body>
</html>