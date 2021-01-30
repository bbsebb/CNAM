package nfa011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;




public class Examen {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "ga9399ghr";

		try {
			Class.forName("org.postgresql.Driver"); // On charge le driver
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
			
			// On prépare la mise en forme des données
			for(int i = 1; i<= nbrColonne; i++) {
				// Pour chaque colonne, on récupère la taille des données maximales ou le titre de la colonne maximal
				int tailleCol = (rsMetaData.getColumnDisplaySize(i)>rsMetaData.getColumnName(i).length())?rsMetaData.getColumnDisplaySize(i):rsMetaData.getColumnName(i).length();
				formatageStrTitre += "| %-"+tailleCol+"s |"; // On crée un formatage de la taille de colonne pour le titre
				if(rsMetaData.getColumnTypeName(i)=="varchar")
					formatageStrTuples += "| %-"+tailleCol+"s |"; // On crée un formatage de la taille de colonne pour une colonne d'un tuple renvoyant du texte
				else if(rsMetaData.getColumnTypeName(i)=="int4")
					formatageStrTuples += "| %"+tailleCol+"d |"; // On crée un formatage de la taille de colonne pour une colonne d'un tuple renvoyant un décimal
				
				// On ajoute les séparateur de ligne, avec 4 en plus qui correspondent au espace et |
				for (int j = 0; j < tailleCol + 4; j++) {
					separteur += "-";
				}
			}
			
			System.out.println(separteur);
			//Affichage des libellés de colonne
			System.out.printf(formatageStrTitre+"\n", rsMetaData.getColumnName(1),
					rsMetaData.getColumnName(2), rsMetaData.getColumnName(3), rsMetaData.getColumnName(4),
					rsMetaData.getColumnName(5), rsMetaData.getColumnName(6), rsMetaData.getColumnName(7));

			System.out.println(separteur);
			//Parcours et affichage des tuples
			while (rs.next()) {
				System.out.printf(formatageStrTuples+"\n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			}
			System.out.println(separteur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


