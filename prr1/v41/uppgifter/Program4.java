package uppgifter;

import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numbers = 0;
		int sum = 1;

		for (int i = 0; i < 10; i++) {
			if (sum > 100000)
				break;

			sum *= input.nextInt();
			numbers++;
		}

		System.out.println("sum: " + sum);
		System.out.println("number of inputs: " + numbers);
	}
}
