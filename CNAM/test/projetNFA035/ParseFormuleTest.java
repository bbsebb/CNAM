/**
 * 
 */
package projetNFA035;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nfa035.projet.ParseFormule;

/**
 * @author bbseb
 *
 */
class ParseFormuleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void init() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void close() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#ParseFormule()}.
	 */
	@Test
	void testParseFormule() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#ParseFormule(java.lang.String)}.
	 */
	@Test
	void testParseFormuleString() {
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	@DisplayName("Test de 0123456789,56789")
	void test0estCelluleValeur() {
		ParseFormule p = new ParseFormule(" 0123456789,56789 ");
		assertTrue(p.estCelluleValeur()," 0123456789,56789 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	@DisplayName("Test de 0123456789,01234")
	void test1estCelluleValeur() {
		ParseFormule p = new ParseFormule(" 0123456789,01234 ");
		assertTrue(p.estCelluleValeur()," 0123456789,01234 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test2estCelluleValeur() {
		ParseFormule p = new ParseFormule("123456789");
		assertTrue(p.estCelluleValeur(),"123456789");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test3estCelluleValeur() {
		ParseFormule p = new ParseFormule("12345 6789");
		assertFalse(p.estCelluleValeur(),"12345 6789");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test4estCelluleValeur() {
		ParseFormule p = new ParseFormule("12,345,6789");
		assertFalse(p.estCelluleValeur(),"12,345,6789");
	}	
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test5estCelluleValeur() {
		ParseFormule p = new ParseFormule("12,6a789");
		assertFalse(p.estCelluleValeur(),"12,6a789");
	}	

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 */
	@Test
	void testParseEstCelluleValeur() {
		ParseFormule p = new ParseFormule(" 325,25 ");
		assertEquals(325,25f,p.parseEstCelluleValeur()," 325,25 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test1ParseEstCelluleValeur() {
		ParseFormule p = new ParseFormule(" 0123456789,01234 ");
		assertEquals(123456789.01234f,p.parseEstCelluleValeur()," 0123456789,01234 ");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test2ParseEstCelluleValeur() {
		ParseFormule p = new ParseFormule("123456789");
		assertEquals(123456789f,p.parseEstCelluleValeur()," 123456789 ");
	}


	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void testEstCellule() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonction()}.
	 */
	@Test
	void testEstFonction() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperation()}.
	 */
	@Test
	void testEstOperation() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void testEstFonctionSomme() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void testEstFonctionMoyenne() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperationOperande()}.
	 */
	@Test
	void testEstOperationOperande() {
		
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperationOperateur()}.
	 */
	@Test
	void testEstOperationOperateur() {
		
	}

}
