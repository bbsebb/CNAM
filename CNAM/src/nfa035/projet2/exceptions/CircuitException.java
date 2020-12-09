package nfa035.projet2.exceptions;

public class CircuitException extends Exception{
	static private String type = "ErrCi";

	public CircuitException() {
		super(type);
	}

	public CircuitException(String str) {
		super(type + str);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
