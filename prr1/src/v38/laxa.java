package v38;

import java.util.Scanner;

public class laxa {

	public static void main(String[] args) {

		// Initialize input scanner
		Scanner input = new Scanner(System.in);

		// Create an array of numbers
		int[] numbers = new int[5];

		// Set array of numbers to user input
		for (int i = 0; i < 5; i++) {
			numbers[i] = input.nextInt();
		}

		// Print the result of the function highNumber
		System.out.println(highNumber(numbers));
		System.out.println(lowNumber(numbers));
	}

	public static int highNumber(int[] numbers) {

		// Set maxNumber to first number as standard
		int maxNum = numbers[0];

		// Loop through numbers and set to max number if larger than previous max
		// number.
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxNum) {
				maxNum = numbers[i];
			}
		}

		// Return largest number
		return maxNum;
	}

	public static int lowNumber(int[] numbers) {

		// Set minNumber to first number as standard
		int minNum = numbers[0];

		// Loop through numbers and set to min number if larger than previous min
		// number.
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minNum) {
				minNum = numbers[i];
			}
		}

		// Return smallest number
		return minNum;
	}
}
