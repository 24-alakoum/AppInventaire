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
 * Servlet implementation class EnregistrerUser
 */
@WebServlet("/EnregistrerUser")
public class EnregistrerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/frmuser.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		//Charger les donnees
		String user = request.getParameter("name");
		String pass =(request.getParameter("pass"));
		
		//Creer l'objet
		User users = new User();
		users.setUsername(user);
		users.setPassword(pass);
		//Enregistrer
		users.enregistrer(users);
		doGet(request, response);
	}

}
