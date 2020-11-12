package nfa011;

import java.util.regex.Pattern;

public class Tp5 {

	public static void main(String[] args) {
	
		String rgx = "^(SELECT|UPDATE)[^;]*(;|.)$";
		String match = "UPDATE * FROM compte;";
		Pattern.compile(rgx, Pattern.CASE_INSENSITIVE).matcher(match).matches();
		System.out.println(Pattern.compile(rgx, Pattern.CASE_INSENSITIVE).matcher(match).matches());

	}

}
