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
	private static final String VUE = "/WEB-INF/frmuser.jsp";
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
		int i = Integer.parseInt(ID);//Convertir en int
		User userid = new User();//Creer bean 
		userid = userid.getUserById(i);//Appeler methode getUserById
		List<User> luser = new ArrayList<User>();//List
		luser = userid.getUsers();//Appeler methode getUsers
		request.setAttribute("luser", luser);//Placer dans le request
		request.setAttribute("userid", userid);//Placer dans le request
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
				String user = request.getParameter("name");
				String pass =(request.getParameter("pass"));
				int id = Integer.parseInt(ID);
				
				//Creer l'objet
				User users = new User();
				users.setIdentifiant(id);
				users.setUsername(user);
				users.setPassword(pass);
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
