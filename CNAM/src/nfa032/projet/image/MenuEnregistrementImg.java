package nfa032.projet.image;

import java.io.BufferedWriter;
import java.io.IOException;

public interface MenuEnregistrementImg {
	public void enregistrerImgFocus(BufferedWriter redacteur) throws IOException;
	public String getSourceFocus();
}
