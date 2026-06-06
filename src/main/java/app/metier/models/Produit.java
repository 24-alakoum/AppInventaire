package app.metier.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Produit {
	private int idProduct;
	private String productName;
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters et setters
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	//Crearion de la methode enregistrer*
	public void enregistrer(Produit pd) {
		String sql = "INSERT INTO produit(nomProduit) VALUES(?)";
		DBA bd = new DBA();
		
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, pd.getProductName());
			int i = pst.executeUpdate();
			if(i!=0) System.out.println("Enregistrement produit réussi !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Mehode get data
	public List<Produit> getProduits(){
		List<Produit> lpds = new ArrayList<Produit>();
		String sql = "SELECT * from produit ORDER BY nomProduit ASC";
		DBA bd = new DBA();
		
		try (Connection connection = bd.seconnecter();
			 Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery(sql)) {
			while(rs.next()) {
				Produit pds = new Produit();
				pds.setIdProduct(rs.getInt("idproduit"));
				pds.setProductName(rs.getString("nomProduit"));
				lpds.add(pds);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lpds;
	}

	public void updateProduit(Produit pd) {
		String sql = "UPDATE produit SET nomProduit = ? WHERE idproduit = ?";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, pd.getProductName());
			pst.setInt(2, pd.getIdProduct());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduit(int id) {
		String sql = "DELETE FROM produit WHERE idproduit = ?";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produit> rechercherProduits(String motCle) {
		List<Produit> lpds = new ArrayList<>();
		String sql = "SELECT * FROM produit WHERE nomProduit LIKE ? ORDER BY nomProduit ASC";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, "%" + motCle + "%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Produit p = new Produit();
					p.setIdProduct(rs.getInt("idproduit"));
					p.setProductName(rs.getString("nomProduit"));
					lpds.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lpds;
	}
	

}
/*idProduct
productName
productQuantity
productPrice*/
