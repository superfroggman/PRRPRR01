package kattis;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Modulo {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Set<Integer> modulo = new HashSet<Integer>();
		
		for(int i=0;i<10;i++) {
			int in = input.nextInt()%42;
			
			modulo.add(in);
		}
		
		input.close();
		
		System.out.println(modulo.size());
	}
}