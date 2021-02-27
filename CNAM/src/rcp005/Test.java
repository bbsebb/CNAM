package rcp005;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrapheOriente<String> g = new GrapheOriente<String>();
		g.addSommet("1");
		g.addSommet("2");
		g.addSommet("3");
		g.addSommet("4");
		g.addSommet("5");
		
		
		g.addArc("1", "2");
		g.addArc("2", "3");
		g.addArc("4", "5");
		g.addArc("1", "5");
		g.parcoursEnProfondeur();

		
		System.out.println(g.toStringSommet());

		g.addSommet("6");
		g.addArc("3", "6");
		g.addArc("6", "5");
		System.out.println(g.toStringSommet());
		
		

			
	}

}
