/**
 * 
 */
package projetNFA035;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nfa035.projet.ParseFormule;

/**
 * @author bbseb
 *
 */
class ParseFormuleTest {



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
	void test0estValeur() {
		
		assertTrue(ParseFormule.estValeur(" 0123456789,56789 ")," 0123456789,56789 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	@DisplayName("Test de 0123456789,01234")
	void test1estValeur() {
		assertTrue(ParseFormule.estValeur(" 0123456789,01234 ")," 0123456789,01234 ");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test2estValeur() {
		
		assertTrue(ParseFormule.estValeur("123456789"),"123456789");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test3estValeur() {
		
		assertFalse(ParseFormule.estValeur("12345 6789"),"12345 6789");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test4estValeur() {
		
		assertFalse(ParseFormule.estValeur("12,345,6789"),"12,345,6789");
	}	
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCelluleValeur(java.lang.String)}.
	 */
	@Test
	void test5estValeurr() {
		
		assertFalse(ParseFormule.estValeur("12,6a789"),"12,6a789");
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
		assertTrue(ParseFormule.estCellule("1.1"),"1.1");	
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void test2EstCellule() {
		assertTrue(ParseFormule.estCellule("9.9"),"9.9");	
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void test3EstCellule() {
		assertFalse(ParseFormule.estCellule("0.0"),"0.0");	
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void test4EstCellule() {
		assertFalse(ParseFormule.estCellule("11"),"11");	
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void test5EstCellule() {
		assertFalse(ParseFormule.estCellule("11."),"11.");	
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estCellule()}.
	 */
	@Test
	void test6EstCellule() {
		assertFalse(ParseFormule.estCellule(".11"),".11");	
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
		
		assertTrue(ParseFormule .estFonctionSomme("somme(1.1;2.2)"),"somme(1.1;2.2)");
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test1EstFonctionSomme() {
	
		assertTrue(ParseFormule.estFonctionSomme("Somme(1.1;2.2)"),"Somme(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test2EstFonctionSomme() {
		
		assertFalse(ParseFormule.estFonctionSomme("Soeme(1.1;2.2)"),"Soeme(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test3EstFonctionSomme() {
		
		assertFalse(ParseFormule.estFonctionSomme("Somme(0.0;2.2)"),"Somme(0.0;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test4EstFonctionSomme() {
	
		assertFalse(ParseFormule.estFonctionSomme("Somme(1.1;22.)"),"Somme(1.1;22.)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test5EstFonctionSomme() {
		
		assertFalse(ParseFormule.estFonctionSomme("Somme(1.1;2.2"),"Somme(1.1;2.2");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionSomme()}.
	 */
	@Test
	void test6EstFonctionSomme() {
		
		assertFalse(ParseFormule.estFonctionSomme("Somme(1.1,2.2"),"Somme(1.1,2.2");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void testEstFonctionMoyenne() {
		
		assertTrue(ParseFormule .estFonctionMoyenne("moyenne(1.1;2.2)"),"moyenne(1.1;2.2)");
	}

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test1EstFonctionMoyenne() {
	
		assertTrue(ParseFormule.estFonctionMoyenne("Moyenne(1.1;2.2)"),"Moyenne(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test2EstFonctionMoyenne() {
		
		assertFalse(ParseFormule.estFonctionMoyenne("Soeme(1.1;2.2)"),"Soeme(1.1;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test3EstFonctionMoyenne() {
		
		assertFalse(ParseFormule.estFonctionMoyenne("Moyenne(0.0;2.2)"),"Moyenne(0.0;2.2)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test4EstFonctionMoyenne() {
	
		assertFalse(ParseFormule.estFonctionMoyenne("Moyenne(1.1;22.)"),"Moyenne(1.1;22.)");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test5EstFonctionMoyenne() {
		
		assertFalse(ParseFormule.estFonctionMoyenne("Moyenne(1.1;2.2"),"Moyenne(1.1;2.2");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estFonctionMoyenne()}.
	 */
	@Test
	void test6EstFonctionMoyenne() {
		
		assertFalse(ParseFormule.estFonctionMoyenne("Moyenne(1.1,2.2"),"Moyenne(1.1,2.2");
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
