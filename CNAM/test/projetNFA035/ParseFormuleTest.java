/**
 * 
 */
package projetNFA035;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nfa035.projet.Bloc;
import nfa035.projet.ErreurFormuleException;
import nfa035.projet.Moyenne;
import nfa035.projet.ParseFormule;
import nfa035.projet.Somme;

/**
 * @author bbseb
 *
 */
class ParseFormuleTest {

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"1.1", "9.9" })
	void testEstCelluleTrue(String cellule) {
		assertTrue(ParseFormule.estCellule(cellule),cellule);	
	}
	

	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"0.0", "11","11.",".11" })
	void testEstCelluleFalse(String cellule) {
		assertFalse(ParseFormule.estCellule(cellule),cellule);	
	}


	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@ParameterizedTest
	@ValueSource(strings = { " 0123456789,56789 ", " 0123456789,01234 ", "123456789" })
	void testestValeurTrue(String valeur) {
		
		assertTrue(ParseFormule.estValeur(valeur),valeur);
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@ParameterizedTest
	@ValueSource(strings = { "12345 6789", "12,345,6789", "12,6a789" })
	void testestValeurFalse(String valeur) {
		
		assertFalse(ParseFormule.estValeur(valeur),valeur);
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void testParseEstCelluleValeur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule(" 325,25 ");
		assertEquals(325,25f,p.parseEstCelluleValeur()," 325,25 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test1ParseEstCelluleValeur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule(" 0123456789,01234 ");
		assertEquals(123456789.01234f,p.parseEstCelluleValeur()," 0123456789,01234 ");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test2ParseEstCelluleValeur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("123456789");
		assertEquals(123456789f,p.parseEstCelluleValeur()," 123456789 ");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test3ParseEstCelluleValeur()  {
		ParseFormule p = new ParseFormule("aze");
		assertThrows(ErreurFormuleException.class,() -> p.parseEstCelluleValeur()," 123456789 ");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonction(String)}. et {@link nfa035.projet.ParseFormule#estCelluleFonction()}
	 */
	@ParameterizedTest
	@ValueSource(strings = { "somme(1.1;2.2)", "Somme(1.1;2.2)" ,"moyenne(1.1;2.2)", "Moyenne(1.1;2.2)"})
	void testEstFonctionTrue(String fonction) {
		assertTrue(ParseFormule.estFonction(fonction),fonction);
		ParseFormule p = new ParseFormule(fonction);
		assertTrue(p.estCelluleFonction(),fonction);
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonction(String)}. et {@link nfa035.projet.ParseFormule#estCelluleFonction()}
	 */
	@ParameterizedTest
	@ValueSource(strings = { "Soeme(1.1;2.2)", "Somme(0.0;2.2)", "Somme(1.1;22.)","Somme(1.1;2.2","Somme(1.1,2.2","Soeme(1.1;2.2)", "Moyenne(0.0;2.2)","Moyenne(1.1;22.)","Moyenne(1.1;2.2","Moyenne1.1;2.2)"})
	void testEstFonctionFalse(String fonction) {
		assertFalse(ParseFormule.estFonction(fonction),fonction);
		ParseFormule p = new ParseFormule(fonction);
		assertFalse(p.estCelluleFonction(),fonction);
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void testParseEstCelluleFonction() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("Somme(1.1;2.2)");
		assertEquals(new Somme(new Bloc(1,1,2,2)),p.parseEstCelluleFonction(),"Somme(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test1ParseEstCelluleFonction() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("Moyenne(1.1;2.2)");	
		assertEquals(new Moyenne(new Bloc(1,1,2,2)),p.parseEstCelluleFonction(),"Moyenne(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test2ParseEstCelluleFonction() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("Moyene(1.1;2.2)");	
		assertThrows(ErreurFormuleException.class, () -> p.parseEstCelluleFonction());
	}

	


	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperation()}.
	 */
	@ParameterizedTest
	@ValueSource(strings = { "1.2 * 20,5", "20,20+3.4", " 21/36,2 ","1.2-3.4" })
	void testEstOperation(String operation) {
		assertTrue(ParseFormule.estOperation(operation));
		ParseFormule p = new ParseFormule(operation);	
		assertTrue(p.estCelluleOperation());
	}

	

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperationOperande()}.
	 */
	@Test
	void testEstOperationOperande() {
		
	}



}