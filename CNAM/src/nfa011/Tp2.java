package nfa011;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Tp2 {

	public static void main(String[] args) {

		// R�cup�ration des propri�t�s de connexion � la BDD
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

			String[] tab = { "TABLE" }; // On r�cup�re uniquement les tables de type TABLE
			String shema = "public"; // On cherche les tables dans le shema "public "

			System.out.print(metaDB.getDatabaseProductName() + " " + metaDB.getDatabaseProductVersion() + " "
					+ metaDB.getUserName());
			System.out.println();
			System.out.println("  |");

			try (ResultSet rsTables = metaDB.getTables(null, shema, "%", tab)) { // R�cup�ration de la liste des tables
				while (rsTables.next()) {
					String table = rsTables.getString(3);
					System.out.println("  |-" + table);
					try (ResultSet rsPKey = metaDB.getPrimaryKeys(null, shema, table);
							ResultSet rsCol = metaDB.getColumns(null, shema, table, null)) { // R�cup�ration de
																								// metadonn�es sur la
																								// table "table"
						while (rsCol.next()) {
							String nullable = (rsCol.getInt(11) == 0) ? "Non nullable" : "Nullable";
							System.out.println("       |-" + rsCol.getString(4) + " " + nullable);
						}
						while (rsPKey.next()) {
							System.out.println("                  cl� primaire :" + rsPKey.getString(4));
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
