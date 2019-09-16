package v38;

import java.util.Scanner;

public class lektion1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int age = 10;
		
		do {
			System.out.println("Hur gammal är du?");
			
			if(!input.hasNextInt()) {
				System.out.println("Det var inte ett heltal. Du får inte köra något för att du är så elak.");
				break;
			}
			age = input.nextInt();
			
			if (age >= 18) {
				System.out.println("Du får köra bil.");
			} else if (age >= 15) {
				System.out.println("Du får bara köra moped.");
			} else {
				System.out.println("Du får inte köra bil.");
			}
			System.out.println("Fråga igen? (true/false)");
		} while(input.hasNextBoolean() && input.nextBoolean());
		System.out.println("Antingen så ville du inte fortsätta eller så skrev du inte true eller false.");
	}
}