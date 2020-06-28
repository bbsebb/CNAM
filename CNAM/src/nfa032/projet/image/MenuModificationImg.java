package nfa032.projet.image;

public interface MenuModificationImg {
	public void mettreEnNBFocus();
	public int getHauteurFocus();
	public int getLargeurFocus();
	public void recadrerFocus(int l1, int l2, int c1, int c2);
	public void mettreNegatifFocus() ;
	public void foncerImgFocus(String couleur);
	public void eclairecirImgFocus(String couleur);
	public void modifierLargeurFocus(int l);
	public void modifierHauteurFocus(int h);
	public void inscrusterRectangleFocus(int coinSupGaucheX, int coinSupGaucheY, int largeur, int hauteur, String couleur);
	
}
