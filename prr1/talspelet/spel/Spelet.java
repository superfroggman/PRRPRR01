package spel;

import java.util.Random;
import java.util.Scanner;

public class Spelet {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        boolean keepPlaying = false;
        while(keepPlaying){
            keepPlaying = doRound(input);
        }

    }

    public static boolean doRound(Scanner input){
        int lowInterval = -100;
        int highInterval = 100;

        System.out.println("What is the lowest number to guess?");

        //ADD TRY CATCH HERE!
        lowInterval = input.nextInt();

        System.out.println("What is the highest number to guess?");

        //ADD TRY CATCH HERE!
        highInterval = input.nextInt();

        int numberToGuess = randomInInterval(lowInterval,highInterval);

        return false;
    }

    public static int randomInInterval(int low, int high){

        //get number of possible numbers
        int range = high - low;

        //Get a random number out of range number of numbers and add the lower interval to get the correct number.
        int number = new Random().nextInt(range) + low;

        return number;
    }
}
