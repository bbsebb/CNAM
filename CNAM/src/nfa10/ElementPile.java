package nfa10;

 class ElementPile<T> {
	T element;
	ElementPile<T> avant;

	 ElementPile(T element, ElementPile<T> avant) {
		this.setElement(element);
		this.setAvant(avant);

	}

	 T getElement() {
		return element;
	}

	 void setElement(T element) {
		this.element = element;
	}

	 ElementPile<T> getAvant() {
		return avant;
	}

	 void setAvant(ElementPile<T> avant) {
		this.avant = avant;
	}

}
