package kattis;

import java.util.Scanner;

public class StuckInTime {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int magicNum = input.nextInt();
		
		for(int i = 1; i<=magicNum;i++) {
			System.out.println(i+" Abracadabra");
		}
	}
}
