<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenue sur AppInv</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        .hero {
            height: 100vh;
            background: linear-gradient(135deg, #0f172a 0%, #1e293b 100%);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            color: white;
            text-align: center;
            padding: 20px;
        }
        .hero h1 {
            font-size: 4rem;
            margin-bottom: 20px;
            font-weight: 800;
        }
        .hero p {
            font-size: 1.5rem;
            margin-bottom: 40px;
            max-width: 800px;
            color: #94a3b8;
        }
        .cta-buttons {
            display: flex;
            gap: 20px;
        }
        .btn-primary {
            background-color: #38bdf8;
            color: #0f172a;
            padding: 15px 30px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            font-size: 1.1rem;
            transition: 0.3s;
        }
        .btn-primary:hover {
            background-color: #7dd3fc;
            transform: translateY(-2px);
        }
        .btn-secondary {
            border: 2px solid #38bdf8;
            color: #38bdf8;
            padding: 15px 30px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            font-size: 1.1rem;
            transition: 0.3s;
        }
        .btn-secondary:hover {
            background-color: rgba(56, 189, 248, 0.1);
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="hero">
        <h1><i class="fa-solid fa-boxes-stacked"></i> AppInv</h1>
        <p>Gérez votre inventaire avec une simplicité déconcertante. Suivez vos produits, vos ventes et vos bénéfices en temps réel.</p>
        <div class="cta-buttons">
            <a href="Login" class="btn-primary">Commencer maintenant</a>
            <a href="Inscription" class="btn-secondary">Créer un compte</a>
        </div>
    </div>
</body>
</html>
