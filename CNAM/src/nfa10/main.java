package nfa10;

public class main {

	public static void main2(String[] args) {
		
		Pile<Integer> p = new Pile<Integer>();
		System.out.println();
		p.empiler(9);
		p.empiler(6);
		p.empiler(4);
		p.empiler(29);
		System.out.println(p.depiler());
		System.out.println(p.depiler());
		System.out.println(p.depiler());
		System.out.println(p.depiler());
	}

}
