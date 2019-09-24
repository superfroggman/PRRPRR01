package loops;

import java.util.Scanner;

public class loop6 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Type what you want. I don't care. Type \"exit\" to exit.");

		while (true) {

			if (input.nextLine().equals("exit")) {
				break;
			}
		}
		
		System.out.println("ok byeeeeeeeee");
	}
}
