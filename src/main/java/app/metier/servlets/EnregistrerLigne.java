package app.metier.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Inventory;
import app.metier.models.Ligne;
import app.metier.models.Produit;

/**
 * Servlet implementation class EnregistrerLigne
 */
@WebServlet("/EnregistrerLigne")
public class EnregistrerLigne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String vue1="/WEB-INF/frmLigne.jsp";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerLigne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Inventory> linve = new ArrayList<Inventory>();
		Inventory inve = new Inventory();
		linve = inve.recupererInventaire();
		
		List<Produit> lprod = new ArrayList<Produit>();
		Produit prod = new Produit();
		lprod = prod.getProduits();
		
		List<Ligne> listeligne=new ArrayList<Ligne>();
		Ligne ligne= new Ligne();
		listeligne = ligne.read();
		
		request.setAttribute("linve", linve);
		request.setAttribute("lprod", lprod);
		request.setAttribute("lister", listeligne);
		
		request.getServletContext().getRequestDispatcher(vue1).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idI=request.getParameter("idinventaire");
		String idP=request.getParameter("idproduit");
		String qt=request.getParameter("quantite");
		String pr=request.getParameter("prix");
		int a=Integer.parseInt(idI);
		int b=Integer.parseInt(idP);
		double c=Double.parseDouble(qt);
		double d=Double.parseDouble(pr);
		doGet(request, response);
		Ligne lig=new Ligne();
		lig.setIdinventaire((int) a);
		lig.setIdproduit(b);
		lig.setQuantite(c);
		lig.setPrix(d);
		
		lig.enregistrer(lig);
		
		request.getServletContext().getRequestDispatcher(vue1).forward(request, response);
	}

}
