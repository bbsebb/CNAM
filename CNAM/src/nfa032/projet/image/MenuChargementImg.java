package nfa032.projet.image;

import java.io.BufferedReader;
import java.io.IOException;

public interface MenuChargementImg {
	public boolean estVide();
	public void ajoutImg(BufferedReader lecteur, String source, String fileName) throws IOException;
}
