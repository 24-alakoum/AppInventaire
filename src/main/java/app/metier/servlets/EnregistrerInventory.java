package app.metier.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.metier.models.Inventory;
import app.metier.models.User;

/**
 * Servlet implementation class EnregistrerInventory
 */
@WebServlet("/EnregistrerInventory")
public class EnregistrerInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String VUE="/WEB-INF/finventory.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <User> luser = new ArrayList<User>();
		User user = new User();
		luser = user.getUsers();
		
		List<Inventory> linve = new ArrayList<Inventory>();
		Inventory inve = new Inventory();
		linve = inve.recupererInventaire();
		
		
		
		//Placer les donn�es dans la requ�te
		request.setAttribute("luser", luser);
		request.setAttribute("linve", linve);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public Date strToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh/mm/YYYY");
		Date date = new Date();
		
		try {
			date =  sdf.parse(str);
		} catch (ParseException e) {
			System.out.println("Formatage en date a �chou�: "+e.getMessage());
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static java.time.LocalTime strToLocalTime(String str) throws DateTimeParseException {
		LocalTime time = LocalTime.parse(str) ;
		return time;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idutilisateur = request.getParameter("idutilisateur");
		String dateInventaire =request.getParameter("dateInventaire");
		
		
		//conversion
		Inventory inve = new Inventory();
		int c_idutilisateur = Integer.parseInt(idutilisateur);
		Date c_dateInventaire = strToDate(dateInventaire);
		
		inve.setIdutilisateur(c_idutilisateur);
		inve.setDateInventaire(c_dateInventaire);
		
		inve.enregistrerInventaire(inve);
		
		doGet(request, response);
	}

}
