<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des inventaires</title>
<style type="text/css">
/* ===== GLOBAL ===== */
body {
    background: linear-gradient(135deg, #020617, #0f172a);
    font-family: 'Segoe UI', Tahoma, sans-serif;
    color: #000;
}

/* ===== CONTAINER FORM ===== */
.form-container {
    background: #111827;
    padding: 30px;
    border-radius: 16px;
    width: 420px;
    box-shadow: 0 20px 40px rgba(0,0,0,0.6);
    margin: 0 5%;
}

/* ===== TITRES ===== */
.form-container h2 {
    text-align: center;
    margin-bottom: 25px;
    font-weight: 600;
    color: #f8fafc;
}

/* ===== LABELS ===== */
label {
    display: block;
    margin-bottom: 6px;
    color: #94a3b8;
    font-size: 14px;
}

/* ===== INPUTS ===== */
input {
    width: 100%;
    padding: 12px 14px;
    border-radius: 10px;
    border: 1px solid #1e293b;
    background-color: #020617;
    color: #e5e7eb;
    font-size: 15px;
    transition: all 0.3s ease;
}

input::placeholder {
    color: #64748b;
}

input:focus {
    outline: none;
    border-color: #22c55e;
    box-shadow: 0 0 0 2px rgba(34,197,94,0.3);
}

/* ===== BOUTONS ===== */
.btn {
    width: 100%;
    padding: 12px;
    border-radius: 12px;
    border: none;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
}

/* Valider */
.btn-success {
    background: linear-gradient(135deg, #22c55e, #16a34a);
    color: #022c22;
}

.btn-success:hover {
    transform: translateY(-2px);
    box-shadow: 0 10px 25px rgba(34,197,94,0.4);
}

/* Annuler */
.btn-danger {
    background: linear-gradient(135deg, #ef4444, #dc2626);
    color: #fff;
    margin-top: 10px;
}

.btn-danger:hover {
    transform: translateY(-2px);
    box-shadow: 0 10px 25px rgba(239,68,68,0.4);
}

/* ===== TABLE ===== */
table {
    width: 80%;
    border-collapse: collapse;
    margin: 40px 10%;
    background: #020617;
    border-radius: 14px;
    overflow: hidden;
    color: black;
}

th {
    background: #111827;
    color: #22c55e;
    padding: 14px;
    text-align: left;
    font-size: 14px;
}

td {
    padding: 12px 14px;
    border-bottom: 1px solid #1e293b;
    color: #e5e7eb;
    font-size: 14px;
}

tr:hover {
    background: #0f172a;
}

/* ===== ACTIONS ===== */
a {
    color: #38bdf8;
    text-decoration: none;
    font-weight: 500;
}

a:hover {
    text-decoration: underline;
}



/* TITRE PAGE */
.page-title {
    font-size: 28px;
    margin-bottom: 25px;
    color: white;
    text-align: center;
}

/* BOUTONS HAUT */
.top-actions {
    display: flex;
    justify-content: space-between;
    margin: 25px 10%;
     width: 80%;
     
}

.btn-add, .btn-home {
    padding: 10px 18px;
    border-radius: 6px;
    text-decoration: none;
    color: white;
    font-weight: 500;
}

.btn-add {
    background-color: #16a34a;
}

.btn-home {
    background-color: #0ea5e9;
}

/* TABLEAU MODERNE */
.styled-table {
    width: 80%;
    border-collapse: collapse;
    background-color: white;
    margin: 25px 10%;
    box-shadow: 0 8px 20px rgba(0,0,0,0.06);
    border-radius: 10px;
    overflow: hidden;
    color: black;
}

.styled-table thead {
    background-color: #0f172a;
    color: white;
    
}

.styled-table th, .styled-table td {
    padding: 14px 16px;
    text-align: left;
        
}

.styled-table td {
color: black;}

.styled-table tbody tr {
    border-bottom: 1px solid #e2e8f0;
}

.styled-table tbody tr:hover {
    background-color: #f1f5f9;
}

/* ACTIONS */
.actions {
    display: flex;
    gap: 10px;
}

.btn-edit, .btn-delete {
    padding: 8px 10px;
    border-radius: 6px;
    color: white;
    text-decoration: none;
}

.btn-edit {
    background-color: #f59e0b;
}

.btn-delete {
    background-color: #ef4444;
}




</style>
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
	<div class="container">

    <h2 class="page-title">
        <i class="fa-solid fa-users"></i> Liste des des produits
    </h2>

    <div class="top-actions">
        <a href="AjouterProduit" class="btn-add">
            <i class="fa-solid fa-user-plus"></i> Ajouter un produit
        </a>

        <a href="index.jsp" class="btn-home">
            <i class="fa-solid fa-house"></i> Accueil
        </a>
    </div>

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

</div>
</body>
</html>