package kattis;

import java.util.Scanner;

public class ParsingHex {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean zero = false;

		if (true) {
			String line = input.nextLine();

			for (int i = 0; i < line.length(); i++) {

				char sym = line.charAt(i);

				if (zero && (sym == 'x' || sym == 'X')) {
					hexLenght(line, i + 1);
				} else if (sym == '0') {
					zero = true;
				} else {
					zero = false;
				}
			}
		}

		// input.close();
	}

	/**
	 * 
	 * @param line
	 * @param pos
	 */

	static void hexLenght(String line, int pos) {

		int lenght = 0;

		here: for (int i = pos; i < line.length(); i++) {
			char sym = line.charAt(i);

			if ((sym >= 48 && sym <= 57) || (sym >= 65 && sym <= 70) || (sym >= 97 && sym <= 105)) {

				lenght++;
			} else {
				break here;
			}
		}

		hexOut(line, pos, lenght);
		decOut(line, pos, lenght);
	}

	/**
	 * 
	 * @param line
	 * @param pos
	 * @param lenght
	 */
	public static void hexOut(String line, int pos, int lenght) {

		String hexSum = line.substring(pos, lenght + pos);

		System.out.print(hexSum + " ");

	}
	
	/**
	 * 
	 * @param line
	 * @param pos
	 * @param lenght
	 */
	static void decOut(String line, int pos, int lenght) {
		
		long decSum = 0L;
		
		for (int i = pos; i < pos+lenght; i++) {
			char sym = line.charAt(i);
			
			int num = 0;
			if ((sym >= 48 && sym <= 57)) {
				num = sym - 48;
			} else if ((sym >= 65 && sym <= 70)) {
				num = sym - 65 + 10;
			} else if ((sym >= 97 && sym <= 105)) {
				num = sym - 97 + 10;
			}
			
			decSum+=num*Math.pow(16, pos+lenght-i-1);
			
		}

		System.out.println(decSum);
	}
}
