package app.metier.servlets;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Produit;


/**
 * Servlet implementation class AjouterProduit
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Produit produit = new Produit();
		List<Produit> lprod = new ArrayList< Produit>();
		lprod = produit.getProduits();
		request.setAttribute("lprod", lprod);
		request.getServletContext().getRequestDispatcher("/WEB-INF/ajouterproduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
		String nomProduit = request.getParameter("produit");
		try {
            validationProduit( nomProduit );
        } catch ( Exception e ) {
            erreurs.put( nomProduit, e.getMessage() );
            
        }
		
		if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
		
		Produit produit = new Produit();
		
		produit.setProductName(nomProduit);
		
		produit.enregistrer(produit);
		
		
		doGet(request, response);
		
		
	}



	private void validationProduit(String nomProduit) throws Exception {
		// TODO Auto-generated method stub
		 if ( nomProduit != null && nomProduit.trim().length() < 1 ) {
		        throw new Exception( "Le nom du produit doit contenir au moins 1 caractère." );
		    }
		
	}
	}
