<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mes Inventaires - AppInv</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <header style="background: #0f172a; color: white; padding: 15px 40px; display: flex; justify-content: space-between; align-items: center;">
        <h2><i class="fa-solid fa-boxes-stacked"></i> AppInv</h2>
        <nav>
            <a href="index.jsp" style="color: white; margin-right: 20px; text-decoration: none;">Accueil</a>
            <a href="Deconnecter" style="color: #ef4444; text-decoration: none; font-weight: bold;">Déconnexion</a>
        </nav>
    </header>

    <div class="container">
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1>Mes Inventaires</h1>
            <a href="EnregistrerInventory" class="btn-submit" style="text-decoration: none; width: auto; padding: 10px 20px;">Nouvel Inventaire</a>
        </div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Comptable</th>
                        <th>Boutique</th>
                        <th>Total</th>
                        <th>Bénéfice</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="inv" items="${linv}">
                        <tr>
                            <td>${inv.dateInventaire}</td>
                            <td>${inv.nomComptable}</td>
                            <td>${inv.nomBoutique}</td>
                            <td>${inv.montantTotal}</td>
                            <td>
                                <span class="badge ${inv.benefice >= 0 ? 'badge-success' : 'badge-error'}">
                                    ${inv.benefice}
                                </span>
                            </td>
                            <td>
                                <a href="ViewBynumInvenaire?idinventaire=${inv.idinventaire}" title="Voir"><i class="fa-solid fa-eye"></i></a>
                                <a href="ModifierInventaire?idinventaire=${inv.idinventaire}" title="Modifier" style="margin-left: 10px; color: #f39c12;"><i class="fa-solid fa-pen"></i></a>
                                <a href="SupprimerInventaire?idinventaire=${inv.idinventaire}" title="Supprimer" style="margin-left: 10px; color: #e74c3c;"><i class="fa-solid fa-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty linv}">
                        <tr>
                            <td colspan="6" class="text-center">Aucun inventaire trouvé.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
