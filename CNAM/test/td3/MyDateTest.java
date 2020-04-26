package td3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nfa035.td.td3.MyDate;

class MyDateTest {

	@Test
	void testMyDate() {
		assertThrows(IllegalArgumentException.class,()-> new MyDate(0,1,2020));
		assertThrows(IllegalArgumentException.class,()-> new MyDate(1,0,2020));
		assertThrows(IllegalArgumentException.class,()-> new MyDate(23,-1,2020));
		assertThrows(IllegalArgumentException.class,()-> new MyDate(-2,3,2020));
	}

	@Test
	public void testAffiche() {
		MyDate date = new MyDate(31, 12, 2021);
		assertTrue(date.affiche().equals("31/12/2021"), "Test affichage date");
	}


	@Test
	void testIsValidDate() {
		assertTrue(MyDate.isValidDate(23,03,2020), "Test date valide simple");
		assertFalse(MyDate.isValidDate(0,1,2020), "Test date invalide jour 0");
		assertFalse(MyDate.isValidDate(1,0,2020), "Test date invalide mois 0");
		assertFalse(MyDate.isValidDate(23,-1,2020), "Test date invalide Mois négatif");
		assertFalse(MyDate.isValidDate(-2,3,2020), "Test date invalide Jour négatif");
		assertTrue(MyDate.isValidDate(2,3,5421), "Test date valide dans longtemps");
		assertTrue(MyDate.isValidDate(2,3,-520), "Test date valide il y a longtemps");
		assertFalse(MyDate.isValidDate(2,13,2020), "Test date invalide mauvais mois");
		assertFalse(MyDate.isValidDate(32,2,2020), "Test date invalide mauvais jours");
		assertFalse(MyDate.isValidDate(29,2,2021), "Test date invalide mauvais jours en février");
		assertTrue(MyDate.isValidDate(29,2,2020), "Test date valide le 29 février des années bixectiles");
	}

	@Test
	void testMaxDayOfMonthIntInt() {
		assertTrue(MyDate.maxDayOfMonth(03,2021) == 31 , "Test date mois 31 valide simple");
		assertTrue(MyDate.maxDayOfMonth(04,2021) == 30 , "Test date mois 31 valide simple");
		assertTrue(MyDate.maxDayOfMonth(2,2020) == 29 , "Test date mois 29 valide simple");
		assertTrue(MyDate.maxDayOfMonth(2,2021) == 28 , "Test date mois 29 valide simple");
	}

	@Test
	void testMaxDayOfMonthInt() {
		assertTrue(MyDate.maxDayOfMonth(03) == 31 , "Test date mois 31 valide simple");
		assertTrue(MyDate.maxDayOfMonth(04) == 30 , "Test date mois 31 valide simple");
		assertTrue(MyDate.maxDayOfMonth(2) == 29 , "Test date mois 29 valide simple");
	}

	@Test
	void testNextDay() {
		MyDate date = new MyDate(01, 01, 2021);
		MyDate dateNext = new MyDate(02, 01, 2021);
		assertTrue(date.nextDay().affiche().equals(dateNext.affiche()), "Test next day");
		assertEquals(date.nextDay().affiche(),dateNext.affiche());
		MyDate date1 = new MyDate(31, 12, 2021);
		MyDate dateNext1 = new MyDate(01,01,2022);
		assertTrue(date1.nextDay().affiche().equals(dateNext1.affiche()), "Test Changement de mois et d'année");
		MyDate date2 = new MyDate(28, 2, 2021);
		MyDate dateNext2 = new MyDate(01,03,2021);
		assertTrue(date2.nextDay().affiche().equals(dateNext2.affiche()), "Test Changement de mois fevrier");
	}

	@Test
	void testGetYear() {
		MyDate date = new MyDate(31, 12, 2021);
		assertTrue(date.getYear() == 2021, "Test renvoie bonne année");
	}

	@Test
	void testGetDay() {
		MyDate date = new MyDate(31, 12, 2021);
		assertTrue(date.getDay() == 31, "Test renvoie bon jour");
	}

	@Test
	void testGetMonth() {
		MyDate date = new MyDate(31, 12, 2021);
		assertTrue(date.getMonth() == 12, "Test renvoie bon mois");
	}

}
