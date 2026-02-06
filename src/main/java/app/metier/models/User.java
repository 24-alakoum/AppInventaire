package app.metier.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class User {
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String mot_de_passe;
	private String telephone;
	private String role ;
	
	
	//Parametres des elements
	
	

	

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters et setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//Methode Enregistrer
	public void enregistrer(User user) {
		String sql = "INSERT INTO utilisateur(nom ,prenom, email,mot_de_passe,telephone) VALUES(?,?,?,?,?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1,user.getNom());
			pst.setString(2, user.getPrenom());
			pst.setString(3,user.getEmail());
			pst.setString(4, user.getMot_de_passe());
			pst.setString(5, user.getTelephone());
			//.setString(6, user.getRole());
			int i = pst.executeUpdate();
			if(i != 0) System.out.println("Enregistrement effectué !");
			else System.out.println("Enregistrement non effectué !");
			if(pst!= null) {
				    try {
				        pst.close();
				    } catch ( SQLException ignore ) {
			}
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException ignore) {
					
				}
			}
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//Fin de la methode enregistrer
	

	public List<User> getUsers(){
		List<User> luser = new ArrayList<User>();
		String sql = "SELECT * FROM utilisateur order by idutilisateur desc";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		Statement pst = null;
		ResultSet rs = null;
		
		try {
			pst = connection.createStatement();
			rs = pst.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setNom(rs.getString(2));
				user.setPrenom(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setMot_de_passe(rs.getString(5));
				user.setTelephone(rs.getString(6));
				//user.setRole(rs.getString(7));
				luser.add(user);
			}
			if(rs!= null) {
			    try {
			        rs.close();
			    } catch ( SQLException ignore ) {}
			}
			if(pst!= null) {
			    try {
			        pst.close();
			    } catch ( SQLException ignore ) {}
			}    
		if(connection != null) {
			try {
				connection.close();
			}
			catch(SQLException ignore) {}
		}
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return luser;
	}//Fin de la methode getUser
	
	public void updateUser(User user,long id) {
		String sql = "UPDATE utilisateur SET nom = ? , prenom =?  ,email=? , mot_de_passe =? ,telephone =? WHERE ( idutilisateur=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1,user.getNom());
			pst.setString(2, user.getPrenom());
			pst.setString(3,user.getEmail());
			pst.setString(4, user.getMot_de_passe());
			pst.setString(5, user.getTelephone());
			pst.setLong(6, user.getId());
			int i = pst.executeUpdate();
			if(i!= 0) System.out.println("Modification reusie !");
			else System.out.println("Modification non reusie !");
			pst.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Modification non reusie !" +e.getMessage());
			e.printStackTrace();
		}
		
	}//Fin de la update
	/*public User getUserById(int identifiant){
		String sql = "SELECT * FROM  utilisateur WHERE ( userId=?)";
		User user = new User();
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, identifiant);
			rs =pst.executeQuery();
			while(rs.next()) {
				user.setIdentifiant(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				
			}
			rs.close();
			pst.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}//Fin methode userbyId*/
	
	public void deleteUser(int id) {
		String sql = "DELETE FROM  utilisateur WHERE ( idutilisateur=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
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
	
	public User connecterUser(String em){
		
		
		String sql = "SELECT *  FROM  utilisateur WHERE (email=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, em);
			rs = pst.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getLong(1));
				u.setNom(rs.getString(2));
				u.setPrenom(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMot_de_passe(rs.getString(5));
				u.setTelephone(rs.getString(6));
				return u;
					
			}
			if(rs!= null) {
			    try {
			        rs.close();
			    } catch ( SQLException ignore ) {}
			}
			if(pst!= null) {
			    try {
			        pst.close();
			    } catch ( SQLException ignore ) {}
			}    
		if(connection != null) {
			try {
				connection.close();
			}
			catch(SQLException ignore) {}
		}
		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//Methode recuperer user by id
	
public User userById(int id){
		
		
		String sql = "SELECT *  FROM  utilisateur WHERE (idutilisateur=?)";
		Connection connection =null;
		DBA bd = new DBA();
		connection = bd.seconnecter();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getLong(1));
				u.setNom(rs.getString(2));
				u.setPrenom(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMot_de_passe(rs.getString(5));
				u.setTelephone(rs.getString(6));
				return u;
					
			}
			if(rs!= null) {
			    try {
			        rs.close();
			    } catch ( SQLException ignore ) {}
			}
			if(pst!= null) {
			    try {
			        pst.close();
			    } catch ( SQLException ignore ) {}
			}    
		if(connection != null) {
			try {
				connection.close();
			}
			catch(SQLException ignore) {}
		}
		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



}
