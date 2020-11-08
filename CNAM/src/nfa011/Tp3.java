package nfa011;

import java.sql.*;
import java.util.Scanner;

public class Tp3 {

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
						afficherQuery(sql, con);
					}
					case 2 -> {
						menu = false;
					}
					default -> {
						System.out.println("Entrer 1 ou 2 !");
					}
					}
				}
			} catch (SQLException e) {
				System.err.println("La connexion a echoué : \n"+e.getMessage());
			}
		}

	}

	static void afficherMenu() {
		System.out.println("Menu");
		System.out.println("-------------------------------------------");
		System.out.println("1 : Exécuter une requête de type SELECT.");
		System.out.println("2 : Quitter le programme.");
	}

	static void afficherQuery(String sql, Connection con)  {
		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			ResultSetMetaData rsMeta = rs.getMetaData();
			int nbrCol = rsMeta.getColumnCount();
			int[] sizeCol = new int[nbrCol];
			for (int i = 1; i <= nbrCol; i++) {
				sizeCol[i - 1] = (rsMeta.getColumnDisplaySize(i) > rsMeta.getColumnName(i).length())
						? rsMeta.getColumnDisplaySize(i)
						: rsMeta.getColumnName(i).length();
			}
			ligne(rsMeta, sizeCol);
			System.out.println();
			for (int i = 1; i <= nbrCol; i++) {
				System.out.printf("| %-" + sizeCol[i - 1] + "s |", rsMeta.getColumnName(i));
			}
			System.out.println();
			ligne(rsMeta, sizeCol);
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= nbrCol; i++) {
					System.out.printf("| %-" + sizeCol[i - 1] + "s |", rs.getString(i));
				}
				System.out.println();
			}
			ligne(rsMeta, sizeCol);
			System.out.println();
		} catch (SQLException e) {
			System.err.println("La requete " + sql + " a échoué : \n" + e.getMessage());
		}
	}

	static void ligne(ResultSetMetaData rsMeta, int[] sizeCol) throws SQLException {
		int nbrCol = rsMeta.getColumnCount();
		for (int i = 0; i < nbrCol; i++) {
			for (int j = 0; j < sizeCol[i] + 4; j++) { // on ajoute 4 -, car il y a un caratère d'échapement ajouté de
														// chaque coté de chaque colonne
				System.out.print("-");
			}
		}
	}

}
