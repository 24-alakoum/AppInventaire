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

/**
 * Servlet implementation class SupprimerInventaire
 */
@WebServlet("/SupprimerInventaire")
public class SupprimerInventaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/finventory.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerInventaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idinventaire");
		if (idParam == null) idParam = request.getParameter("param");
		
		if (idParam != null) {
			int idiventaire = Integer.parseInt(idParam);
			Inventory inve = new Inventory();
			inve.deleteInventaire(idiventaire);
		}
		
		response.sendRedirect("ListerInventaires");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
