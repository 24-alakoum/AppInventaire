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
		//R�cup�rer le param�tre 
		
		
		
				String idinventaire = request.getParameter("param");
				//R�cup�rer les donn�es de la base
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
		// R�cup�rer les donn�es du formulaire
		String idutilisateur = request.getParameter("idutilisateur");
		String dateinventaire = request.getParameter("dateinventaire");
		int idinventaire =  Integer.parseInt(request.getParameter("idinventaire"));
		
		//Convertir les donn�es
		int c_idutilisateur = Integer.parseInt(idutilisateur);
		Date c_dateInventaire = strToDate(dateinventaire);
		
		//Cr�er l'objet et attribuer les valeurs aux attributs
		Inventory inv = new Inventory();
		
		inv.setIdutilisateur(c_idutilisateur);
		inv.setDateInventaire(c_dateInventaire);
		
		//appliquer les modifications
		inv.updateInventaire(inv , idinventaire);
		
		//R�cup�rer les donn�es de la base
		List <Inventory> linv = new ArrayList<Inventory>();
		inv = inv.getInventoryByIdInventaire(c_idutilisateur);
		linv = inv.recupererInventaire();
		
		//Placer les donn�es dans la requ�te
		request.setAttribute("linv", linv);
		request.setAttribute("inv", inv);
		
		//Ouvrir le formulaire
		request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
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
