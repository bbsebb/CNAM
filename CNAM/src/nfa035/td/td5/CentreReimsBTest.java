package nfa035.td.td5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CentreReimsBTest {
	static CentreReimsB t;

	@BeforeAll
	static void initAll() {
		 t = new CentreReimsB();
		for (int i = 1; i < 1000; i++) {
			int j = i + 999;
			int k = i + 1999;
			t.ajouterEtudiant(i, "auditeur" + i);
			t.ajouterEnseignant("enseignant" + i, "test");
			t.ajouterUEDistance5("NFA0" + i, "test", "enseignant" + i);
			t.ajouterUEPresentiel("NFA0" + j, "test", "enseignant" + i);
			t.ajouterUEDistance4("NFA0" + k, "test", "enseignant" + i);
		}
	}

	@Test
	void testAfficherUEEtudiant() {

		assertTrue(t.ajouterUEEtudiant(15, "NFA015"));
	}

	@Test
	void testAfficherUEEtudiant2() {

		assertFalse(t.ajouterUEEtudiant(0, "NFA016"));
	}

	@Test
	void testAfficherUEEtudiant3() {

		assertFalse(t.ajouterUEEtudiant(15, "NFA0"));
	}

}
