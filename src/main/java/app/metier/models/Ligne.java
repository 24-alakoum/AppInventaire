package app.metier.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ligne {
	
	
	
	private long idligneInventaire;
	private int idinventaire;
	private int idproduit;
	private double quantite;
	private double prix;
	private double montant;
	
	public Ligne() {
		// TODO Auto-generated constructor stub
	}
	
	
	public long getIdligneInventaire() {
		return idligneInventaire;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public void setIdligneInventaire(long idligneInventaire) {
		this.idligneInventaire = idligneInventaire;
	}


	public int getIdinventaire() {
		return idinventaire;
	}


	public void setIdinventaire(int idinventaire) {
		this.idinventaire = idinventaire;
	}


	public int getIdproduit() {
		return idproduit;
	}


	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}


	public double getQuantite() {
		return quantite;
	}


	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	/*public Connection connecter() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/appinventaire";
		String user="magasinier";
		String pass="mag";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver compatible ! ");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non compatible ! ");
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url, user, pass);
			if (con!=null)System.out.println("Connexion �tablie ! ");
		} catch (SQLException e) {
			System.out.println("Connexion non �tablie ! ");
			e.printStackTrace();
		}
		return con;
	}*/
	
	public void enregistrer(Ligne ut) {
		DBA bd = new DBA();
		String sql="insert into ligneinventaire(idinventaire, idproduit, quantite, prix) values(?, ?, ?, ?)";
		try (Connection connection = bd.seconnecter();
			 PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setInt(1, ut.getIdinventaire());
			pr.setInt(2, ut.getIdproduit());
			pr.setDouble(3, ut.getQuantite());
			pr.setDouble(4, ut.getPrix());
			int i = pr.executeUpdate();
			if(i!=0) System.out.println("Enregistrement ligne effectué ! ");
		} catch (SQLException e) {
			System.out.println("Enregistrement ligne non effectué ! ");
			e.printStackTrace();
		}
	}
	
	public List<Ligne> read(){
		List<Ligne> lig=new ArrayList<Ligne>();
		String sql="select * , prix*quantite as montant from ligneinventaire order by idligneInventaire desc;";
		DBA bd = new DBA();
		
		try(Connection connection = bd.seconnecter();Statement st = connection.createStatement();ResultSet rs=st.executeQuery(sql); ) {
	
			
			while(rs.next()){
				Ligne lige=new Ligne();
				lige.setIdligneInventaire(rs.getLong(1));
				lige.setIdinventaire(rs.getInt(2));
				lige.setIdproduit(rs.getInt(3));
				lige.setQuantite(rs.getDouble(4));
				lige.setPrix(rs.getDouble(5));
				lige.setMontant(rs.getDouble(6));
				
				lig.add(lige);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lig;
		
	}
	
public void deleteLine(long idl) {
	DBA bd = new DBA();
	String sql="delete from ligneinventaire where(idligneInventaire=?)";
	try (Connection connection = bd.seconnecter();
		 PreparedStatement pr = connection.prepareStatement(sql)) {
		pr.setLong(1, idl);
		int a = pr.executeUpdate();
		if(a!=0) System.out.println("Opération ligne effectuée ! ");
	} catch (SQLException e) {
		System.out.println("Opération ligne non effectuée ! ");
		e.printStackTrace();
	}
}


public Ligne getIdlignePourModif(long idl) {
	DBA bd = new DBA();
	Ligne abc = new Ligne();
	String sql="select * from ligneinventaire where(idligneInventaire=?)";
	try (Connection connection = bd.seconnecter();
		 PreparedStatement st = connection.prepareStatement(sql)) {
		st.setLong(1, idl);
		try (ResultSet rs = st.executeQuery()) {
			while(rs.next()) {
				abc.setIdligneInventaire(rs.getLong("idligneInventaire"));
				abc.setIdinventaire(rs.getInt("idinventaire"));
				abc.setIdproduit(rs.getInt("idproduit"));
				abc.setQuantite(rs.getDouble("quantite"));
				abc.setPrix(rs.getDouble("prix"));
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return abc;
}

public void ModifierLigne(Ligne ln){
	DBA bd = new DBA();
	String sql="update ligneinventaire set idinventaire=?, idproduit=?, quantite=?, prix=? where(idligneInventaire=?)";
	try (Connection connection = bd.seconnecter();
		 PreparedStatement pr = connection.prepareStatement(sql)) {
		pr.setInt(1, ln.getIdinventaire());
		pr.setInt(2, ln.getIdproduit());
		pr.setDouble(3, ln.getQuantite());
		pr.setDouble(4, ln.getPrix());
		pr.setLong(5, ln.getIdligneInventaire());
		int i = pr.executeUpdate();
		if(i!=0) System.out.println("Modification ligne effectuée ! ");
	} catch (SQLException e) {
		System.out.println("Modification ligne non effectuée ! ");
		e.printStackTrace();
	}
}

	
/*public void miseAjourLigne(Ligne ln ) {
	Connection connection =null;
	DBA bd = new DBA();
	connection = bd.seconnecter();
	StringBuilder sql = new StringBuilder("UPDATE ligneinventaire SET ");
	//On met � jour que les champs qui ont chang� de valeur
	//On supppose qu'un champ a chang� de valeur s'il n'est pas null
	List<Object> vals = new ArrayList();
	if(ln.idligneInventaire !=null) {
		sql.append("NumCart= ?, ");
		vals.add(ln.getIdligneInventaire());
	}
	if(ln.idinventaire !=null) {
		sql.append("Nom = ?, ");
		vals.add(user.getNom());
	}
	if(user.adress!=null) {
		sql.append("Adresse=?, ");
		vals.add(user.getTelephone());
	}
	if(user.telephone!=null) {
		sql.append("Telephone=?, ");
		vals.add(user.getTelephone());
	}
	if(user.typeUtilisateur!=null) {
		sql.append("TypeUtilisateur=?, ");
		vals.add(user.getTypeUtilisateur());
	}
	
	if(vals.isEmpty()) return;  //Rien n'a mettre � jour donc on ignore l'ex�cution de la requ�te 
	sql.setLength(sql.length()-2);
	sql.append(" WHERE NumCart =? ");
	
	try(PreparedStatement pst = cnx.prepareStatement(sql.toString())){ //toString pour convertir StringBuilder en String
		int size = vals.size();
		for(int i=0 ; i<size; i++) {
			pst.setObject(i+1 , vals.get(i));
		}
		pst.setString(size+1 , user.getNumCart());
		if(pst.executeUpdate()>0) {
			System.out.println("Les donn�es de l'utilisateur ont �t� mise � jour");
		}else {
			System.out.println("La mise � jour a �chou�");
		}
		pst.close();
	
		
	}catch(SQLException e) {
		System.out.println("Une erreur s'est produite : "+e.getMessage());
		
	}
	
}	*/

	

}
