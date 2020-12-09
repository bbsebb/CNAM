package nfa011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgQueryToCSV {

	public static void main(String[] args) {

	}

	
	class MyConnection {
		static final String DRIVER = "org.postgresql.Driver";
		private String url;
		private String login;
		private String pw;

		public MyConnection(String url, String login, String pw) {
			this.url = url;
			this.login = login;
			this.pw = pw;

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try (Connection con = DriverManager.getConnection(url, login, pw)) {
				System.out.println("Connection à la bdd reussi ...");
			} catch (SQLException e) {
				System.err.println("La connexion a echoué : \n" + e.getMessage());
			}
		}

	}

	class MyQuery {
		private Connection con;
		private String requete;
		
		public MyQuery(Connection con, String requete) {
			super();
			this.con = con;
			this.requete = requete;
		}
		
		
		

	}

	class WriteCSV {
		private String path;
	}

}
