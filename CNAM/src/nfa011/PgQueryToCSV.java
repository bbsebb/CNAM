package nfa011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PgQueryToCSV {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Bienvenu");
			System.out.println("Entrer l'url de la BDD :");
			String url = sc.nextLine();
			System.out.println("Entrer votre login :");
			String login = sc.nextLine();
			System.out.println("Entrer votre pw:");
			String pw = sc.nextLine();
			

	}

	
	
	}

	/**
	 * Affiche le menu
	 */
	static void afficherMenu() {
		System.out.println("Menu");
		System.out.println("-------------------------------------------");
		System.out.println("1 : Exécuter une requête de type SELECT.");
		System.out.println("2 : Exporter la résultat de la requète en format CSV");
		System.out.println("3 : Quitter le programme.");
	}
}


class MyQuery {
	private Connection con;
	private String requete;
	
	public MyQuery(Connection con, String requete) {
		setCon(con);
		setRequete(requete);
	}

	public Connection getCon() {
		return con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}

	public String getRequete() {
		return requete;
	}

	private void setRequete(String requete) {
		this.requete = requete;
	}
	
	
	

}

class WriteCSV {
	private String path;
}
