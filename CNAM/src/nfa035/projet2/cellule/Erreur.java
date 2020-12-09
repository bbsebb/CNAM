package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;

/**
 * <b>Cette classe r�pr�sente un contenu poss�dant une formule �ron�e et renvoie une exception � la place du r�sultat</b>
 * @author bbseb
 *
 */
public class Erreur implements Contenu{
	private String formule,typeErreur;

	/**
	 * Constructeur par defaut
	 */
	public Erreur() {
		this.setFormule(null);
		this.setTypeErreur("Inconnu");
	}
	
	/**
	 * Ce constructeur indique l'erreur � afficher
	 * @param erreur est l'erreur qui sera affich� dans l'exception
	 */
	public Erreur(String erreur) {
		this.setFormule(null);
		this.setTypeErreur(erreur);
	}	

	private void setFormule(String formule) {
		this.formule = formule;
	}

	@Override
	public float getResultat() throws ErreurAffichage {
		// TODO Auto-generated method stub
		throw new ErreurAffichage(this.getTypeErreur());
	}

	@Override
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}


	/**
	 * @return the typeErreur
	 */
	public String getTypeErreur() {
		return typeErreur;
	}


	/**
	 * @param typeErreur the typeErreur to set
	 */
	public void setTypeErreur(String typeErreur) {
		this.typeErreur = typeErreur;
	}
}
