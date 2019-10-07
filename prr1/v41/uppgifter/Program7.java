package uppgifter;

import java.util.Scanner;

public class Program7 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("enter side of length for moneybox:");
		int side = input.nextInt();

		for (int i = 0; i < side; i++) {
			System.out.print("$");
		}
		System.out.println();

		for (int i = 0; i < side - 2; i++) {
			System.out.print("$");
			for (int j = 0; j < side - 2; j++) {
				System.out.print(" ");
			}
			System.out.println("$");
		}
		for (int i = 0; i < side; i++) {
			System.out.print("$");
		}
	}
}
