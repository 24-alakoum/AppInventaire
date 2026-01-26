package app.metier.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String  VUE= "/WEB-INF/inscription.jsp"; 
		public static final String CHAMP_NOM = "nom";
	    public static final String CHAMP_PRENOM = "prenom";
	    public static final String CHAMP_EMAIL = "email";
	    public static final String CHAMP_PASS = "motdepasse";
	    public static final String CHAMP_CONF = "confirmation";
	    public static final String CHAMP_TEL= "telephone";
	    public static final String ATT_ERREURS  = "erreurs";
	    public static final String ATT_RESULTAT = "resultat";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*List<User> luser = new ArrayList<User>();
		User user = new User();
		
		luser = user.getUsers();
		
		request.setAttribute("luser", luser);
		
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);*/
		List<User> luser = new ArrayList<User>();//1.Creer une liste pour stocker les enregistrements
		User user = new User();//2.Creer une instance du bean
		luser = user.getUsers();//3.Recuperer les enregistrements de la base
		request.setAttribute("luser", luser);//4.Placer dans la request
		
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
		//Recuperer les elements des champs
        String nom = request.getParameter( CHAMP_NOM );
	    String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter( CHAMP_PASS );
	    String confirmation = request.getParameter( CHAMP_CONF );
	    String telephone = request.getParameter(CHAMP_TEL);
	    
	    
	    try {
            validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM.toUpperCase(), e.getMessage() );
        }
        /* Validation du champ preonom. */
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PRENOM, e.getMessage() );
        }
        
	    /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        /* Validation des champs mot de passe et confirmation. */
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASS, e.getMessage() );
        }
        /* Validation du champ nom. */
       
        
        /* Validation du champ telephone. */
        try {
            validationTel( telephone );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_TEL, e.getMessage() );
        }
        
        
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        
        //Creer une bean 
        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setMot_de_passe(motDePasse);
        user.setTelephone(telephone);
        
        //Enregister dans la table
        user.enregistrer(user);
        
   
        
        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);
	        doGet(request, response);
	    }


	
	private void validationNom(String nom) throws Exception {
		// TODO Auto-generated method stub
		 if ( nom != null && nom.trim().length() < 3 ) {
		        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
		    }
		
	}
	

	private void validationPrenom(String prenom) throws Exception {
		// TODO Auto-generated method stub
		 if ( prenom != null && prenom.trim().length() < 3 ) {
		        throw new Exception( "Le prenom d'utilisateur doit contenir au moins 3 caractères." );
		    }
		
	}
	
	private void validationEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		 if ( email != null && email.trim().length() != 0 ) {
		       /* if ( !email.matches("@") ) {
		        	throw new Exception( "Merci de saisir une adresse mail valide." );
		        }
		        else {
		            throw new Exception( "Merci de saisir une adresse mail." );
		        }*/
	}
	}	

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		// TODO Auto-generated method stub
		 if (motDePasse != null && motDePasse.trim().length() != 0 &&
				 confirmation != null && confirmation.trim().length() != 0) {
				         if (!motDePasse.equals(confirmation)) {
				             throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
				         } else if (motDePasse.trim().length() < 3) {
				             throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
				         }
				     } else {
				         throw new Exception("Merci de saisir et confirmer votre mot de passe.");
				     }
		
	}

	private void validationTel(String telephone) throws Exception {
		// TODO Auto-generated method stub
		 if ( telephone != null && telephone.trim().length() < 8 ) {
		        throw new Exception( "Le numero d'utilisateur doit contenir au moins 8 caractères." );
		    }
		
	}
	

	}

	


