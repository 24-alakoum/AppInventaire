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
	private String nomComptable;
	private String nomBoutique;
	private String quartier;
	private double creditsClients;
	private double dettesFournisseurs;
	private double ancienCompte;
	private double montantTotal;
	private double benefice;
	private double partGerant;
	private double partProprietaire;
	private double departSomme;
	
	

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

	public String getNomComptable() {
		return nomComptable;
	}

	public void setNomComptable(String nomComptable) {
		this.nomComptable = nomComptable;
	}

	public String getNomBoutique() {
		return nomBoutique;
	}

	public void setNomBoutique(String nomBoutique) {
		this.nomBoutique = nomBoutique;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public double getCreditsClients() {
		return creditsClients;
	}

	public void setCreditsClients(double creditsClients) {
		this.creditsClients = creditsClients;
	}

	public double getDettesFournisseurs() {
		return dettesFournisseurs;
	}

	public void setDettesFournisseurs(double dettesFournisseurs) {
		this.dettesFournisseurs = dettesFournisseurs;
	}

	public double getAncienCompte() {
		return ancienCompte;
	}

	public void setAncienCompte(double ancienCompte) {
		this.ancienCompte = ancienCompte;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public double getBenefice() {
		return benefice;
	}

	public void setBenefice(double benefice) {
		this.benefice = benefice;
	}

	public double getPartGerant() {
		return partGerant;
	}

	public void setPartGerant(double partGerant) {
		this.partGerant = partGerant;
	}

	public double getPartProprietaire() {
		return partProprietaire;
	}

	public void setPartProprietaire(double partProprietaire) {
		this.partProprietaire = partProprietaire;
	}

	public double getDepartSomme() {
		return departSomme;
	}

	public void setDepartSomme(double departSomme) {
		this.departSomme = departSomme;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	// debut CRUD
	//ENREGISTREMENT
	public int enregistrerInventaire(Inventory inv) {
		String sql = "INSERT INTO inventaire(idutilisateur,dateInventaire,nomComptable,nomBoutique,quartier,creditsClients,dettesFournisseurs,ancienCompte,montantTotal,benefice,partGerant,partProprietaire,departSomme) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBA bd = new DBA();
		int generatedId = -1;
		
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, inv.getIdutilisateur());
			pst.setDate(2, new java.sql.Date(inv.getDateInventaire().getTime()));
			pst.setString(3, inv.getNomComptable());
			pst.setString(4, inv.getNomBoutique());
			pst.setString(5, inv.getQuartier());
			pst.setDouble(6, inv.getCreditsClients());
			pst.setDouble(7, inv.getDettesFournisseurs());
			pst.setDouble(8, inv.getAncienCompte());
			pst.setDouble(9, inv.getMontantTotal());
			pst.setDouble(10, inv.getBenefice());
			pst.setDouble(11, inv.getPartGerant());
			pst.setDouble(12, inv.getPartProprietaire());
			pst.setDouble(13, inv.getDepartSomme());

			if(pst.executeUpdate() != 0) {
				System.out.println("Déclaration enregistrée avec succès");
				try (ResultSet rs = pst.getGeneratedKeys()) {
					if (rs.next()) {
						generatedId = rs.getInt(1);
					}
				}
			} else {
				System.out.println("Déclaration non enregistrée");
			}
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite: " + e.getMessage());
			e.printStackTrace();
		}
		return generatedId;
	}// Fin Enregistrement
	
	// Debut recuperation
	
	public List<Inventory> recupererInventaire(){
		List<Inventory> linv = new ArrayList<Inventory>();
		DBA bd = new DBA();
		String sql = "SELECT * FROM inventaire ORDER BY idinventaire DESC";
		
		try (Connection connection = bd.seconnecter();
			 Statement st = connection.createStatement();
			 ResultSet rslt = st.executeQuery(sql)) {
			while(rslt.next()) {
				Inventory invent = new Inventory();
				invent.setIdinventaire(rslt.getInt("idinventaire"));
				invent.setIdutilisateur(rslt.getInt("idutilisateur"));
				invent.setDateInventaire(rslt.getDate("dateInventaire"));
				invent.setNomComptable(rslt.getString("nomComptable"));
				invent.setNomBoutique(rslt.getString("nomBoutique"));
				invent.setQuartier(rslt.getString("quartier"));
				invent.setCreditsClients(rslt.getDouble("creditsClients"));
				invent.setDettesFournisseurs(rslt.getDouble("dettesFournisseurs"));
				invent.setAncienCompte(rslt.getDouble("ancienCompte"));
				invent.setMontantTotal(rslt.getDouble("montantTotal"));
				invent.setBenefice(rslt.getDouble("benefice"));
				invent.setPartGerant(rslt.getDouble("partGerant"));
				invent.setPartProprietaire(rslt.getDouble("partProprietaire"));
				invent.setDepartSomme(rslt.getDouble("departSomme"));
				
				linv.add(invent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linv;
	}
	
	// Mise a jour inventaire
	
	public void updateInventaire(Inventory inve , int idinventaire) {
		String sql = "UPDATE inventaire SET idutilisateur = ?, dateInventaire =?, nomComptable=?, nomBoutique=?, quartier=?, creditsClients=?, dettesFournisseurs=?, ancienCompte=?, montantTotal=?, benefice=?, partGerant=?, partProprietaire=?, departSomme=? WHERE ( idinventaire=?)";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1,inve.getIdutilisateur());
			pst.setDate(2, new java.sql.Date(inve.getDateInventaire().getTime()));
			pst.setString(3, inve.getNomComptable());
			pst.setString(4, inve.getNomBoutique());
			pst.setString(5, inve.getQuartier());
			pst.setDouble(6, inve.getCreditsClients());
			pst.setDouble(7, inve.getDettesFournisseurs());
			pst.setDouble(8, inve.getAncienCompte());
			pst.setDouble(9, inve.getMontantTotal());
			pst.setDouble(10, inve.getBenefice());
			pst.setDouble(11, inve.getPartGerant());
			pst.setDouble(12, inve.getPartProprietaire());
			pst.setDouble(13, inve.getDepartSomme());
			pst.setInt(14,idinventaire);
			int i = pst.executeUpdate();
			if(i!= 0) System.out.println("Modification reusie !");
			else System.out.println("Modification non reusie !");
		} catch (SQLException e) {
			System.out.println("Modification non reusie !" +e.getMessage());
			e.printStackTrace();
		}
	}//Fin de la update
	
	//------------------------------------------------------------------

	//DELETE - Suppression des données
	
	public void deleteInventaire(int idinventaire) {
		String sql = "DELETE FROM  inventaire WHERE ( idinventaire=?)";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, idinventaire);
			int i = pst.executeUpdate();
			if(i!=0) System.out.println("Element supprimé !");
			else System.out.println("Element non supprimé !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Inventory getInventoryByIdInventaire(int idinventaire) {
		Inventory inve = new Inventory();
		String sql = "SELECT * FROM inventaire WHERE idinventaire=?";
		DBA bd = new DBA();
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1,idinventaire);
			try (ResultSet rs = pst.executeQuery()) {
				while(rs.next()) {
					inve.setIdinventaire(rs.getInt("idinventaire"));
					inve.setIdutilisateur(rs.getInt("idutilisateur"));
					inve.setDateInventaire(rs.getDate("dateInventaire"));
					inve.setNomComptable(rs.getString("nomComptable"));
					inve.setNomBoutique(rs.getString("nomBoutique"));
					inve.setQuartier(rs.getString("quartier"));
					inve.setCreditsClients(rs.getDouble("creditsClients"));
					inve.setDettesFournisseurs(rs.getDouble("dettesFournisseurs"));
					inve.setAncienCompte(rs.getDouble("ancienCompte"));
					inve.setMontantTotal(rs.getDouble("montantTotal"));
					inve.setBenefice(rs.getDouble("benefice"));
					inve.setPartGerant(rs.getDouble("partGerant"));
					inve.setPartProprietaire(rs.getDouble("partProprietaire"));
					inve.setDepartSomme(rs.getDouble("departSomme"));
				}
			}
		} catch (SQLException e) {
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

	

	public List<Inventory> filterAndSortInventory(Integer userId, String sortBy, String order) {
		List<Inventory> linv = new ArrayList<Inventory>();
		DBA bd = new DBA();

		// Whitelist for sorting to prevent SQL injection
		String validSortBy = "idinventaire";
		if ("dateInventaire".equals(sortBy)) validSortBy = "dateInventaire";
		else if ("montantTotal".equals(sortBy)) validSortBy = "montantTotal";
		else if ("benefice".equals(sortBy)) validSortBy = "benefice";

		String validOrder = "DESC";
		if ("ASC".equalsIgnoreCase(order)) validOrder = "ASC";

		String sql = "SELECT * FROM inventaire" + (userId != null ? " WHERE idutilisateur = ?" : "") + " ORDER BY " + validSortBy + " " + validOrder;

		try (Connection connection = bd.seconnecter();
			 PreparedStatement pst = connection.prepareStatement(sql)) {

			if (userId != null) {
				pst.setInt(1, userId);
			}

			try (ResultSet rslt = pst.executeQuery()) {
				while (rslt.next()) {
					Inventory invent = new Inventory();
					invent.setIdinventaire(rslt.getInt("idinventaire"));
					invent.setIdutilisateur(rslt.getInt("idutilisateur"));
					invent.setDateInventaire(rslt.getDate("dateInventaire"));
					invent.setNomComptable(rslt.getString("nomComptable"));
					invent.setNomBoutique(rslt.getString("nomBoutique"));
					invent.setQuartier(rslt.getString("quartier"));
					invent.setCreditsClients(rslt.getDouble("creditsClients"));
					invent.setDettesFournisseurs(rslt.getDouble("dettesFournisseurs"));
					invent.setAncienCompte(rslt.getDouble("ancienCompte"));
					invent.setMontantTotal(rslt.getDouble("montantTotal"));
					invent.setBenefice(rslt.getDouble("benefice"));
					invent.setPartGerant(rslt.getDouble("partGerant"));
					invent.setPartProprietaire(rslt.getDouble("partProprietaire"));
					invent.setDepartSomme(rslt.getDouble("departSomme"));
					linv.add(invent);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linv;
	}
}
