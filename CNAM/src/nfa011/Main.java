package nfa011;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args)  {
        switch( value ) {
        case 0, 1, 2, 3, 4 -> System.out.println( "Petit chiffre" );
        case 5, 6, 7, 8, 9 -> System.out.println( "Grand chiffre" );
        default -> System.out.println( "Ce n'est plus un chiffre, mais un nombre" );
    }
	
		boolean boucle = true;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de connection � la BDD");;
		}
		String url = "jdbc:postgresql://192.168.1.41:5432/ComptesDB";
		String login = "postgres";
		String psw = "ga9399ghr";
		try(Connection con = DriverManager.getConnection(url,login,psw)) {
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rslt = meta.getTables(con.getCatalog(), null, "%",null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(boucle) {
			
		}
	



	}

}
