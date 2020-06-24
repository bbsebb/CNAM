package nfa035.projet2;

import java.io.File;

import javax.swing.SwingUtilities;

import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.Feuille;
import nfa035.projet2.vue.Tableur;

public class TestProjet {

	public static void main(String[] args) {

		
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Tableur();

			}

		});
	}

}
