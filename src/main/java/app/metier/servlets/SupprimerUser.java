package app.metier.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.User;


/**
 * Servlet implementation class SupUser
 */
@WebServlet("/SupprimerUser")
public class SupprimerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Recuperer param
		String ID = request.getParameter("param");
		int id = Integer.parseInt(ID);
		//Creer bean
		User user = new User();
		user.deleteUser(id);
		//Creer une liste
		List<User> luser = new ArrayList<User>();
		luser = user.getUsers();
		//Placer dans request
		request.setAttribute("luser", luser);
		
		/*Utilisateur user = new Utilisateur();
		//Recuperer les parametres
		String numcard = request.getParameter("param");
		user.deleteUser(numcard);
		
		List<Utilisateur> luser = new ArrayList<Utilisateur>();
		luser = user.getUtilisateurs();
		// Placer les donnees dans la requete
		request.setAttribute("lutil", luser);*/
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/frmuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
