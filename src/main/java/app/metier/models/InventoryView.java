package app.metier.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class InventoryView {
	private int idinventaire;
	private Date dateInventaire;
	private int idligneInventaire;
	private String nomProduit;
	private Double quantite;
	private Double prix;
	private String nom;
	private String prenom;
	private String telephone;
	
	

	public int getIdinventaire() {
		return idinventaire;
	}



	public void setIdinventaire(int idinventaire) {
		this.idinventaire = idinventaire;
	}



	public Date getDateInventaire() {
		return dateInventaire;
	}



	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}



	public int getIdligneInventaire() {
		return idligneInventaire;
	}



	public void setIdligneInventaire(int idligneInventaire) {
		this.idligneInventaire = idligneInventaire;
	}



	public String getNomProduit() {
		return nomProduit;
	}



	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}



	public Double getQuantite() {
		return quantite;
	}



	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}



	public Double getPrix() {
		return prix;
	}



	public void setPrix(Double prix) {
		this.prix = prix;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public InventoryView() {
		// TODO Auto-generated constructor stub
	}
	
	public List<InventoryView> getRQV(){
		List<InventoryView> linvtv = new ArrayList<InventoryView>();
		String sql = "SELECT * FROM inventoryView3";
		Statement st = null;
		ResultSet rs = null;
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				InventoryView invtv = new InventoryView();
				invtv.setIdinventaire(rs.getInt(1));
				invtv.setDateInventaire(rs.getDate(2));
				invtv.setIdligneInventaire(rs.getInt(3));
				invtv.setNomProduit(rs.getString(4));
				invtv.setQuantite(rs.getDouble(5));
				invtv.setPrix(rs.getDouble(6));
				invtv.setNom(rs.getString(7));
				invtv.setPrenom(rs.getString(8));
				invtv.setTelephone(rs.getString(9));
				
				linvtv.add(invtv);
			}
			rs.close();st.close();connection.close();
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite lors de la r�cup�ration des donn�es: "+e.getMessage());
			e.printStackTrace();
		}
		
		return linvtv;
	}
	
	public List<InventoryView> getInventoryByID(int numRech){
		List<InventoryView> linvtv = new ArrayList<InventoryView>();
		String sql = "SELECT * FROM inventoryView3 WHERE (idinventaire=?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, numRech);
			rs = pst.executeQuery();
			while(rs.next()) {
				InventoryView invtv = new InventoryView();
				invtv.setIdinventaire(rs.getInt(1));
				invtv.setDateInventaire(rs.getDate(2));
				invtv.setIdligneInventaire(rs.getInt(3));
				invtv.setNomProduit(rs.getString(4));
				invtv.setQuantite(rs.getDouble(5));
				invtv.setPrix(rs.getDouble(6));
				invtv.setNom(rs.getString(7));
				invtv.setPrenom(rs.getString(8));
				invtv.setTelephone(rs.getString(9));
				
				linvtv.add(invtv);
			}
			rs.close();pst.close();connection.close();
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite lors de la r�cup�ration des donn�es: "+e.getMessage());
			e.printStackTrace();
		}
		
		return linvtv;
	}

}
