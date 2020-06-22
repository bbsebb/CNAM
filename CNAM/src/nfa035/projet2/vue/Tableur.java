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
	private int lignes = 10;
	private int colonnes = 6;
	private Feuille f ;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu affichage = new JMenu("Affichage");
	private JMenuItem ouvrir = new JMenuItem("Ouvrir");
	private JMenuItem enregistrer = new JMenuItem("Enregistrer");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JRadioButtonMenuItem viewFormule = new JRadioButtonMenuItem("Formule");
	private JRadioButtonMenuItem viewResultat = new JRadioButtonMenuItem("Resultat");
	private JPanel pCases = new JPanel();
	private JTextField[][] cases = new JTextField[lignes][colonnes] ;
	

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
	    
	    pCases.setLayout(new GridLayout(10,6));
	    
	    for(int i = 0; i<lignes; i++) {
	    	for(int j = 0; j < colonnes; j++) {
	    		cases[i][j] = new JTextField();
				try {
					cases[i][j].setText(Float.toString( f.getCellule(i, j).getResultat()));
				} catch (HorsFeuilleException | ErreurAffichage e) {
					// TODO Auto-generated catch block
					cases[i][j].setText(e.getMessage());
				}
				cases[i][j].setName(i+""+j);
	    		pCases.add(cases[i][j]);
	    	}
	    }
	    
	    this.setContentPane(pCases);
	    this.setJMenuBar(menuBar);
	    
	    
	    this.setVisible(true);
	}
	
	private void majToutesFieldText() {
		
		
		
	}
	
	private void majFieldText(int x, int y) {
		cases[x][y].setText(str);
	}

}
