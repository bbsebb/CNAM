package nfa011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



/*
 * Une fonction pl/sql permet d'�viter les mutiples  rrequete qui demande bcp de ressources pour y acceder depuis un programme en java. De cette facon, la bdd ne renvoie que les donn�es utiles au programme
 * De plus, cela permet de g�rer toutes l'integralit� des donn�es de la bdd dans la bdd et ainsi eviter du code superflu en java qui peut s'occuper uniquement du programme.
 */
public class Examen {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "ga9399ghr";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM Client";

		try (Connection con = DriverManager.getConnection(url, user, password); Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int nbrColonne = rsMetaData.getColumnCount();
			String formatageStrTuples = "";
			String formatageStrTitre = "";
			String separteur = "";
			for(int i = 1; i<= nbrColonne; i++) {
				int tailleCol = (rsMetaData.getColumnDisplaySize(i)>rsMetaData.getColumnName(i).length())?rsMetaData.getColumnDisplaySize(i):rsMetaData.getColumnName(i).length();
				formatageStrTitre += "| %-"+tailleCol+"s |";
				System.out.println(rsMetaData.getColumnDisplaySize(i));
				if(rsMetaData.getColumnTypeName(i)=="varchar")
					formatageStrTuples += "| %-"+tailleCol+"s |";
				else if(rsMetaData.getColumnTypeName(i)=="int4")
					formatageStrTuples += "| %"+tailleCol+"d |";
				
				for (int j = 0; j < tailleCol + 4; j++) {
					separteur += "-";
				}
			}
			/*
			System.out.println(formatageStrTuples);
			
			System.out.printf(formatageStrTitre+"\n", rsMetaData.getColumnName(1),
					rsMetaData.getColumnName(2), rsMetaData.getColumnName(3), rsMetaData.getColumnName(4),
					rsMetaData.getColumnName(5), rsMetaData.getColumnName(6), rsMetaData.getColumnName(7));

			System.out.println();
			while (rs.next()) {
				System.out.printf(formatageStrTuples+"\n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


