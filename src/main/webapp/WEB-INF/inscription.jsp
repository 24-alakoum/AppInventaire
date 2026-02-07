<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <link type="text/css" rel="stylesheet" href="form.css" />

        <style type="text/css">
        
        
       
    
    
    
.btn-cancel {
    background-color: #64748b;
    color: white;
    padding: 10px 18px;
    border-radius: 6px;
    text-decoration: none;
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

/* ERREURS & SUCCES */
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
    
    /* BOUTON INSCRIPTION */
.form-actions {
    display: flex;
    justify-content: center;
    margin-top: 25px;
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
}

.btn-save:hover {
    background-color: #15803d;
}
    
          
        </style>
    </head>
    <body>
      <form method="post" action="Inscription" class="form-card">

    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <div class="form-group">
            <label for="nom">Nom d'utilisateur</label>
            <input type="text" id="nom" name="nom" value="" maxlength="20" />
            <span class="erreur">${erreurs['nom']}</span>
        </div>

        <div class="form-group">
            <label for="prenom">Prénom d'utilisateur</label>
            <input type="text" id="prenom" name="prenom" value="" maxlength="20" />
            <span class="erreur">${erreurs['prenom']}</span>
        </div>

        <div class="form-group">
            <label for="email">Adresse email <span class="requis">*</span></label>
            <input type="email" id="email" name="email" value="" maxlength="60" />
            <span class="erreur">${erreurs['email']}</span>
        </div>

        <div class="form-group">
            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
            <input type="password" id="motdepasse" name="motdepasse" maxlength="20" />
            <span class="erreur">${erreurs['motdepasse']}</span>
        </div>

        <div class="form-group">
            <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
            <input type="password" id="confirmation" name="confirmation" maxlength="20" />
            <span class="erreur">${erreurs['confirmation']}</span>
        </div>

        <div class="form-group">
            <label for="telephone">Téléphone d'utilisateur</label>
            <input type="text" id="telephone" name="telephone" value="" maxlength="20" />
            <span class="erreur">${erreurs['telephone']}</span>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn-save">
                <i class="fa-solid fa-user-plus"></i> S'inscrire
            </button>
        </div>

        <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>

    </fieldset>
</form>

        <br>
        
    </body>
</html>