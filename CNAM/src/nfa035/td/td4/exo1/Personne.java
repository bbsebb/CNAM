package nfa035.td.td4.exo1;
/**
 * C'est une classe abstraites des personnes appartenant à une CNAM
 * @author bbseb
 * @see Etudiant
 * @see Enseignant
 */
public abstract class Personne {
	/**
	 * test
	 */
	String nom, prenom, adresse,tel,email;
	
	/**
	 * Constructeur initiant le nom de la personne
	 * @param nom : non de la personne
	 */
	protected Personne(String nom) {
		this.setNom(nom);
		this.setPrenom("NC");
		this.setAdresse("NC");
		this.setEmail("NC");
		this.setTel("NC");
	}	
	/**
	 * Constructeur initiant une personne avec plusieurs parametre
	 * @param nom : nom de la personne
	 * @param prenom : prenom de la personne
	 * @param adresse : adresse de la personne
	 * @param tel : téléphone de la personne
	 * @param email : email de la personne
	 */
	protected Personne(String nom,String prenom,String adresse,String tel,String email) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setTel(tel);
	}

	/**
	 * Modifie une personne 
	 * @param nom : nom de la personne à modifier 
	 * @param prenom : prenom de la personne à modifier
	 * @param adresse : adresse de la personne à modifier
	 * @param tel : téléphone de la personne à modifier
	 * @param email : email de la personne à modifier
	 */
	public void modifier(String nom,String prenom,String adresse,String tel,String email) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setTel(tel);
	}
	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom le nom à éditer
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom le prenom à éditer
	 */
	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return le adresse
	 */
	protected String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse le adresse à éditer
	 */
	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return le tel
	 */
	protected String getTel() {
		return tel;
	}

	/**
	 * @param tel le tel à éditer
	 */
	protected void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return le email
	 */
	protected String getEmail() {
		return email;
	}

	/**
	 * @param email le email à éditer
	 */
	protected void setEmail(String email) {
		this.email = email;
	}
	
	
	abstract void afficher();
	
}
