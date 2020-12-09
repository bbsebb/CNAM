package nfa011;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class TP1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean bc = true;
		ListeTables lt = null;
		int choix = 0;
		int nbrTable = 0;
		while (bc) {
			try {
				lt = new ListeTables();
				nbrTable = lt.affichageTables();
			} catch (SQLException e) {
				System.out.println("Erreur dans l'affichage des tables : \n" + e.getMessage());
				choix = 0;
			}
			try {
				System.out.println("Selectionnez votre choix :");
				choix = sc.nextInt();
				if (choix > 0 && choix < nbrTable + 1)
					lt.affichageTable(choix - 1);
				else if (choix == 0)
					bc = false;
				else
					throw new IndexOutOfBoundsException("Il faut choisir un numéro de la liste");
			} catch (InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("Mauvais numéro : \n" + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Erreur dans l'affichage de la table : \n" + e.getMessage());
			}

		}
	}

}

class ListeTables {
	private ArrayList<String> tables = new ArrayList<String>();
	String url;
	String login;
	String psw;
	String jbdcDriver;

	ListeTables() throws SQLException {
		// On récupère les propriétés de connexion
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("conf.properties")) {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.url = props.getProperty("jdbc.url");
		this.login = props.getProperty("jdbc.login");
		this.psw = props.getProperty("jdbc.pw");
		this.jbdcDriver = props.getProperty("jdbc.driver.class");

		try {
			Class.forName(this.jbdcDriver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection � la BDD");
		}

		// On récupère la liste des tables du shema public de la bdd
		try (Connection con = DriverManager.getConnection(this.url, this.login, this.psw)) {
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
			Class.forName(jbdcDriver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection � la BDD");
		}

		try (Connection con = DriverManager.getConnection(url, login, psw)) {
			// On efface l'ancienne table pour la réaffecter si jamais il y a eu des
			// modifications.
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

	void affichageTable(int numTable) throws SQLException, IndexOutOfBoundsException {
		String SQL = "SELECT * FROM " + tables.get(numTable);
		if (numTable < 0 || numTable > tables.size() - 1)
			throw new IndexOutOfBoundsException();
		try {
			Class.forName(jbdcDriver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Erreur de connection à la BDD");
		}

		try (Connection con = DriverManager.getConnection(url, login, psw); Statement st = con.createStatement();) {

			try (ResultSet rs = st.executeQuery(SQL)) {
				ResultSetMetaData meta = rs.getMetaData();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					System.out.print("-------------------");
				}
				System.out.println();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					System.out.print("|");
					System.out.printf("%-17s", meta.getColumnName(i));
					System.out.print("|");
				}
				System.out.println();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					System.out.print("-------------------");
				}
				System.out.println();
				while (rs.next()) {
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						String str;

						str = rs.getString(i);
						if (str != null && str.length() > 15)
							str = str.substring(0, 14);
						System.out.print("|");
						System.out.printf("%-17s", str);
						System.out.print("|");
					}
					System.out.println();

				}
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					System.out.print("-------------------");
				}
				System.out.println();
			}
		}
	}

}