package v39.loops;

import java.util.Scanner;

public class loop5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("Input numbers to add. Type \"0\" to exit.");
		
		while(true) {
			if(input.hasNextInt()) {
				int inputInt = input.nextInt();
				if(inputInt==0) {
					break;
				}
				
				sum+=inputInt;
			}
		}
		
		System.out.println("\nSum of inputs:\n" + sum);
	}
}
