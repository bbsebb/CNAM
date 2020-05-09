package nfa035.projet2.exceptions;

public class CelluleVideException extends Exception{
	static private String type = "ErrVi";

	public CelluleVideException() {
		super(type);
	}

	public CelluleVideException(String str) {
		super(type + str);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
