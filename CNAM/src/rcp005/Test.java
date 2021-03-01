package rcp005;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		GrapheOriente<String> g = new GrapheOriente<String>();
		g.addSommet("1");
		g.addSommet("2");
		g.addSommet("3");
		g.addSommet("4");
		g.addSommet("5");
		g.addSommet("6");
		g.addSommet("7");
		g.addSommet("8");
		
		
		g.addArc("1", "4");
		g.addArc("1", "3");
		g.addArc("1", "2");
		g.addArc("2", "5");
		g.addArc("3", "6");
		g.addArc("3", "7");
		g.addArc("3", "1");
		g.addArc("5", "8");
		g.addArc("6", "7");
		g.addArc("7", "4");
		g.addArc("7", "5");
		g.addArc("8", "7");
		
		
		System.out.println(g.toStringLien());
		
		GrapheOriente<String> g2 = (GrapheOriente<String>) g.reverse();
		System.err.println();
		System.err.println();
		System.out.println(g2.toStringLien());

		
		

			
	}

}
