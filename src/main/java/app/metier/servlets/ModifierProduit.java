package app.metier.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.metier.models.Produit;

@WebServlet("/ModifierProduit")
public class ModifierProduit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("param");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Produit produit = new Produit();
            // Since we don't have a getProduitById, we'll find it in the list for now
            // Better to add getProduitById to the model
            Produit pFound = produit.getProduits().stream().filter(p -> p.getIdProduct() == id).findFirst().orElse(null);
            request.setAttribute("produit", pFound);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/modifierproduit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("produit");
        Produit p = new Produit();
        p.setIdProduct(id);
        p.setProductName(nom);
        p.updateProduit(p);
        response.sendRedirect("ListerProd");
    }
}
