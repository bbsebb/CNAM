package rcp005;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractSommet<String> s1 = new Sommet<String>("1");
		AbstractSommet<String> s2 = new Sommet<String>("2");
		AbstractSommet<String> s3 = new Sommet<String>("3");
		AbstractSommet<String> s4 = new Sommet<String>("4");
		AbstractSommet<String> s5 = new Sommet<String>("5");
		AbstractSommet<String> s0 = new Sommet<String>("0");
		
		s1.addSuccesseur(s2);
		s1.addSuccesseur(s3);
		s2.addSuccesseur(s4);
		s3.addSuccesseur(s5);
		s4.addSuccesseur(s5);
		
		GrapheTest g = new GrapheTest();
		g.addSommet(s1);
		g.addSommet(s0);
		g.parcoursEnProfondeur(s1);
			
	}

}
