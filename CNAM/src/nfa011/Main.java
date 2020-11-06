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
		// int value = (int) (Math.random() * 11);
		//
		// switch( value ) {
		// case 0, 1, 2, 3, 4 -> System.out.println( "Petit chiffre" );
		// case 5, 6, 7, 8, 9 -> System.out.println( "Grand chiffre" );
		// default -> System.out.println( "Ce n'est plus un chiffre, mais un nombre" );
		// }
		ListeTables lt = new ListeTables();
		int nbrTable = lt.affichageTables();
		try (Scanner sc = new Scanner(System.in)) {
			int choix = sc.nextInt();
			if (choix > 0 && choix < nbrTable + 1)
				lt.affichageTable(choix - 1);
		}
	}

}

class ListeTables {
	private ArrayList<String> tables = new ArrayList<String>();

	String url = "jdbc:postgresql://192.168.1.41:5432/ComptesDB";
	String login = "postgres";
	String psw = "ga9399ghr";

	void Listetable() {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int affichageTables() {
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	void affichageTable(int numTable) {
		String SQL = "SELECT * FROM " + tables.get(numTable);
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection à la BDD");
		}
		
		try (Connection con = DriverManager.getConnection(url, login, psw); Statement st = con.createStatement();) {

			try (ResultSet rs = st.executeQuery(SQL)) {
				ResultSetMetaData meta = rs.getMetaData();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					//System.out.print(meta.getColumnTypeName(i) + "  = ");
					System.out.printf("%-17s",meta.getColumnName(i) + " - ");
				}
				System.out.println();
				while (rs.next()) {
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						//System.out.print(meta.getColumnTypeName(i) + "  = ");
						System.out.printf("%-17s",rs.getString(i) + " - ");
					}
					System.out.println();
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}