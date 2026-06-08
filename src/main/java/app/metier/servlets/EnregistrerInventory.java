package app.metier.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Inventory;
import app.metier.models.Ligne;
import app.metier.models.Produit;
import app.metier.models.User;

/**
 * Servlet implementation class EnregistrerInventory
 */
@WebServlet("/EnregistrerInventory")
public class EnregistrerInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String VUE="/WEB-INF/finventory.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit prodModel = new Produit();
		List<Produit> lpds = prodModel.getProduits();
		
		request.setAttribute("lpds", lpds);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public Date strToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh/mm/YYYY");
		Date date = new Date();
		
		try {
			date =  sdf.parse(str);
		} catch (ParseException e) {
			System.out.println("Formatage en date a �chou�: "+e.getMessage());
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static java.time.LocalTime strToLocalTime(String str) throws DateTimeParseException {
		LocalTime time = LocalTime.parse(str) ;
		return time;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User sessionUser = (User) request.getSession().getAttribute("sessionUtilisateur");
		if (sessionUser == null) {
			response.sendRedirect("Login");
			return;
		}

		String dateInventaireStr = request.getParameter("dateInventaire");
		String nomComptable = request.getParameter("nomComptable");
		String nomBoutique = request.getParameter("nomBoutique");
		String quartier = request.getParameter("quartier");
		
		double creditsClients = Double.parseDouble(request.getParameter("creditsClients"));
		double dettesFournisseurs = Double.parseDouble(request.getParameter("dettesFournisseurs"));
		double ancienCompte = Double.parseDouble(request.getParameter("ancienCompte"));
		double montantTotal = Double.parseDouble(request.getParameter("montantTotal"));
		double benefice = Double.parseDouble(request.getParameter("benefice"));
		double partGerant = Double.parseDouble(request.getParameter("partGerant"));
		double partProprietaire = Double.parseDouble(request.getParameter("partProprietaire"));
		double departSomme = Double.parseDouble(request.getParameter("departSomme"));

		Inventory inve = new Inventory();
		inve.setIdutilisateur(sessionUser.getId().intValue());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			inve.setDateInventaire(sdf.parse(dateInventaireStr));
		} catch (ParseException e) {
			inve.setDateInventaire(new Date());
		}
		
		inve.setNomComptable(nomComptable);
		inve.setNomBoutique(nomBoutique);
		inve.setQuartier(quartier);
		inve.setCreditsClients(creditsClients);
		inve.setDettesFournisseurs(dettesFournisseurs);
		inve.setAncienCompte(ancienCompte);
		inve.setMontantTotal(montantTotal);
		inve.setBenefice(benefice);
		inve.setPartGerant(partGerant);
		inve.setPartProprietaire(partProprietaire);
		inve.setDepartSomme(departSomme);

		// 1. Enregistrer l'inventaire pour récupérer son ID
		int inventoryId = inve.enregistrerInventaire(inve);

		if (inventoryId != -1) {
			// 2. Enregistrer les lignes
			String[] productIds = request.getParameterValues("idproduit");
			String[] quantities = request.getParameterValues("quantite");
			String[] prices = request.getParameterValues("prix");

			if (productIds != null) {
				Ligne ligneModel = new Ligne();
				for (int i = 0; i < productIds.length; i++) {
					Ligne line = new Ligne();
					line.setIdinventaire(inventoryId);
					line.setIdproduit(Integer.parseInt(productIds[i]));
					line.setQuantite(Double.parseDouble(quantities[i]));
					line.setPrix(Double.parseDouble(prices[i]));
					ligneModel.enregistrer(line);
				}
			}
		}
		
		response.sendRedirect("ListerInventaires");
	}

}
