package nfa035.projet;

public interface EditionCellule<T,U> {
	public abstract void setFormule();
	public abstract void setFormule(T operande1,char operateur,U operande2) ;
}
