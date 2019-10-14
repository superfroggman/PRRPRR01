package uppgifter;

import java.util.Scanner;

public class Program8 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Timmar? ");
		int h = input.nextInt();

		System.out.print("Minuter? ");
		int m = input.nextInt();

		System.out.print("Sekunder? ");
		int s = input.nextInt();

		int totS = h * 3600 + m * 60 + s;
		System.out.println("Totalt sekunder: " + totS);
	}
}
