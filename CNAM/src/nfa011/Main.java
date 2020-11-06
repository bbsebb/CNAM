package nfa011;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ListeTables lt = new ListeTables();
		int nbrTable = 0;
		try {
			nbrTable = lt.affichageTables();
		} catch (SQLException e) {
			System.out.println("Erreur dans l'affichage des tables : \n" + e.getMessage());
		}
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Selectionnez votre choix :");
			int choix = sc.nextInt();
			if (choix > 0 && choix < nbrTable + 1)
				lt.affichageTable(choix - 1);
		} catch (SQLException e) {
			System.out.println("Erreur dans l'affichage de la table : \n" + e.getMessage());
		}
	}

}

class ListeTables {
	private ArrayList<String> tables = new ArrayList<String>();

	String url = "jdbc:postgresql://192.168.1.41:5432/ComptesDB";
	String login = "postgres";
	String psw = "ga9399ghr";

	void Listetable() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection à la BDD");
		}

		try (Connection con = DriverManager.getConnection(url, login, psw)) {
			DatabaseMetaData meta = con.getMetaData();
			String[] tab = { "TABLE" };
			try (ResultSet rslt = meta.getTables(null, "public", "%", tab)) {
				while (rslt.next()) {
					tables.add(rslt.getString(3));
				}
			}
		}
	}

	int affichageTables() throws SQLException {
		int i = 1;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection à la BDD");
		}

		try (Connection con = DriverManager.getConnection(url, login, psw)) {
			tables.clear();
			DatabaseMetaData meta = con.getMetaData();
			String[] tab = { "TABLE" };
			try (ResultSet rslt = meta.getTables(null, "public", "%", tab)) {
				System.out.println("-----------------------------------\n" + "-             Tables              -\n"
						+ "-----------------------------------\n");
				while (rslt.next()) {
					tables.add(rslt.getString(3));
					System.out.println(i++ + " : " + rslt.getString(3));
				}
				System.out.println("0 : Quitter");
			}
		}

		return i;
	}

	void affichageTable(int numTable) throws SQLException,  IndexOutOfBoundsException{
		String SQL = "SELECT * FROM " + tables.get(numTable);
		if(numTable < 0 || numTable > tables.size() -1)
			throw new IndexOutOfBoundsException();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection à la BDD");
		}

		try (Connection con = DriverManager.getConnection(url, login, psw); Statement st = con.createStatement();) {

			try (ResultSet rs = st.executeQuery(SQL)) {
				ResultSetMetaData meta = rs.getMetaData();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					System.out.printf("%-17s", "|" + meta.getColumnName(i) + "|");
				}
				System.out.println();
				while (rs.next()) {
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						String str = rs.getObject(1).toString();
						if (str.length() > 15)
							str = str.substring(0, 14);
						System.out.printf("%-17s", "|" + rs.getString(i) + "|");
					}
					System.out.println();

				}
			}
		}
	}

}