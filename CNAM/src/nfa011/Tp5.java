package nfa011;

import java.sql.*;
import java.util.Scanner;

public class Tp5 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Bienvenu");
			System.out.println("Entrer l'url du servers sans le dernier '/':");
			String urlServer = sc.nextLine();
			System.out.println("Entrer votre login :");
			String login = sc.nextLine();
			System.out.println("Entrer votre pw:");
			String pwd = sc.nextLine();
			System.out.println("Entrer votre BDD source:");
			String nameBDD1 = sc.nextLine();
			System.out.println("Entrer la table source:");
			String tableBDD1 = sc.nextLine();
			System.out.println("Entrer votre BDD cible:");
			String nameBDD2 = sc.nextLine();
			System.out.println("Entrer la table cible:");
			String tableBDD2 = sc.nextLine();

			copie(urlServer, login, pwd, nameBDD1, nameBDD2, tableBDD1, tableBDD2);
		}
	}

	static void copie(String urlServer, String login, String pwd, String nameBDD1, String nameBDD2, String tableBDD1,
			String tableBDD2) {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conBDD1 = DriverManager.getConnection(urlServer + "/" + nameBDD1, login, pwd);
				Connection conBDD2 = DriverManager.getConnection(urlServer + "/" + nameBDD2, login, pwd)) {

			String prepareSQL = "INSERT INTO " + tableBDD2
					+ " (code_client,nom,prenom,adresse,code_postal,ville,email) VALUES (?,?,?,?,?,?,?)";
			try (Statement st1 = conBDD1.createStatement();
					PreparedStatement st2 = conBDD2.prepareStatement(prepareSQL);
					ResultSet rs = st1.executeQuery("SELECT * FROM " + tableBDD1)) {
				while (rs.next()) {
					st2.setInt(1, rs.getInt(1));
					st2.setString(2, rs.getString(2));
					st2.setString(3, rs.getString(3));
					st2.setString(4, rs.getString(5));
					st2.setString(5, rs.getString(6));
					st2.setString(6, rs.getString(7));
					st2.setString(7, rs.getString(9));
					st2.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
