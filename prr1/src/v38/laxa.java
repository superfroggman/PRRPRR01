package v38;

import java.util.Scanner;

public class laxa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int[] numbers = new int[5];
		
		for(int i=0;i<5;i++) {
			numbers[i] = input.nextInt();
		}
		
		for(int i=0;i<5;i++) {
			System.out.println(numbers[i]);
		}
	}

}
