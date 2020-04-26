package nfa035.td;

import nfa035.td.td3.MyDate;

public class Td3 {

	public static void main(String[] args) {
		
		MyDate date = new MyDate(01,01,2020);
		MyDate date1 = new MyDate(01,01,2020);
		MyDate dateNext = new MyDate(02,01,2020);
		System.out.println(date.nextDay().affiche());
		System.out.println(date.affiche());
		System.out.println(dateNext.affiche());
		System.out.println(date.nextDay().equals(dateNext));
		System.out.println(date.equals(date1));
	}

}
