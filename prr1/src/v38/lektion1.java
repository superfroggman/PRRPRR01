package v38;

import java.util.Scanner;

public class lektion1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Hur gammal är du?");
		int age = input.nextInt();

		if (age >= 18) {
			System.out.println("Du får köra bil.");
		} else if (age >= 15) {
			System.out.println("Du får bara köra moped.");
		} else {
			System.out.println("Du får inte köra bil.");
		}
	}

}
