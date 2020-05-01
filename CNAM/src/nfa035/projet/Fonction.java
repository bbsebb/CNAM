package nfa035.projet;

/**
 * Cette classe abstraite represente une fonction de calcule dans {@link Feuille une feuille de calcule} sur un bloc de {@link Cellule cellules}
 * @author bbseb
 *
 */
public abstract class Fonction {
	protected Bloc bloc;
	

    
    public Fonction(Bloc b) {
    	this.setBloc(b);
    }
	/**
	 * 
	 * @param bloc est le bloc de cellule ou l'on applique la fonction
	 */
	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}
	
	public Bloc getBloc() {
		return this.bloc;
	}

	public abstract float getResultat();
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloc == null) ? 0 : bloc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Fonction))
			return false;
		Fonction other = (Fonction) obj;
		if (bloc == null) {
			if (other.bloc != null)
				return false;
		} else if (!bloc.equals(other.bloc))
			return false;
		return true;
	}
	
	
}
