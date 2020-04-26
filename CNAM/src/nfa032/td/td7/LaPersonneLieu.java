package nfa032.td.td7;

public class LaPersonneLieu extends LaPersonne{

	String lieu;
	public LaPersonneLieu(String name, LaDate naiss,String lieu) {
		super(name, naiss);
		
		this.lieu=lieu;
	}
	
	public void ecrire() {
		super.ecrire();
		System.out.println("ра"+this.lieu);		
	}

}
