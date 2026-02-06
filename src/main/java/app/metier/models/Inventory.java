package app.metier.models;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Inventory {
	private int idinventaire; 
	private int idutilisateur;
	private Date dateInventaire;
	
	

	public int getIdinventaire() {
		return idinventaire;
	}


	public void setIdinventaire(int idinventaire) {
		this.idinventaire = idinventaire;
	}


	public int getIdutilisateur() {
		return idutilisateur;
	}


	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}


	public Date getDateInventaire() {
		return dateInventaire;
	}


	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}



	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	// debut CRUD
	//ENREGISTREMENT
	public void enregistrerInventaire(Inventory inv) {
		String sql = "INSERT INTO inventaire(idutilisateur,dateInventaire) VALUES(?,?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, inv.getIdutilisateur());
			pst.setDate(2, new java.sql.Date(inv.getDateInventaire().getTime()));

			if(pst.executeUpdate()!=0) {
				System.out.println("D�claration engist�e avec succ�s ");
			}else {
				System.out.println("D�claration non enregistr�e");
			}
			pst.close(); connection.close();
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite"+e.getMessage());
			e.printStackTrace();
		}
		
	}// Fin Enregistrement
	
	// Debut recuperation
	
	public List<Inventory> recupererInventaire(){
		List<Inventory> linv = new ArrayList<Inventory>();
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		String sql = "SELECT * FROM inventaire";
		
		Statement st = null;
		ResultSet rslt = null;
		
		try {
			st = connection.createStatement();
			rslt = st.executeQuery(sql);
			while(rslt.next()) {
				Inventory invent = new Inventory();
				invent.setIdinventaire(rslt.getInt(1));
				invent.setIdutilisateur(rslt.getInt(2));
				invent.setDateInventaire(rslt.getDate(3));
				
				linv.add(invent);
			}
			if(rslt!=null) rslt.close();
			if(st!=null) st.close(); 
			if(connection!=null)	connection.close();	
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return linv;
		
	}
	
	// Mise a jour inventaire
	
	public void updateInventaire(Inventory inve , int idinventaire) {
		String sql = "UPDATE inventaire SET idutilisateur = ?  dateInventaire =? WHERE ( idinventaire=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1,inve.getIdutilisateur());
			pst.setDate(2, new java.sql.Date(inve.getDateInventaire().getTime()));
			pst.setInt(3,idinventaire);
			int i = pst.executeUpdate();
			if(i!= 0) System.out.println("Modification reusie !");
			else System.out.println("Modification non reusie !");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Modification non reusie !" +e.getMessage());
			e.printStackTrace();
		}
		
	}//Fin de la update
	
	//------------------------------------------------------------------

	//DELETE - Suppression des donn�es
	
	public void deleteInventaire(int idinventaire) {
		String sql = "DELETE FROM  inventaire WHERE ( idinventaire=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, idinventaire);
			int i = pst.executeUpdate();
			if(i!=0) System.out.println("Element supprimé !");
			System.out.println("Element non supprimé !");
			pst.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Inventory getInventoryByIdInventaire(int idinventaire) {
		Inventory inve = new Inventory();
		String sql = "SELECT * FROM inventaire WHERE (idinventaire=?)";
		 Connection connection = null;
		 DBA db = new DBA();
		 connection = db.seconnecter();
		
		 ResultSet rs = null;
		 PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1,idinventaire);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				inve.setIdinventaire(rs.getInt(1));
				inve.setIdutilisateur(rs.getInt(2));
				inve.setDateInventaire(rs.getDate(3));
				
			}
			pst.close();connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inve;
		
		/*public Inventory getInventaireById(int idInventaire) {

	        Inventaire inventaire = null;
	        String sql = "SELECT idinventaire, idutilisateur, dateInventaire "
	                   + "FROM inventaire WHERE idinventaire = ?";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, idInventaire);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                inventaire = new Inventaire();
	                inventaire.setIdInventaire(rs.getInt("idinventaire"));
	                inventaire.setIdUtilisateur(rs.getInt("idutilisateur"));
	                inventaire.setDateInventaire(rs.getDate("dateInventaire"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // à remplacer par un logger
	        }

	        return inventaire;
	    }*/
		
		
	}

	

}
