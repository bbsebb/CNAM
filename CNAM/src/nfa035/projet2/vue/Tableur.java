package nfa035.projet2.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.Feuille;

public class Tableur extends JFrame implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lignes = 10;
	private int colonnes = 6;
	private Feuille f;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu affichage = new JMenu("Affichage");
	private JMenuItem ouvrir = new JMenuItem("Ouvrir");
	private JMenuItem enregistrer = new JMenuItem("Enregistrer");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JRadioButtonMenuItem viewFormule = new JRadioButtonMenuItem("Formule");
	private JRadioButtonMenuItem viewResultat = new JRadioButtonMenuItem("Resultat");
	private JPanel pCases = new JPanel();
	private JOptionPane jErreur = new JOptionPane();
	private JTextField[][] cases = new JTextField[lignes][colonnes];

	public Tableur() {
		try {
			f = new Feuille(10, 6);
		//	f.setCellule(0, 0, "5,5");
		//	f.setCellule(0, 1, "3+2,2");
		//	f.setCellule(0, 2, "0.0+1");
		//	f.setCellule(0, 3, "somme(0.0;0.2)");
			
		} catch (HorsFeuilleException e) {
			e.printStackTrace();
		}
		this.setTitle("Tableur");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ButtonGroup bg = new ButtonGroup();
		viewFormule.addActionListener(this);
		viewResultat.addActionListener(this);
		bg.add(viewFormule);
		bg.add(viewResultat);
		viewResultat.setSelected(true);

		ouvrir.addActionListener(this);
		enregistrer.addActionListener(this);
		quitter.addActionListener(this);

		fichier.add(ouvrir);
		fichier.add(enregistrer);
		fichier.add(quitter);

		affichage.add(viewFormule);
		affichage.add(viewResultat);

		menuBar.add(fichier);
		menuBar.add(affichage);

		pCases.setLayout(new GridLayout(11, 7));

		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				cases[i][j] = new JTextField();
				try {
					cases[i][j].setText(Float.toString(f.getCellule(i, j).getResultat()));
				} catch (HorsFeuilleException | ErreurAffichage e) {
					// TODO Auto-generated catch block
					cases[i][j].setText(e.getMessage());
				}
				cases[i][j].setName(i + "" + j);
				cases[i][j].addFocusListener(this);
				pCases.add(cases[i][j]);
			}
		}

		this.setContentPane(pCases);
		this.setJMenuBar(menuBar);

		this.setVisible(true);
	}

	private void majFieldText() {
		String str;
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				try {
					str = (viewResultat.isSelected()) ? Float.toString(f.getCellule(i, j).getResultat())
							: f.getCellule(i, j).getFormule();
					cases[i][j].setText(str);
				} catch (HorsFeuilleException | ErreurAffichage e) {
					cases[i][j].setText(e.getMessage());
				}
				cases[i][j].setName(i + "" + j);
				pCases.add(cases[i][j]);
			}
		}

	}

	private void setFieldText(int x, int y, String str) {
		cases[x][y].setText(str);
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField focusFieldText = ((JTextField) (e.getSource()));
		int x = Character.getNumericValue(focusFieldText.getName().charAt(0));
		int y = Character.getNumericValue(focusFieldText.getName().charAt(1));
		try {
			focusFieldText.setText(f.getCellule(x, y).getFormule());
		} catch (HorsFeuilleException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField focusFieldText = ((JTextField) (e.getSource()));
		int x = Character.getNumericValue(focusFieldText.getName().charAt(0));
		int y = Character.getNumericValue(focusFieldText.getName().charAt(1));
		try {
			f.setCellule(x, y, focusFieldText.getText());
		} catch (HorsFeuilleException e1) {
			e1.printStackTrace();
		}
		this.majFieldText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == viewFormule)
			majFieldText();
		else if (src == viewResultat)
			majFieldText();
		else if (src == ouvrir) {
			JFileChooser fileChooser = new JFileChooser();
			int reponse = fileChooser.showOpenDialog(this);
			if (reponse == JFileChooser.APPROVE_OPTION) {
				System.out.println(fileChooser.getSelectedFile());
				try {
					f.ouvrir(fileChooser.getSelectedFile());
				} catch (HorsFeuilleException | IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
			this.majFieldText();
		} else if (src == enregistrer) {
			JFileChooser fileChooser = new JFileChooser();
			int reponse = fileChooser.showSaveDialog(this);
			if (reponse == JFileChooser.APPROVE_OPTION) {
				try {
					f.enregistrer(fileChooser.getSelectedFile());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
		}

	}

}
