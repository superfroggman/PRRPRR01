package kattis;

import java.util.Scanner;

public class Spavanac {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String timeIn = input.nextLine();

		int hours = Integer.parseInt(timeIn.substring(0,timeIn.indexOf(" ")));
		int minutes = Integer.parseInt(timeIn.substring(timeIn.indexOf(" ")+1));
		
		minutes -= 45;
		if(minutes < 0) {
			minutes += 60;
			hours--;
		}
		
		if(hours<0) {
			hours+= 24;
		}
		
		System.out.println(hours+" "+minutes);
	}
}
