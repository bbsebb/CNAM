package rcp005;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrapheTest<String> g = new GrapheTest<String>();
		g.addSommet("1");
		g.addSommet("2");
		g.addSommet("3");
		g.addSommet("4");
		g.addSommet("5");
		g.addLien("1", "2");
		g.addLien("2", "3");
		g.addLien("4", "5");
		g.addLien("1", "5");

		System.out.println(g.toString());
		
		

			
	}

}
