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

		String url = "jdbc:postgresql://192.168.1.41:5432/test";
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
			for (int i = 0; i < (12 + 24 + 24 + 54 + 14 + 14); i++) {
				System.out.print("-");
			}
			System.out.println();
			System.out.printf("| %-8s || %-20s || %-20s || %-50s || %-10s || %-10s |\n", rsMetaData.getColumnName(1),
					rsMetaData.getColumnName(2), rsMetaData.getColumnName(3), rsMetaData.getColumnName(4),
					rsMetaData.getColumnName(5), rsMetaData.getColumnName(6));
			for (int i = 0; i < (12 + 24 + 24 + 54 + 14 + 14); i++) {
				System.out.print("-");
			}
			System.out.println();
			while (rs.next()) {
				System.out.printf("| %8d || %20s || %20s || %50s || %10d || %010d |\n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


