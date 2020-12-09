package nfa035.td;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Td7 {
	public static void main(String[] args) {
		File f = new File("/home/bbsebb/programmation/java/projet/CNAM/CNAM/src/nfa035/td/td7/exercice1.txt");
		File f2 = new File("/home/bbsebb/programmation/java/projet/CNAM/CNAM/src/nfa035/td/td7/exercice2.txt");
		File f3 = new File("/home/bbsebb/programmation/java/projet/CNAM/CNAM/src/nfa035/td/td7/exercice3.txt");
		BufferedReader lecteur;
		BufferedWriter redacteur;
		// Exercice 1
		try {
			lecteur = new BufferedReader(new FileReader(f));
			int c = lecteur.read();
			int[] tab = new int[256];
			while (c != -1) {
				tab[c]++;
				c = lecteur.read();
			}

			for (int i = 97; i < 97 + 26; i++) {
				System.out.println("La lettre " + (char) i + " apparait " + tab[i]);
			}

			lecteur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Exercice 2

		try {
			lecteur = new BufferedReader(new FileReader(f));
			redacteur = new BufferedWriter(new FileWriter(f2));
			String str = lecteur.readLine();
			while (str != null) {
				redacteur.write(str.toUpperCase());
				str = lecteur.readLine();
			}
			redacteur.close();
			lecteur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Exercice 3
		try {

			redacteur = new BufferedWriter(new FileWriter(f3));
			ArrayList<String> l = new ArrayList<String>();
			l.add("Enfant, on vous dira plus tard que le grand-père");
			l.add("Vous adorait ; qu'il fit de son mieux sur la terre,");
			l.add("Qu'il eut fort peu de joie et beaucoup d'envieux,");
			l.add("Qu'au temps où vous étiez petits il était vieux,");
			l.add("Qu'il n'avait pas de mots bourrus ni d'airs moroses,");
			l.add("Et qu'il vous a quittés dans la saison des roses ;");
			l.add("Qu'il est mort, que c'était un bonhomme clément ;");
			l.add("Que, dans l'hiver fameux du grand bombardement,");
			l.add("Il traversait Paris tragique et plein d'épées,");
			l.add("Pour vous porter des tas de jouets, des poupées,");
			l.add("Et des pantins faisant mille gestes bouffons ;");
			l.add("Et vous serez pensifs sous les arbres profonds.");
			l.add("1er janvier 1871 - Victor HUGO (1802-1885)");
			for (String str : l) {
				redacteur.write(str);
				redacteur.newLine();
			}
			lecteur = new BufferedReader(new FileReader(f3));
			String str = lecteur.readLine();
			while (str != null) {
				str = lecteur.readLine();
			}
			lecteur.close();
			redacteur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Exercice 4
		parcoursDossier(new File("/home/bbsebb/programmation/"), "");
	}

	 static void parcoursDossier(File file, String tabulation) {
		 String str ;
		for (File f : file.listFiles( new Filtre())) {
			str =  tabulation + "|-" + f.getName();
			if(f.isDirectory())
				str += "*";
			System.out.println(str);
			if (f.isDirectory()) {
				parcoursDossier(f, tabulation + "  ");
			}
			
		}
	}

	 
}
class Filtre implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		String nom = pathname.getName();
		if (nom.endsWith(".java") || pathname.isDirectory())
			return true;
		else
			return false;
	}

}
