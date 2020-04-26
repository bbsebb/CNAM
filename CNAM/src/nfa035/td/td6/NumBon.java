package nfa035.td.td6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NumBon implements Comparable<NumBon>{
	String numBon;
	LocalDate date;

	public NumBon(String numBom) {
		this.setNumBon(numBom);
		this.setDate(null);
	}
	public NumBon(String numBom,LocalDate date) {
		this.setNumBon(numBom);
		this.setDate(date);
	}
	
	@Override
	public int compareTo(NumBon c) {
		if (this.equals(c))
			return 0;
		return this.getNumBon().compareTo(c.getNumBon());
	}
	 
	@Override
	public int hashCode() {
		
		return numBon.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		String str = (String)((NumBon)obj).getNumBon();
		return this.numBon.equals(str);
	}

	/**
	 * @return le numBon
	 */
	public String getNumBon() {
		return numBon;
	}
	/**
	 * @param numBon le numBon à éditer
	 */
	public void setNumBon(String numBon) {
		this.numBon = numBon;
	}
	/**
	 * @return le date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date2 le date à éditer
	 */
	public void setDate(LocalDate date2) {
		this.date = date2;
	}
	
	public String toString() {
		return "Commande "+ numBon + ", passé à la date du " + date.format(DateTimeFormatter.ISO_LOCAL_DATE) + "]";
	}

}
