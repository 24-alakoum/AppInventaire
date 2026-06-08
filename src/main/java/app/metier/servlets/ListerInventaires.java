package app.metier.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.metier.models.Inventory;
import app.metier.models.User;

/**
 * Servlet implementation class ListerInventaires
 */
@WebServlet("/ListerInventaires")
public class ListerInventaires extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListerInventaires() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("sessionUtilisateur");

		if (sessionUser == null) {
			response.sendRedirect("Login");
			return;
		}

		Inventory inventoryModel = new Inventory();
		String sortBy = request.getParameter("sortBy");
		String order = request.getParameter("order");

		List<Inventory> linv;
		if ("super".equalsIgnoreCase(sessionUser.getRole())) {
			// Super user sees everything
			linv = inventoryModel.filterAndSortInventory(null, sortBy, order);
		} else {
			// Standard user sees only their own data
			linv = inventoryModel.filterAndSortInventory(sessionUser.getId().intValue(), sortBy, order);
		}

		request.setAttribute("linv", linv);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listeinventaires.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
