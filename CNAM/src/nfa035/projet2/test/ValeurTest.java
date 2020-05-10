/**
 * 
 */
package nfa035.projet2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nfa035.projet2.cellule.Valeur;

/**
 * @author bbsebb
 *
 */
class ValeurTest {
	Valeur v1 ;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 v1 = new Valeur(2.2f,"2,2");
	}

	/**
	 * Test method for {@link nfa035.projet2.cellule.Valeur#Valeur(float, java.lang.String)}.
	 */
	@ParameterizedTest
	@CsvSource(value = {"1,0:1.0","-5:-5"	}, delimiter = ':')
	void testValeur(String str,float value) {
		Valeur v = new Valeur(value,str);
		assertEquals(v.getFormule(),str);
		assertEquals(v.getResultat(),value);
	}

	/**
	 * Test method for {@link nfa035.projet2.cellule.Valeur#getResultat()}.
	 */
	@Test
	void testGetResultat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link nfa035.projet2.cellule.Valeur#getFormule()}.
	 */
	@Test
	void testGetFormule() {
		fail("Not yet implemented");
	}

}
