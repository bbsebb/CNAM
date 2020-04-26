package nfa035.td.td6;

public class Fiche {
	private String nom, adresse, mail, tel;

	 Fiche() {
		this.setNom("NC");
		this.setAdresse("NC");
		this.setMail("NC");
		this.setTel("NC");
	}

	public Fiche(String nom, String adresse, String mail, String tel) {
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setMail(mail);
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
	 * @return l'adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse le adresse à éditer
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return l'email
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail le mail à éditer
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return le tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel le tel à éditer
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	public void affiche() {
		System.out.print(" | " + this.getNom() + " | " + this.getAdresse() + " | " + this.getMail() + " | "
				+ this.getTel() + " | ");
	}

}
