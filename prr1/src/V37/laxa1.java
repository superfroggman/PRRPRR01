package V37;

import java.util.Scanner;

public class laxa1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Vad är ditt namn?");
		String namn = input.nextLine();
		
		System.out.println("Vad är din ålder?");
		String age = input.nextLine();
		
		System.out.println("Vad är din adress?");
		String adress = input.nextLine();
		
		System.out.println("Vad är ditt postnummer?");
		String postnum = input.nextLine();
		
		System.out.println("Vilken stad bor du i?");
		String stad = input.nextLine();
		
		System.out.println("Vad är ditt telefonnummer?");
		String telenum = input.nextLine();
	}
}
