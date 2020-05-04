package nfa032.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path chemin =  Paths.get("src/nfa032/projet/img/chien.ppm");
		BufferedReader  lecteur = null;
		try {
			lecteur = 	Files.newBufferedReader(chemin);
			System.out.println(lecteur.readLine());
			System.out.println(lecteur.readLine());
			System.out.println(lecteur.readLine());
			System.out.println(lecteur.readLine());
			int c = lecteur.read();
			while(c!=-1) {
		//		System.out.print((char) c);
				c = lecteur.read();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(lecteur!=null)
				try {
					lecteur.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}
