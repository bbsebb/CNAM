package nfa035.projet2.exceptions;

public class HorsFeuilleException extends Exception {
	static private String type = "ErrHF";

	public HorsFeuilleException() {
		super(type);
	}

	public HorsFeuilleException(String str) {
		super(type + str);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
