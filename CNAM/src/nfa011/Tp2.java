package nfa011;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Tp2 {

	public static void main(String[] args) {

		// Récupération des propriétés de connexion à la BDD
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream("conf.properties")) {
			prop.load(fis);
			Class.forName(prop.getProperty("jdbc.driver.class"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.login"),
				prop.getProperty("jdbc.pw"))) {
			DatabaseMetaData metaDB = con.getMetaData();

			String[] tab = { "TABLE" }; // On récupère uniquement les tables de type TABLE
			String shema = "public"; // On cherche les tables dans le shema "public "

			System.out.print(metaDB.getDatabaseProductName() + " " + metaDB.getDatabaseProductVersion() + " "
					+ metaDB.getUserName());
			System.out.println();
			System.out.println("  |");

			try (ResultSet rsTables = metaDB.getTables(null, shema, "%", tab)) { // Récupération de la liste des tables
				while (rsTables.next()) {
					String table = rsTables.getString(3);
					System.out.println("  |-" + table);
					try (ResultSet rsPKey = metaDB.getPrimaryKeys(null, shema, table);
							ResultSet rsCol = metaDB.getColumns(null, shema, table, null)) { // Récupération de
																								// metadonnées sur la
																								// table "table"
						while (rsCol.next()) {
							String nullable = (rsCol.getInt(11) == 0) ? "Non nullable" : "Nullable";
							System.out.println("       |-" + rsCol.getString(4) + " " + nullable);
						}
						while (rsPKey.next()) {
							System.out.println("                  clé primaire :" + rsPKey.getString(4));
						}
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
