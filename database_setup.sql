-- Création de la base de données
CREATE DATABASE IF NOT EXISTS appinventaire CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE appinventaire;

-- Table : utilisateur
CREATE TABLE IF NOT EXISTS utilisateur (
    idutilisateur BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    telephone VARCHAR(20),
    role VARCHAR(20) DEFAULT 'standard'
) ENGINE=InnoDB;

-- Table : produit
CREATE TABLE IF NOT EXISTS produit (
    idproduit INT AUTO_INCREMENT PRIMARY KEY,
    nomProduit VARCHAR(150) NOT NULL
) ENGINE=InnoDB;

-- Table : inventaire
CREATE TABLE IF NOT EXISTS inventaire (
    idinventaire INT AUTO_INCREMENT PRIMARY KEY,
    idutilisateur INT NOT NULL,
    dateInventaire DATE NOT NULL,
    nomComptable VARCHAR(100),
    nomBoutique VARCHAR(100),
    quartier VARCHAR(100),
    creditsClients DOUBLE DEFAULT 0,
    dettesFournisseurs DOUBLE DEFAULT 0,
    ancienCompte DOUBLE DEFAULT 0,
    montantTotal DOUBLE DEFAULT 0,
    benefice DOUBLE DEFAULT 0,
    partGerant DOUBLE DEFAULT 0,
    partProprietaire DOUBLE DEFAULT 0,
    departSomme DOUBLE DEFAULT 0
) ENGINE=InnoDB;

-- Table : ligneinventaire
CREATE TABLE IF NOT EXISTS ligneinventaire (
    idligneInventaire BIGINT AUTO_INCREMENT PRIMARY KEY,
    idinventaire INT NOT NULL,
    idproduit INT NOT NULL,
    quantite DOUBLE NOT NULL,
    prix DOUBLE NOT NULL,
    CONSTRAINT fk_inventaire FOREIGN KEY (idinventaire) REFERENCES inventaire(idinventaire) ON DELETE CASCADE,
    CONSTRAINT fk_produit FOREIGN KEY (idproduit) REFERENCES produit(idproduit)
) ENGINE=InnoDB;

-- Création de la vue pour les rapports d'inventaire
CREATE OR REPLACE VIEW inventoryView3 AS
SELECT
    i.idinventaire,
    i.dateInventaire,
    l.idligneInventaire,
    p.nomProduit,
    l.quantite,
    l.prix,
    u.nom,
    u.prenom,
    u.telephone
FROM inventaire i
JOIN ligneinventaire l ON i.idinventaire = l.idinventaire
JOIN produit p ON l.idproduit = p.idproduit
JOIN utilisateur u ON i.idutilisateur = u.idutilisateur;

-- Insertion de données de test (Contenu par défaut)

-- Utilisateurs (Le mot de passe 'admin123' est haché ici via SHA2)
-- Utilisateurs (Mots de passe hachés en SHA-256 via PasswordUtil.java)
-- admin123 -> 240be518ebb21460511d664174e1d3c8801128484e3a35d944e976694665373a
-- user123  -> a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3
INSERT INTO utilisateur (nom, prenom, email, mot_de_passe, telephone, role) VALUES
('Administrateur', 'Super', 'admin@appinv.com', '240be518ebb21460511d664174e1d3c8801128484e3a35d944e976694665373a', '600000000', 'super'),
('Doe', 'John', 'john@example.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '611111111', 'standard');

-- Produits
INSERT INTO produit (nomProduit) VALUES
('Riz Parfumé 5kg'),
('Huile Végétale 1L'),
('Sucre en Poudre 1kg'),
('Lait en Poudre 500g'),
('Savon de Marseille'),
('Pâtes Alimentaires 500g');

-- Un exemple d'inventaire pour visualiser
INSERT INTO inventaire (idutilisateur, dateInventaire, nomComptable, nomBoutique, quartier, creditsClients, dettesFournisseurs, ancienCompte, montantTotal, benefice, partGerant, partProprietaire, departSomme) VALUES
(1, CURDATE(), 'Jean Comptable', 'Boutique du Coin', 'Akwa', 5000, 2000, 50000, 150000, 103000, 51500, 51500, 153000);

-- Lignes associées à cet inventaire
INSERT INTO ligneinventaire (idinventaire, idproduit, quantite, prix) VALUES
(1, 1, 10, 4500),
(1, 2, 20, 1100),
(1, 3, 15, 800);
