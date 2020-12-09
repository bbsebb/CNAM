package nfa035.projet2.exceptions;

public class FormuleErroneeException extends Exception{
	static private String type = "ErrSy";

	public FormuleErroneeException() {
		super(type);
	}

	public FormuleErroneeException(String str) {
		super(type + str);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
