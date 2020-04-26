package nfa032.td.td7;

public abstract class Volaille {
	protected int poids,id;
	protected String espece = "poulet";
	protected static int idbis=0;

	public Volaille(int poids) {
		this.setId(Volaille.idbis);
		this.setPoids(poids);
		Volaille.idbis++;
	}

	public int getPoids() {
		return poids;
	}

	protected void setPoids(int poids) {
		this.poids = poids;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	public String getEspece() {
		return espece;
	}
	
	abstract protected int abattre() ;
	abstract protected boolean Aabattre() ;
}