<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouvel Inventaire - AppInv</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        .inventory-header {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .inventory-footer {
            margin-top: 30px;
            background: #f8fafc;
            padding: 20px;
            border-radius: 12px;
            border: 1px solid #e2e8f0;
        }
        .dynamic-table input {
            margin-bottom: 0;
            padding: 5px;
        }
        .total-row {
            font-weight: bold;
            background: #f1f5f9;
        }
        .profit-sharing {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <header style="background: #0f172a; color: white; padding: 15px 40px; display: flex; justify-content: space-between; align-items: center;">
        <h2><i class="fa-solid fa-boxes-stacked"></i> AppInv</h2>
        <nav>
            <a href="index.jsp" style="color: white; margin-right: 20px; text-decoration: none;">Accueil</a>
            <a href="ListerInventaires" style="color: white; margin-right: 20px; text-decoration: none;">Mes Inventaires</a>
        </nav>
    </header>

    <div class="container" style="max-width: 1000px;">
        <form id="inventoryForm" action="EnregistrerInventory" method="POST">
            <h1>Saisie d'Inventaire</h1>

            <div class="inventory-header">
                <div>
                    <label>Nom du Comptable</label>
                    <input type="text" name="nomComptable" required placeholder="Ex: Jean Dupont">

                    <label>Boutique</label>
                    <input type="text" name="nomBoutique" required placeholder="Ex: Boutique Centrale">
                </div>
                <div>
                    <label>Date d'Inventaire</label>
                    <input type="date" name="dateInventaire" required>

                    <label>Quartier</label>
                    <input type="text" name="quartier" required placeholder="Ex: Akwa">
                </div>
            </div>

            <h3>Lignes d'Inventaire</h3>
            <div class="table-container">
                <table class="dynamic-table" id="lineTable">
                    <thead>
                        <tr>
                            <th>Produit</th>
                            <th style="width: 150px;">Quantité</th>
                            <th style="width: 150px;">Prix Unitaire</th>
                            <th style="width: 150px;">Montant</th>
                            <th style="width: 50px;"></th>
                        </tr>
                    </thead>
                    <tbody id="lineBody">
                        <!-- Dynamic rows will be added here -->
                    </tbody>
                    <tfoot>
                        <tr class="total-row">
                            <td colspan="3" class="text-right">Montant Total des Articles:</td>
                            <td id="grandTotal">0.00</td>
                            <td></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <button type="button" onclick="addRow()" class="btn-submit" style="width: auto; background: #38bdf8; color: #0f172a; margin-top: 10px;">
                <i class="fa-solid fa-plus"></i> Ajouter une ligne (ou Entrée)
            </button>

            <div class="inventory-footer">
                <div class="profit-sharing">
                    <div>
                        <label>Crédits Clients</label>
                        <input type="number" step="0.01" name="creditsClients" value="0" onchange="calculateCalculations()">

                        <label>Dettes Fournisseurs</label>
                        <input type="number" step="0.01" name="dettesFournisseurs" value="0" onchange="calculateCalculations()">

                        <label>Ancien Compte</label>
                        <input type="number" step="0.01" name="ancienCompte" value="0" onchange="calculateCalculations()">
                    </div>
                    <div style="background: white; padding: 15px; border-radius: 8px; border: 1px solid #cbd5e1;">
                        <p><strong>Bénéfice/Perte: </strong> <span id="beneficeDisplay">0.00</span></p>
                        <p>Part Gérant: <span id="partGerantDisplay">0.00</span></p>
                        <p>Part Propriétaire: <span id="partProprietaireDisplay">0.00</span></p>
                        <hr style="margin: 10px 0;">
                        <p style="font-weight: bold; color: #16a34a;">Départ de la nouvelle personne à la somme de: <span id="departSommeDisplay">0.00</span></p>
                    </div>
                </div>

                <!-- Hidden inputs for calculated values -->
                <input type="hidden" name="montantTotal" id="montantTotalInput">
                <input type="hidden" name="benefice" id="beneficeInput">
                <input type="hidden" name="partGerant" id="partGerantInput">
                <input type="hidden" name="partProprietaire" id="partProprietaireInput">
                <input type="hidden" name="departSomme" id="departSommeInput">
                <input type="hidden" name="isManagerOwner" value="false"> <!-- Toggle if needed -->

                <div style="margin-top: 20px; display: flex; gap: 10px;">
                    <button type="submit" class="btn-submit" style="background: #16a34a;">Enregistrer l'Inventaire</button>
                    <a href="ListerInventaires" class="btn-submit" style="background: #64748b; text-align: center; text-decoration: none;">Annuler</a>
                </div>
            </div>
        </form>
    </div>

    <script>
        const products = [
            <c:forEach items="${lpds}" var="p">
                {id: ${p.idProduct}, name: '${p.productName}'},
            </c:forEach>
        ];

        function addRow() {
            const tbody = document.getElementById('lineBody');
            const rowId = Date.now();
            const tr = document.createElement('tr');
            tr.id = `row-${rowId}`;

            let productOptions = products.map(p => `<option value="${p.id}">${p.name}</option>`).join('');

            tr.innerHTML = `
                <td>
                    <select name="idproduit" required style="margin-bottom: 0;">
                        <option value="">Sélectionner...</option>
                        ${productOptions}
                    </select>
                </td>
                <td><input type="number" name="quantite" step="0.01" required value="0" oninput="calculateRow(${rowId})" style="margin-bottom: 0;"></td>
                <td><input type="number" name="prix" step="0.01" required value="0" oninput="calculateRow(${rowId})" style="margin-bottom: 0;"></td>
                <td class="row-montant" id="montant-${rowId}">0.00</td>
                <td><button type="button" onclick="removeRow(${rowId})" style="background: none; border: none; color: #ef4444; cursor: pointer;"><i class="fa-solid fa-trash"></i></button></td>
            `;

            tbody.appendChild(tr);
            tr.querySelector('select').focus();
        }

        function removeRow(id) {
            document.getElementById(`row-${id}`).remove();
            calculateCalculations();
        }

        function calculateRow(id) {
            const row = document.getElementById(`row-${id}`);
            const qte = parseFloat(row.querySelector('input[name="quantite"]').value) || 0;
            const prix = parseFloat(row.querySelector('input[name="prix"]').value) || 0;
            const montant = qte * prix;
            document.getElementById(`montant-${id}`).innerText = montant.toFixed(2);
            calculateCalculations();
        }

        function calculateCalculations() {
            // 1. Grand Total Articles
            let totalArticles = 0;
            document.querySelectorAll('.row-montant').forEach(td => {
                totalArticles += parseFloat(td.innerText) || 0;
            });
            document.getElementById('grandTotal').innerText = totalArticles.toFixed(2);
            document.getElementById('montantTotalInput').value = totalArticles;

            // 2. Benefice Calculation
            const credits = parseFloat(document.querySelector('input[name="creditsClients"]').value) || 0;
            const dettes = parseFloat(document.querySelector('input[name="dettesFournisseurs"]').value) || 0;
            const ancienCompte = parseFloat(document.querySelector('input[name="ancienCompte"]').value) || 0;

            // Nouveau Compte = Total Articles + Credits - Dettes
            const nouveauCompte = totalArticles + credits - dettes;
            const benefice = nouveauCompte - ancienCompte;

            document.getElementById('beneficeDisplay').innerText = benefice.toFixed(2);
            document.getElementById('beneficeInput').value = benefice;
            document.getElementById('beneficeDisplay').className = benefice >= 0 ? 'badge-success' : 'badge-error';

            // 3. Sharing logic (e.g., 50/50 split if not owner)
            let partGerant = 0;
            let partProprietaire = 0;
            if (benefice > 0) {
                partGerant = benefice * 0.5;
                partProprietaire = benefice * 0.5;
            }

            document.getElementById('partGerantDisplay').innerText = partGerant.toFixed(2);
            document.getElementById('partProprietaireDisplay').innerText = partProprietaire.toFixed(2);
            document.getElementById('partGerantInput').value = partGerant;
            document.getElementById('partProprietaireInput').value = partProprietaire;

            // 4. Départ nouvelle personne
            // Usually Nouveau Compte or Ancien Compte + Profit
            const depart = nouveauCompte;
            document.getElementById('departSommeDisplay').innerText = depart.toFixed(2);
            document.getElementById('departSommeInput').value = depart;
        }

        // Handle Enter key
        document.addEventListener('keydown', function(event) {
            if (event.key === 'Enter') {
                event.preventDefault();
                addRow();
            }
        });

        // Initialize with one row
        window.onload = addRow;
    </script>
</body>
</html>
