package nfa011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Examen {

	public static void main(String[] args) {
		afficherListeEleveNantes();
		
	}
	
	public static void afficherListeEleveNantes() {
		String url = "jdbc:postgresql://localhost:5432/examen2";
		String user = "postgres";
		String password = "ga9399ghr";

		try {
			Class.forName("org.postgresql.Driver"); // On charge le driver
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM Eleve ";


		try (Connection con = DriverManager.getConnection(url, user, password); Statement st = con.createStatement()) {
			
			ResultSet rs = st.executeQuery(sql);	
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int nbrColonne = rsMetaData.getColumnCount();
			
			/* --------------------------------------------
			 * Préparation de la mise en forme des résultat
			 * -------------------------------------------- */
			String formatageStrTuples = "| %16d || %-20s || %-20s || %-50s || %14d || %-50s |";
			String formatageStrTitre = "| %-16s || %-20s || %-20s || %-50s || %-14s || %-50s |";
			
			/* --------------------------------------------
			 * Affichage des résultats formatés
			 * -------------------------------------------- */	 
			
			//Affichage des libellés de colonne
			System.out.printf(formatageStrTitre+"\n", rsMetaData.getColumnName(1),
					rsMetaData.getColumnName(2), rsMetaData.getColumnName(3), rsMetaData.getColumnName(4),
					rsMetaData.getColumnName(5), rsMetaData.getColumnName(6));

			System.out.println();
			//Parcours et affichage des tuples
			while (rs.next()) {
				System.out.printf(formatageStrTuples+"\n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


