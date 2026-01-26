package app.metier.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import app.metier.models.User;

public class ConnexionForm {
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "passe";
	String resultat;
	Map<String , String> erreurs = new HashMap<String , String>();

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public ConnexionForm() {
		// TODO Auto-generated constructor stub
	}
	
	public User seConnecter(HttpServletRequest request) {
		User user = new User();
		String email = getValeur(request,CHAMP_EMAIL);
		String passe = getValeur(request , CHAMP_PASS);
		//Validation email
		try {
			validationEmail(email);
		}catch(Exception e){
			setErreur(CHAMP_EMAIL,e.getMessage());
		}
		user.setEmail(email);
		//Validation mot de passe
		try {
			validationPasse(passe);
		}catch(Exception e){
			setErreur(CHAMP_PASS,e.getMessage());
		}
		user.setMot_de_passe(passe);
		
		 if ( erreurs.isEmpty() ) {
	            resultat = "Succès de la connexion.";
	        } else {
	            resultat = "Échec de la connexion.";
	        }
	 
		
		
		
		return user;
	}

	private void validationPasse(String passe) throws Exception {
		// TODO Auto-generated method stub
		 if ( passe != null ) {
	            if ( passe.length() < 3 ) {
	                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
	            }
	        } else {
	            throw new Exception( "Merci de saisir votre mot de passe." );
	        }
	        
		
	}

	private void setErreur(String champ, String message) {
		// TODO Auto-generated method stub
		erreurs.put(champ, message);
		
	}

	private void validationEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	private String getValeur(HttpServletRequest request, String nomChamp) {
		// TODO Auto-generated method stub
		String valeur = request.getParameter(nomChamp);
		if(valeur == null || valeur.trim().length() < 0) {
			return null;
		}
		return valeur;
	}
	
	

}
