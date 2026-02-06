package app.metier.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.InventoryView;

/**
 * Servlet implementation class ViewBynumInvenaire
 */
@WebServlet("/ViewBynumInvenaire")
public class ViewBynumInvenaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/ficheinve.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBynumInvenaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//R�cup�rer les param�tres
		String numRech = request.getParameter("numRech");
		int c_numInve = Integer.parseInt(numRech);
		//R�cup�rer les donn�es
		InventoryView invtv = new InventoryView();
		List<InventoryView> linvtv = new ArrayList<InventoryView>();
		linvtv = invtv.getInventoryByID(c_numInve);
		request.setAttribute("numRech", numRech);
		request.setAttribute("linvtv", linvtv);
		//doGet(request, response);
	} //fin doPost()
	

}
