package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;

public class Erreur implements Contenu{
	private String formule;

	
	public Erreur() {
		this.setFormule(null);
	}
	

	private void setFormule(String formule) {
		this.formule = formule;
	}

	@Override
	public float getResultat() throws ErreurAffichage {
		// TODO Auto-generated method stub
		throw new ErreurAffichage();
	}

	@Override
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}
}
