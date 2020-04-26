package nfa035.projet;

public enum Operateur {
	ADDITION ("Plus",'+'),
	SOUSTRACTION ("Moin",'-'),
	MULTIPLICATION ("Fois",'*'),
	DIVISION ("Divise",'/'),
	EGALALITE ("Egal",'=');
	
	private String name  ;
	private char symbole ;
	
	private Operateur(String name,char symbole) {
		this.name= name;
		this.symbole = symbole;
	}
	
	public String toString() {
		return this.name;
	}
	
	public char toChar() {
		return this.symbole;
	}
	
}
