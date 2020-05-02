package nfa035.projet2;

import nfa035.projet2.Bloc;

public abstract class Fonction implements Contenu{
	protected Bloc bloc;
	
	
	 public Fonction(Bloc b) {
	    	this.setBloc(b);
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
		
		public abstract float getResultat();
}
