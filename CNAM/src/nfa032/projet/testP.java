package nfa032.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/nfa032/projet/img/testRec.ppm";
		
		
		
		Path chemin = Paths.get(path);
		BufferedReader lecteur = null;
		try {
			lecteur = Files.newBufferedReader(chemin, StandardCharsets.US_ASCII);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image img = new Image();
		try {
			img.chargerImg(lecteur,path,"test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		path = "src/nfa032/projet/img/testRec2.ppm";
		chemin = Paths.get(path);
		BufferedWriter redacteur;
		try {
			redacteur = Files.newBufferedWriter(chemin, StandardCharsets.US_ASCII);
			img.enregistrerImg(redacteur);
			redacteur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("test");
	}

}
