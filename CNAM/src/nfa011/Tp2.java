package nfa011;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Tp2 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try(FileInputStream fis = new FileInputStream("conf.properties")) {
			prop.load(fis);
			Class.forName(prop.getProperty("jdbc.driver.class"));
		} catch (Exception e) {
			e.printStackTrace();
		} 

		try(Connection con = DriverManager.getConnection(prop.getProperty("jdbc.url"),prop.getProperty("jdbc.login"),prop.getProperty("jdbc.pw"))) {
			DatabaseMetaData metaDB = con.getMetaData();
			System.out.println(metaDB.getDatabaseProductName());
			System.out.println(metaDB.getDatabaseProductVersion());
			System.out.println(metaDB.getUserName());
			String[] tab = { "TABLE" };
			try(ResultSet rsTables = metaDB.getTables(null, "public", "%", tab)) {
				ResultSetMetaData metaTables = rsTables.getMetaData();
				int nbrColonnes = metaTables.getColumnCount();
				while(rsTables.next()) {
					System.out.println(rsTables.getString(3));
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
