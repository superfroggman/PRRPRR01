package uppgifter;

import java.util.Scanner;

public class Program10 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Bas? ");

		int b = input.nextInt();

		for (int i = 1; i <= b; i++) {

			for (int j = 1; j <= b - i; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("x ");
			}
			System.out.println();
		}
	}
}
