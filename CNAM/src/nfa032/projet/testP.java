package nfa032.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int n : Image.stringToInt("100 100", 2)) {
			System.out.println(n);
		}
	}

}
