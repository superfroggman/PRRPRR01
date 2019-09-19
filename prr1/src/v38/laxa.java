package v38;

import java.util.Scanner;

public class laxa {

	public static void main(String[] args) {

		// Initialize input scanner
		Scanner input = new Scanner(System.in);
		
		int numberOfNumbers = 5;
		
		// Create an array of numbers
		int[] numbers = new int[numberOfNumbers];

		// Ask for user input
		System.out.println("Please input 5 integers:");

		// Set array of numbers to user input
		for (int i = 0; i < numberOfNumbers; i++) {
			System.out.println("Only " + (numberOfNumbers - i) + " ints left.");
			// Print error message and discard input if not an int
			while (!input.hasNextInt()) {
				System.out.println("That was not an integer. Please try again!");
				input.next();
			}
			numbers[i] = input.nextInt();

		}

		// Print the result of the functions
		System.out.println("\nHighest number:");
		System.out.println(highNumber(numbers));
		System.out.println("\nLowest number:");
		System.out.println(lowNumber(numbers));
		System.out.println("\nAverage number:");
		System.out.println(averageNumber(numbers));
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

		// Loop through numbers and set to min number if larger than previous minNumber.
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minNum) {
				minNum = numbers[i];
			}
		}

		// Return smallest number
		return minNum;
	}

	public static float averageNumber(int[] numbers) {

		// Initialize temporary variable for sum
		int sum = 0;

		// Loop through numbers and add to sum
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}

		// Return the sum of the numbers divided by the amount of numbers = the average
		return sum / numbers.length;
	}
}
