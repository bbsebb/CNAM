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
			
			try (Connection con = DriverManager.getConnection(url, login, pw)) {
				System.out.println("Connection à la bdd reussi ...");
				boolean menu = true;
				MyQuery q = null;
				while (menu) {
					
					afficherMenu();
					
					int chx = sc.nextInt();
					sc.nextLine();
					switch (chx) {
						case 1 -> {
							System.out.println("Entrer votre requete 'SELECT'");
							String sql = sc.nextLine();
							String rgx = "^SELECT[^;]*(;|.)$"; // La requête commence par SELECT et se termine par un ; ou rien mais il ne peux rien avoir après un ;
							if(Pattern.compile(rgx, Pattern.CASE_INSENSITIVE).matcher(sql).matches()) // On vérifie que la requete est correcte
								q = new MyQuery( con, sql);
							else
								System.err.println("Votre requète est incorrecte");
						}
						
						case 3 -> {
							menu = false;
						}
						default -> {
							System.err.println("Entrer 1 ou 2 !");
						}
					}
				}
				
			} catch (SQLException e) {
				System.err.println("La connexion a echoué : \n"+e.getMessage());
			}
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
