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
 * Servlet implementation class Lister
 */
@WebServlet("/Lister")
public class Lister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User sessionUser = (User) request.getSession().getAttribute("sessionUtilisateur");
		if (sessionUser == null || !"super".equalsIgnoreCase(sessionUser.getRole())) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé");
			return;
		}

		String motCle = request.getParameter("motCle");
		List<User> luser;
		User userModel = new User();

		if (motCle != null && !motCle.isEmpty()) {
			luser = userModel.rechercherUsers(motCle);
		} else {
			luser = userModel.getUsers();
		}
		
		request.setAttribute("luser", luser);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listeusers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
