package app.metier.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Inventory;
import app.metier.models.User;


/**
 * Servlet implementation class ModifierInventaire
 */
@WebServlet("/ModifierInventaire")
public class ModifierInventaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VUE1="/WEB-INF/finventory.jsp";
	private static String VUE2="/WEB-INF/modifinventory.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInventaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer le paramètre
		
				String idinventaire = request.getParameter("idinventaire");
				if (idinventaire == null) idinventaire = request.getParameter("param");

				//Récupérer les données de la base
						List <Inventory> linve = new ArrayList<Inventory>();
						
						Inventory inve = new Inventory();
						int c_idinventaire = Integer.parseInt(idinventaire);
						inve = inve.getInventoryByIdInventaire(c_idinventaire);
						linve = inve.recupererInventaire();
						List <User> luser = new ArrayList<User>();
						User user = new User();
						luser = user.getUsers();
						
						
						//Placer les donn�es dans la requ�te
						request.setAttribute("linve", linve);
						request.setAttribute("inve", inve);
						request.setAttribute("luser", luser);
						//Ouvrir le formulaire
						request.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idinventaire = Integer.parseInt(request.getParameter("idinventaire"));
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

		Inventory inv = new Inventory();
		inv.setIdinventaire(idinventaire);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			inv.setDateInventaire(sdf.parse(dateInventaireStr));
		} catch (ParseException e) {
			inv.setDateInventaire(new Date());
		}
		
		inv.setNomComptable(nomComptable);
		inv.setNomBoutique(nomBoutique);
		inv.setQuartier(quartier);
		inv.setCreditsClients(creditsClients);
		inv.setDettesFournisseurs(dettesFournisseurs);
		inv.setAncienCompte(ancienCompte);
		inv.setMontantTotal(montantTotal);
		inv.setBenefice(benefice);
		inv.setPartGerant(partGerant);
		inv.setPartProprietaire(partProprietaire);
		inv.setDepartSomme(departSomme);
		
		inv.updateInventaire(inv, idinventaire);
		
		response.sendRedirect("ListerInventaires");
	}

	public Date strToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh/MM/yyyy");
		Date date = new Date();
		
		try {
			date =  sdf.parse(str);
		} catch (ParseException e) {
			System.out.println("Formatage en date a �chou�: "+e.getMessage());
			e.printStackTrace();
		}
		
		return date;
	}

}
