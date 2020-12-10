package nfa011;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
				while (menu) {

					afficherMenu();

					int chx = sc.nextInt();
					sc.nextLine();
					switch (chx) {
					case 1 -> {
						System.out.println("Entrer votre requete 'SELECT'");
						String sql = sc.nextLine();
						try {
							afficherQuery(sql,con);
						} catch (Exception e) {
							System.err.println("Votre requète est incorrecte");
						}
						System.out.println("Voulez-vous exporter votre requète (o/n ?)");
						String reponseExport = sc.nextLine();
						if(reponseExport.toLowerCase().equals("o")) {
							System.out.println("Entrez le chemin du dossier d'enregistrement");
							String path = sc.nextLine();
							queryToCSV(sql,con,path) ;
						}
					}

					case 2 -> {
						menu = false;
					}
					default -> {
						System.err.println("Entrer 1 ou 2 !");
					}
					}
				}

			} catch (SQLException e) {
				System.err.println("La connexion a echoué : \n" + e.getMessage());
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
		System.out.println("2 : Quitter le programme.");
	}
	
	/**
	 * Affiche la table demandée par la requete sql
	 * @param sql est la requète à afficher
	 * @param con est la connection à la bdd ou se trouve la table à afficher
	 */
	static void afficherQuery(String sql, Connection con)  {
		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			ResultSetMetaData rsMeta = rs.getMetaData();
			int nbrCol = rsMeta.getColumnCount();
			int[] sizeCol = sizeColumn(rs);
			ligne(rs);
			System.out.println();
			for (int i = 1; i <= nbrCol; i++) {
				System.out.printf("| %-" + sizeCol[i - 1] + "s |", rsMeta.getColumnName(i));
			}
			System.out.println();
			ligne(rs);
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= nbrCol; i++) {
					System.out.printf("| %-" + sizeCol[i - 1] + "s |", rs.getString(i));
				}
				System.out.println();
			}
			ligne(rs);
			System.out.println();
		} catch (SQLException e) {
			System.err.println("La requete " + sql + " a échoué : \n" + e.getMessage());
		}
	}
	
	/**
	 * Exporte la table demandée par la requete sql
	 * @param pathSTR est chemin du fichier
	 * @param sql est la requète à afficher
	 * @param con est la connection à la bdd ou se trouve la table à afficher
	 */
	static void queryToCSV(String sql, Connection con, String pathSTR)  {
		Path path = Paths.get(pathSTR);
		
		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			ResultSetMetaData rsMeta = rs.getMetaData();
			int nbrCol = rsMeta.getColumnCount();
			try(BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
				
			
			while (rs.next()) {
				for (int i = 1; i <= nbrCol; i++) {
					bw.write(rs.getString(i) +";");
				}
				bw.newLine();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.err.println("La requete " + sql + " a échoué : \n" + e.getMessage());
		}
	}
	
	static boolean estSelect(String sql) {
		String rgx = "^SELECT[^;]*(;|.)$"; // La requête commence par SELECT et se termine par un ; ou rien mais il ne
											// peux rien avoir après un ;
		if (Pattern.compile(rgx, Pattern.CASE_INSENSITIVE).matcher(sql).matches()) // On vérifie que la requete est
																					// correcte
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de faire une ligne de la taille d'une table
	 * @param rsMeta
	 * @param sizeCol
	 * @throws SQLException
	 */
	static void ligne(ResultSet rs) throws SQLException {
		ResultSetMetaData rsMeta = rs.getMetaData();
		int nbrCol = rsMeta.getColumnCount();
		int[] sizeCol = sizeColumn(rs);
		for (int i = 0; i < nbrCol; i++) {
			for (int j = 0; j < sizeCol[i] + 4; j++) { // on ajoute 4 -, car il y a un caratère d'échapement ajouté de
														// chaque coté de chaque colonne
				System.out.print("-");
			}
		}
	}
	
	/**
	 * Retourne la taille des colonnes de la requete rs
	 * @param rs sont les resultats de la requète
	 * @return la taille des colonnes de la table dont fait l'object la requète rs
	 * @throws SQLException
	 */
	static int[] sizeColumn(ResultSet rs) throws SQLException {
		ResultSetMetaData rsMeta = rs.getMetaData();
		int nbrCol = rsMeta.getColumnCount();
		int[] sizeCol = new int[nbrCol];
		for (int i = 1; i <= nbrCol; i++) {
			sizeCol[i - 1] = (rsMeta.getColumnDisplaySize(i) > rsMeta.getColumnName(i).length())
					? rsMeta.getColumnDisplaySize(i)
					: rsMeta.getColumnName(i).length();
		}
		return sizeCol;
	}

}



