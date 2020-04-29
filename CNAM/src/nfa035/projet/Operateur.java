package nfa035.projet;

public enum Operateur {
	ADDITION ("+",'+',"\\+"),
	SOUSTRACTION ("-",'-',"-"),
	MULTIPLICATION ("*",'*',"\\*"),
	DIVISION ("/",'/',"/");
	
	private String name  ;
	private char symbole ;
	private String regex  ;
	
	private Operateur(String name,char symbole,String regex) {
		this.name= name;
		this.symbole = symbole;
		this.regex = regex;
	}
	
	public String toString() {
		return this.name;
	}
	
	public char toChar() {
		return this.symbole;
	}
	
	public String toRegex() {
		return this.regex;
	}
	
}
