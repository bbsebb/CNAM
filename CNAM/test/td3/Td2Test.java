package td3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import nfa035.td.Td2;

class Td2Test {

	@Test
	void testMain() {
	}

	@Test
	void testCompareNom() {
		String str1, str2;
		assertThrows(IllegalArgumentException.class, () -> Td2.compareNom("", "test"), "str1 vide");
		assertThrows(IllegalArgumentException.class, () -> Td2.compareNom("test", ""), "str2 vide");
		str1 = "Monsieur Test1";
		str2 = "Madame TesT2";
		assertEquals(Td2.compareNom(str1, str2), Td2.compareNom(str2, str1));
	}

	@Test
	void testNormalise() {
		String str, strCompare;
		assertThrows(IllegalArgumentException.class, () -> Td2.normalise(""), "str vide");
		str = "monsieur Test";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare, Td2.normalise(str) + " : " + strCompare);
		str = "Monsieur TEST";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
		str = "madame TEST";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
		str = "Madame TEST";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
		str = "MadamE test";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
		str = "MadamETEST";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
		str = "MOnsieurTEST";
		strCompare = "test";
		assertEquals(Td2.normalise(str), strCompare);
	}

}
