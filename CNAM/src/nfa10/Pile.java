package nfa10;

public class Pile<T> {

	ElementPile<T> tete;

	public Pile() {
		this.tete = null;
	}

	public void empiler(T e) {
		ElementPile<T> avant = this.getTete();
		this.setTete(new ElementPile<T>(e, avant));
	}

	public T depiler() {
		T rtr = this.tete.getElement();
		this.setTete(this.tete.getAvant());
		return rtr;

	}

	public ElementPile<T> getTete() {
		return tete;
	}

	public void setTete(ElementPile<T> tete) {
		this.tete = tete;
	}

}