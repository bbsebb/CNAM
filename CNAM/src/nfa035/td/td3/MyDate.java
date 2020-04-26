package nfa035.td.td3;

/**
 * Cette classe permet de g�rer une date
 * 
 * @author Estelle Gougelet
 *
 */
public class MyDate {

	private int _day;
	private int _month;
	private int _year;

	/**
	 * 
	 * @param day   est le num�ro du jour de la date
	 * @param month est le num�ro du mois de la date
	 * @param year  est le num�ro de l'ann�e de la date
	 * @throws IllegalArgumentException si une date est incorrect
	 */
	public MyDate(int day, int month, int year) {

		if (isValidDate(day, month, year)) {
			setDay(day);
			setMonth(month);
			setYear(year);
		} else
			throw new IllegalArgumentException();
	}

	/**
	 * Affiche le date de l'instance MyDate
	 * 
	 * @return un <i>String</i> en format num�rique J/M/AAAA
	 */
	public String affiche() {
		return _day + "/" + _month + "/" + _year;
	}

	/**
	 * Indique si une date est valide
	 * 
	 * @return <i>true</i> si elle est valide, sinon <i>false</i>
	 */
	public static boolean isValidDate(int _day, int _month, int _year) {
		return checkData(_day, _month, _year);
	}

	private static boolean checkData(int day, int month, int year) {
		return checkDay(day) && checkMonth(month) && checkYear(year) && checkDayLimits(day, month, year);

	}

	/**
	 * Indique le nombre de jour d'un mois et d'une ann�e indiqu�s
	 * 
	 * @param month est le Mois que l'on test
	 * @param year  est l'Ann�e que l'on test
	 * @return un <i>int</i> indiquant le nombre de jour du mois de l'ann�e indiqu�
	 *         en param�tre
	 * @see MyDate#maxDayOfMonth(int)
	 */
	public static int maxDayOfMonth(int month, int year) {
		int result = 31;
		if (month == 2)
			result = (year % 4 == 0) ? 29 : 28;
		if (month == 4 || month == 6 || month == 8 || month == 11)
			result = 30;
		return result;
	}

	/**
	 * Indique le nombre de jour d'un mois indiqu�s de cette ann�e 2020
	 * 
	 * @param month est le Mois que l'on test
	 * @return un <i>int</i> indiquant le nombre de jour du mois de l'ann�e 2020
	 *         indiqu� en param�tre
	 * @see MyDate#maxDayOfMonth(int, int)
	 */
	public static int maxDayOfMonth(int month) {
		return maxDayOfMonth(month, 2020);
	}

	/**
	 * Indique le prochain jour
	 * 
	 * @return retourne une instance myDate avec le prochain jour.
	 */
	public MyDate nextDay() {
		int nextDay, nextMonth, nextYear;
		nextDay = this._day + 1;
		nextMonth = this._month;
		nextYear = this._year;
		if (maxDayOfMonth(this._month, this._year) == this._day) {
			nextDay = 1;
			nextMonth = this._month + 1;
			if (this._month == 12) {
				nextMonth = 1;
				nextYear = this._year + 1;
			}
		}
		MyDate dateNext = new MyDate(nextDay, nextMonth, nextYear);
		return dateNext;
	}

	private static boolean checkDayLimits(int day, int month, int year) {
		if (day > maxDayOfMonth(month, year))
			return false;
		else
			return true;
	}

	private static boolean checkDay(int day) {
		return day > 0 && day < 32;
	}

	private static boolean checkMonth(int month) {
		return month > 0 && month < 13;
	}

	private static boolean checkYear(int year) {
		return true;
	}

	/**
	 * Indique le num�ro de l'ann�e de l'instance
	 * 
	 * @return un <i>int</i> avec le num�ro de l'ann�e
	 * @see #getDay()
	 * @see #getMonth()
	 */
	public int getYear() {
		return _year;
	}

	private void setYear(int _year) {
		this._year = _year;
	}

	/**
	 * Indique le num�ro du jour de l'instance
	 * 
	 * @return un <i>int</i> avec le num�ro du jour
	 * @see #getMonth()
	 * @see #getYear()
	 */
	public int getDay() {
		return _day;
	}

	private void setDay(int _jour) {
		this._day = _jour;
	}

	/**
	 * Indique le num�ro du mois de l'instance
	 * 
	 * @return un <i>int</i> avec le num�ro du mois
	 * @see #getDay()
	 * @see #getYear()
	 */
	public int getMonth() {
		return _month;
	}

	private void setMonth(int _month) {
		this._month = _month;
	}
}
