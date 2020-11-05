package nfa011;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			System.out.println("Erreur de connection � la BDD");
			;
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
			System.out.println("Erreur de connection � la BDD");
			;
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

	}

}