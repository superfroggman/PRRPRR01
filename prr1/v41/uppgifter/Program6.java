package uppgifter;

import java.util.Scanner;

public class Program6 {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("radie?:");
		int r = input.nextInt();
		System.out.println("height?:");
		int h = input.nextInt();
		
		
		
		System.out.println(r*r*Math.PI*h);
	}
}
