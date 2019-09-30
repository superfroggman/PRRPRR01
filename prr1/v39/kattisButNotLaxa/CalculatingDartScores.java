package kattisButNotLaxa;

import java.util.Scanner;

public class CalculatingDartScores {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int score = input.nextInt();
		
		for(int i = 0; i<3;i++) {
			
			for(int j = 60; j>0; i--) {
				
				boolean doBelikedat = false;
				for(int k = 20; k>0; i--) {
					if(j%k==0 && j/k<=3) {
						doBelikedat = true;
					}
				}
				if(doBelikedat) {
					
				}
			}
		}
	}
}
