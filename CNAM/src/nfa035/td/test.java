package nfa035.td;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


import nfa035.td.td6.NumBon;

public class test {

	public static void main(String[] args) {
		Map<NumBon, Integer> commandes = new Hashtable<NumBon, Integer>() ;
		
		NumBon numBon1 = new NumBon("test1");
		NumBon numBon2 = new NumBon("test1");
		NumBon numBon3 = numBon2;

		System.out.println(numBon1.equals(numBon2));
		System.out.println(numBon1.hashCode() == numBon2.hashCode());
		commandes.put(numBon1, 1);
		commandes.put(numBon2, 2);
		commandes.put(numBon3, 3);
		
		Map<String, Integer> test = new HashMap<String, Integer>() ;
		test.put("test1",15);
		test.put("test1",17);
	}

}
