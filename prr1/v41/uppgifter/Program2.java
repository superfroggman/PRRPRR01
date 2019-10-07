package uppgifter;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		//kan ha kopierat detta från Stack Overflow
		int sum = String.valueOf(n)
		    .chars()
		    .map(Character::getNumericValue)
		    .sum();
		
		System.out.println(sum);
	}
}
