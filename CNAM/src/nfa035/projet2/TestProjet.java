package nfa035.projet2;

import javax.swing.SwingUtilities;

import nfa035.projet2.vue.Tableur;

public class TestProjet {

	public static void main(String[] args) {
		System.out.println("test");
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Tableur();
				
			}
			
		}
		);
	}

}

