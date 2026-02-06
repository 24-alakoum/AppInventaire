package app.metier.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBA {

	public DBA() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection seconnecter() {
		//Init connect
		Connection connection = null;
		//Les parametres de connexion à la base 
		String url = "jdbc:mysql://localhost:3306/appinventaire?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "segalleg@1230";
		//Class for name pour charger le pilote de mysql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Pilote compatible !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de pilote !!! "+e.getMessage());
			e.printStackTrace();
		}
		
		//Ouvrier la connexion
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			if(connection!= null)System.out.println("Connection etablie !");
			else System.out.println("Connection echouée !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de Connection !!! "+e.getMessage());
			e.printStackTrace();
		}
		
		
		return connection;
		
		
	}
	
	public static void main(String [] args) {
		new DBA().seconnecter();
	}

}
