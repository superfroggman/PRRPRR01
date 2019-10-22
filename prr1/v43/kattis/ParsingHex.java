package kattis;

import java.util.Scanner;

public class ParsingHex {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean zero = false;
		
		if (true) {
			System.out.println("niceline!");
			String line = input.nextLine();
			
			for (int i = 0; i < line.length(); i++) {

				char sym = line.charAt(i);

				if (zero && (sym == 'x' || sym == 'X')) {
					hex(line, i);
				} else if (sym == '0') {
					System.out.println(sym + "!!!!!");
					zero = true;
				} else {
					zero = false;
				}
			}
		}

		//input.close();
	}
	/**
	 * 
	 * @param line
	 * @param pos
	 */
	public static void hex(String line, int pos) {

		int sum = 0;
		
		System.out.println("hexxx");
		
		for (int i = pos; i < line.length(); i++) {
			char sym = line.charAt(i);

			int num;
			if ((sym >= 48 && sym <= 57)) {
				num = sym - 48;
			} else if ((sym >= 65 && sym <= 70)) {
				num = sym - 65 + 10;
			} else if ((sym >= 97 && sym <= 105)) {
				num = sym - 97 + 10;
			}else {
				return;
			}
			
			sum+=num;
		}
		
		System.out.println(sum);
	}
}
