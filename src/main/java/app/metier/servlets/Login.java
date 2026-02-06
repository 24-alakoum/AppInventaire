package app.metier.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.metier.models.PasswordUtil;
import app.metier.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 public static final String ATT_USER         = "utilisateur";
	 public static final String ATT_FORM         = "form";
	 public static final String ATT_SESSION_USER = "sessionUtilisateur";
	 public static final String VUE              = "/WEB-INF/login.jsp";
	 public static final String VUE1              = "/index.jsp";
	    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Affichage de la page de login
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Préparation de l'objet formulaire */
        
        String email = request.getParameter("email");
        String passeSaisi = PasswordUtil.hashPassword( request.getParameter("passe"));
        
        
        /* Traitement de la requête et récupération du bean en resultant*/
        User users = new User();
        
        users = users.connecterUser(email);
        //If user does not exist in the database
        if(users==null) {
        	//response.sendRedirect("inscription.jsp?email="+email);
        	request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp?email=" +email).forward(request, response);
        	return;
        }
        //If password is is wrong
        if(!users.getMot_de_passe().equals(passeSaisi)) {
        	request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp?error=passe").forward(request, response);
        	response.sendRedirect("/login.jsp?error=passe");
        	return;
        }
        
        //Si la connexion est bon
        HttpSession session = request.getSession();
       session.setAttribute(ATT_SESSION_USER , users);
       //response.sendRedirect("index.jsp");
       request.getServletContext().getRequestDispatcher(VUE1).forward(request, response); 
        /*if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(ATT_SESSION_USER, user);
            response.getWriter().println("Connexion réussie");
            this.getServletContext().getRequestDispatcher( VUE1).forward( request, response);
        } else {
            response.getWriter().println("Login ou mot de passe incorrect");
            request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }*/
        
        
        /* Récupération de la session depuis la requête 
        HttpSession session = request.getSession();
        
        
        * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
        * Utilisateur à la session, sinon suppression du bean de la
        session.
        
                if ( form.getErreurs().isEmpty()) {
                	if(user!=null) {
                		session.setAttribute( ATT_SESSION_USER, user );
                	}
                    
                } else {
                    session.setAttribute( ATT_SESSION_USER, null );
                }
                /* Stockage du formulaire et du bean dans l'objet request 
                request.setAttribute( ATT_FORM, form );
                request.setAttribute( ATT_USER, user );*/
                
		//Recuperer les champs
		//String email = request.getParameter("email");
		//String pass = request.getParameter("pass");
		
		
		
		
		
		doGet(request, response);
	}

}
