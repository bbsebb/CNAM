/**
 * 
 */
package nfa035.projet2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import nfa035.projet2.cellule.Valeur;

/**
 * @author bbsebb
 *
 */
class ValeurTest {
	static Valeur v1 ;
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
		assertEquals(v.getResultat(),Float.valueOf(value));
	}

	/**
	 * Test method for {@link nfa035.projet2.cellule.Valeur#getResultat()}.
	 */
	@ParameterizedTest
	@ValueSource(floats = {1.1f,1f,-1,-1.1475f})
	void testGetResultat(float value) {
		Valeur v = new Valeur(value,"test");
		assertEquals(v.getResultat(),value);
	}

	/**
	 * Test method for {@link nfa035.projet2.cellule.Valeur#getFormule()}.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"1,5","-1,5","1","1,8577"})
	void testGetFormule(String str) {
		Valeur v = new Valeur(1.5f,str);
		assertEquals(v.getFormule(),str);
	}

}
