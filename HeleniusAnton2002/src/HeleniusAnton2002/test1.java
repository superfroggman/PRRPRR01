package HeleniusAnton2002;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println(waa(50));
		System.out.println("Creeper?");

		String input = scanner.nextLine();

		System.out.println(input);

		System.out.println("aww man");

		if (input == "aww man") {
			System.out.print("so we back in the mine owo");
		}
	}

	public static int waa(int a) {
		return 2 * a;
	}

}