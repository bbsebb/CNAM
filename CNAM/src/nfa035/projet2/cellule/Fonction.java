package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.feuille.Bloc;

/**
 * <b>Cette classe réprésente un contenu possédant  dans sa formule une fonction</b>
 * <p> La fonction demande la création d'un bloc</p>
 * @author bbseb
 *
 */
public abstract class Fonction implements Contenu{
	protected Bloc bloc;
	protected String formule;
	
	/**
	 * Ce constructeur instancie un bloc au contenu
	 * @param b
	 * @param formule
	 */
	 public Fonction(Bloc b,String formule) {
	    	this.setBloc(b);
	    	this.setFormule(formule);
	    }
		/**
		 * 
		 * @param bloc est le bloc de cellule ou l'on applique la fonction
		 */
		protected void setBloc(Bloc bloc) {
			this.bloc = bloc;
		}
		
		protected Bloc getBloc() {
			return this.bloc;
		}
		
		/**
		 * @return the formule
		 */
		@Override
		public String getFormule() {
			return formule;
		}
		/**
		 * @param formule the formule to set
		 */
		private void setFormule(String formule) {
			this.formule = formule;
		}
		@Override
		public abstract float getResultat() throws ErreurAffichage;
}
