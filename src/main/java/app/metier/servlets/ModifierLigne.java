package app.metier.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Ligne;

/**
 * Servlet implementation class ModifierLigne
 */
@WebServlet("/ModifierLigne")
public class ModifierLigne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE1="/WEB-INF/frmLigne.jsp";
	private static final String VUE="/WEB-INF/Modification.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierLigne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//R�cup�rer le param�tre 
		String ar=request.getParameter("param");
		Long am=Long.parseLong(ar);
		//R�cup�rer les donn�es de la base
		List<Ligne>lge=new ArrayList<Ligne>();
		Ligne cb=new Ligne();
		cb = cb.getIdlignePourModif(am);
		
		Ligne a=new Ligne();
		lge=a.read();
		//Placer les donn�es dans la requ�te
		request.setAttribute("liste", lge);
		request.setAttribute("list", cb);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
		
	/*	//R�cup�rer le param�tre 
				String numCart = request.getParameter("param");
				//R�cup�rer les donn�es de la base
						List <Utilisateur> l_user = new ArrayList<Utilisateur>();
						Utilisateur user = new Utilisateur();
						user = user.getUtilisateurByNumcard(numCart);
						
						
						//Placer les donn�es dans la requ�te
						request.setAttribute("l_user", l_user);
						request.setAttribute("user", user);
						//Ouvrir le formulaire
						request.getServletContext().getRequestDispatcher(VUE2).forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auto=request.getParameter("idLigne");
		String idI=request.getParameter("idinventaire");
		String idP=request.getParameter("idproduit");
		String qt=request.getParameter("quantite");
		String pr=request.getParameter("prix");
		long x=Long.parseLong(auto);
		int a=Integer.parseInt(idI);
		int b=Integer.parseInt(idP);
		double c=Double.parseDouble(qt);
		double d=Double.parseDouble(pr);
		
		
		Ligne lig=new Ligne();
		lig.setIdinventaire(a);
		lig.setIdproduit(b);
		lig.setQuantite(c);
		lig.setPrix(d);
		lig.setIdligneInventaire(x);
		lig.ModifierLigne(lig);
		//Ouvrir le formulaire
		request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		
	}

}
