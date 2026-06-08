package app.metier.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.metier.models.Produit;

@WebServlet("/SupprimerProduit")
public class SupprimerProduit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("param");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Produit produit = new Produit();
            produit.deleteProduit(id);
        }
        response.sendRedirect("ListerProd");
    }
}
