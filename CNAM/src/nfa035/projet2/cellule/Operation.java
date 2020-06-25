package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;

/**
 *  <b>Cette classe réprésente un contenu possédant  dans sa formule une opération</b>
 *  <p> Les opérateurs sont listes dans l'énumération {@link Operateur Operateur} </p>
 * @author bbseb
 *
 */
public class Operation implements Contenu{
	private Contenu operande1,operande2;
	private Operateur operateur;
	private String formule;
	
	
	/**
	 * Ce constructeur instancie une opération à partir du contenu de deux cellules et d'un opérateur
	 * @param c1 est le contenu de la cellule 1
	 * @param c2 est le contenu de la cellule 2
	 * @param op est l'operateur de la l'opération
	 * @param formule est la formule de l'opération
	 */
	public Operation(Contenu c1,Contenu c2,Operateur op,String formule) {
		this.setOperande1(c1);
		this.setOperande2(c2);
		this.setOperateur(op);
		this.setFormule(formule);
	}

	/**
	 * @return the c1
	 */
	private Contenu getOperande1() {
		return this.operande1;
	}




	/**
	 * @param c1 the c1 to set
	 */
	private void setOperande1(Contenu c1) {
		this.operande1 = c1;
	}




	/**
	 * @return the c2
	 */
	private Contenu getOperande2() {
		return this.operande2;
	}




	/**
	 * @param c2 the c2 to set
	 */
	private void setOperande2(Contenu c2) {
		this.operande2 = c2;
	}




	/**
	 * @return the op
	 */
	private Operateur getOperateur() {
		return this.operateur;
	}




	/**
	 * @param op the op to set
	 */
	private void setOperateur(Operateur op) {
		this.operateur = op;
	}

	@Override
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}

	private void setFormule(String formule) {
		this.formule = formule;
	}


	@Override
	public float getResultat() throws ErreurAffichage {
		// TODO Auto-generated method stub
		float resultat = 0;
		switch (this.getOperateur().toChar()) {
			case '+':
				resultat = this.getOperande1().getResultat() + this.getOperande2().getResultat();
				break;
			case '-':
				resultat = this.getOperande1().getResultat() - this.getOperande2().getResultat();
				break;
			case '/':
				if(this.getOperande2().getResultat() == 0) 
					throw new ErreurAffichage("DIV/0");
				resultat = this.getOperande1().getResultat() / this.getOperande2().getResultat();
				break;
			case '*': 
				resultat = this.getOperande1().getResultat() * this.getOperande2().getResultat();
				break;
				
		}
		return resultat;
	}


	}
