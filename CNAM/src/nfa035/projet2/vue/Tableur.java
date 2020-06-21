package nfa035.projet2.vue;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.Feuille;

public class Tableur extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Feuille f ;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu affichage = new JMenu("Affichage");
	private JMenuItem ouvrir = new JMenuItem("Ouvrir");
	private JMenuItem enregistrer = new JMenuItem("Enregistrer");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JRadioButtonMenuItem viewFormule = new JRadioButtonMenuItem("Formule");
	private JRadioButtonMenuItem viewResultat = new JRadioButtonMenuItem("Resultat");
	private JPanel cases = new JPanel();
	

	public Tableur() {
		try {
			f = new Feuille(10,6);
			f.setCellule(0, 0, "5,5");
		} catch (HorsFeuilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("Tableur");
	    this.setSize(600, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(viewFormule);
	    bg.add(viewResultat);
	    viewFormule.setSelected(true);
	    
	    fichier.add(ouvrir);
	    fichier.add(enregistrer);
	    fichier.add(quitter);
	    
	    affichage.add(viewFormule);
	    affichage.add(viewResultat);
	    
	    menuBar.add(fichier);
	    menuBar.add(affichage);
	    
	    cases.setLayout(new GridLayout(10,6));
	    
	    for(int i = 0; i<10; i++) {
	    	for(int j = 0; j < 6; j++) {
	    		JTextField tf = new JTextField();
				try {
					tf.setText(Float.toString( f.getCellule(i, j).getResultat()));
				} catch (HorsFeuilleException | ErreurAffichage e) {
					// TODO Auto-generated catch block
					tf.setText(e.getMessage());
				}
	    		tf.setName(i+""+j);
	    		cases.add(tf);
	    	}
	    }
	    
	    this.setContentPane(cases);
	    this.setJMenuBar(menuBar);
	    
	    
	    this.setVisible(true);
	}

}
