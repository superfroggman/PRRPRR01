package uppgifter;

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int sum = 0;
		int numbers = 0;
		
		System.out.println("Skriv in valfritt antal heltal. Avsluta med 0!\n");

		while (true) {
			int in = input.nextInt();

			if (in == 0)
				break;

			sum += in;
			numbers++;

		}
		
		System.out.println("\nSumma: "+sum);
		System.out.println("Medelvärde: "+sum/numbers);
	}
}
