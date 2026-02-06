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
 * Servlet implementation class ModifierUser
 */
@WebServlet("/ModifierUser")
public class ModifierUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/listeusers.jsp";
	private static final String VUE1 = "/WEB-INF/modifieruser.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String ID = request.getParameter("param");//Recuperer param
		int id = Integer.parseInt(ID);
		User userId = new User();//Creer bean 
		userId = userId.userById(id);//Appeler methode getUserById
		List<User> luser = new ArrayList<User>();//List
		luser = userId.getUsers();//Appeler methode getUsers
		request.setAttribute("luser", luser);//Placer dans le request
		request.setAttribute("userid", userId);//Placer dans le request
		//Appeler la vue frmprincipal
		request.getServletContext().getRequestDispatcher(VUE1).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Charger les donnees
				String ID = request.getParameter("identifiant");
				String usernom = request.getParameter("name");
				String userprenom = request.getParameter("prenom");
				String email =request.getParameter("email");
				String motdepasse = request.getParameter("motdepasse");
				String telephone = request.getParameter("telephone");

				long id  = Long.parseLong(ID);
				
				//Creer l'objet
				User users = new User();
				users.setId(id);
				users.setNom(usernom);
				users.setPrenom(userprenom);
				users.setEmail(email);
				users.setMot_de_passe(motdepasse);
				users.setTelephone(telephone);
				
				//Enregistrer
				List<User> luser = new ArrayList<User>();
				//Appliquer les modifications
				users.updateUser(users, id);
				luser = users.getUsers();
				// Placer les donnees dans la requete
				request.setAttribute("luser", luser);
				request.getServletContext().getRequestDispatcher(VUE).forward(request,response);
				
		//doGet(request, response);
	}

}
