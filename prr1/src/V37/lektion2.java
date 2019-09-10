package V37;

import java.util.Scanner;

public class lektion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter a name:");
		String a = input.nextLine();
		
		System.out.println("alla namn:");
		String[] namn = {"anton", "linus", "markus"};
		for(int i=0; i<namn.length;i++) {
			System.out.println(namn[i]);
		}
		System.out.println(a);
	}

}
