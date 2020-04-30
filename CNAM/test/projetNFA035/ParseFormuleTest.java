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
import nfa035.projet.Cellule;
import nfa035.projet.Contenu;
import nfa035.projet.ErreurFormuleException;
import nfa035.projet.Moyenne;
import nfa035.projet.Operande;
import nfa035.projet.Operateur;
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
		ParseFormule p = new ParseFormule(" 0325,25 ");
		assertEquals(325.25f,p.parseEstCelluleValeur()," 0325,25 ");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test1ParseEstCelluleValeur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule(" 569,01234 ");
		assertEquals(569.01234f,p.parseEstCelluleValeur()," 0123456789,01234 ");
	}
	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseEstCelluleValeur(java.lang.String)}.
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test2ParseEstCelluleValeur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("123456");
		assertEquals(123456f,p.parseEstCelluleValeur()," 123456 ");
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
	@ValueSource(strings = { "1.2 * 20,5", "20,20+3.4", " 21/36,2 ","1.2-3.4"})
	void testEstOperationTrue(String operation) {
		assertTrue(ParseFormule.estOperation(operation));
		ParseFormule p = new ParseFormule(operation);	
		assertTrue(p.estCelluleOperation());
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#estOperation()}.
	 */
	@ParameterizedTest
	@ValueSource(strings = { "1.2 ** 20,5", "20,20+3.4+", " /2136,2 ","1.2 3.4"})
	void testEstOperationFalse(String operation) {
		assertFalse(ParseFormule.estOperation(operation));
		ParseFormule p = new ParseFormule(operation);	
		assertFalse(p.estCelluleOperation());
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test6ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("5,5*2,3");	
		assertEquals((Contenu)new Operande(5.5f),p.parseCelluleOperationGetOperande1(),"5,5*2,3");
		assertEquals((Contenu)new Operande(2.3f), p.parseCelluleOperationGetOperande2(),"5,5*2,3");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test7ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("2.2*2,3");	
		assertEquals((Contenu)new Cellule(2,2),p.parseCelluleOperationGetOperande1(),"2.2*2,3");
		assertEquals((Contenu)new Operande(2.3f), p.parseCelluleOperationGetOperande2(),"2.2*2,3");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test8ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27*2.3");	
		assertEquals((Contenu)new Operande(35.27f),p.parseCelluleOperationGetOperande1(),"35,27*2.3");
		assertEquals((Contenu)new Cellule(2,3), p.parseCelluleOperationGetOperande2(),"35,27*2.3");
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test1ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("5,,5*2,3");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande1());
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande2());
	}	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test2ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("5,5++2,3");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande1());
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande2());
	}	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test3ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("5..5*2,3");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande1());
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande2());
	}	
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande1(java.lang.String)} et {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperande2(java.lang.String)} et .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test4ParseCelluleOperationGetOperande() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("5,5+ADD");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande1());
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperande2());
	}		

	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void testParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27*2.3");	
		assertEquals(Operateur.MULTIPLICATION,p.parseCelluleOperationGetOperateur(),"35,27*2.3");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test1ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27/2.3");	
		assertEquals(Operateur.DIVISION,p.parseCelluleOperationGetOperateur(),"35,27*2.3");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test2ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27-2.3");	
		assertEquals(Operateur.SOUSTRACTION,p.parseCelluleOperationGetOperateur(),"35,27*2.3");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test3ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27+2.3");	
		assertEquals(Operateur.ADDITION,p.parseCelluleOperationGetOperateur(),"35,27*2.3");
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test4ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27+-2.3");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperateur());
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test5ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,27+2.3+");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperateur());
		
	}
	/**
	 * Test method for {@link nfa035.projet.ParseFormule#parseCelluleOperationGetOperateur(java.lang.String)}  .
	 * @throws ErreurFormuleException 
	 */
	@Test
	void test6ParseCelluleOperationGetOperateur() throws ErreurFormuleException {
		ParseFormule p = new ParseFormule("35,-272.3");	
		assertThrows(ErreurFormuleException.class, () -> p.parseCelluleOperationGetOperateur());
		
	}

}
