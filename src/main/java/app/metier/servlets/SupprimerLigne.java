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
 * Servlet implementation class SupprimerLigne
 */
@WebServlet("/SupprimerLigne")
public class SupprimerLigne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String vue1="/WEB-INF/frmLigne.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerLigne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ligne le=new Ligne();
		String x=request.getParameter("param");
		int y=Integer.parseInt(x);
		le.deleteLine(y);
		List<Ligne> lgn=new ArrayList<Ligne>();
		Ligne var=new Ligne();
		lgn=var.read();
		request.setAttribute("lister", lgn);
		request.getServletContext().getRequestDispatcher(vue1).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
