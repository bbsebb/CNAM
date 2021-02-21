package rcp005;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public abstract class AbstractGraphe<T> {
	LinkedHashSet<AbstractSommet<T>> sommets;
	LinkedHashMap<AbstractSommet<T>,AbstractSommet<T>> liens;

	
	public AbstractGraphe() {
		super();
		this.sommets = null;
		this.liens = null;
	}

	public AbstractGraphe(LinkedHashSet<AbstractSommet<T>> sommets, LinkedHashMap<AbstractSommet<T>, AbstractSommet<T>> liens) {
		super();
		this.sommets = sommets;
		this.liens = liens;
	}
	protected LinkedHashSet<AbstractSommet<T>> getSommets() {
		return sommets;
	}
	protected void setSommets(LinkedHashSet<AbstractSommet<T>> sommets) {
		this.sommets = sommets;
	}
	protected LinkedHashMap<AbstractSommet<T>, AbstractSommet<T>> getLiens() {
		return liens;
	}
	protected void setLiens(LinkedHashMap<AbstractSommet<T>, AbstractSommet<T>> liens) {
		this.liens = liens;
	}
	
	protected abstract void parcoursEnProfondeur();
	
	protected abstract void parcoursEnLargeur();
	
	protected abstract ArrayList<AbstractGraphe<T>> composanteConnexe();
	
	protected abstract ArrayList<AbstractGraphe<T>> composanteFortementConnexe();
	
	
}
