package nfa032.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class programme {
	public static void main(String[] args) {
			String path = "src/nfa032/projet/img/chouette2.ppm";
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
				img.chargerImg(lecteur);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			System.out.println("test");
	}
	
}
