package spel;

import java.util.Random;
import java.util.Scanner;

public class Spelet {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to my NumberGame! This game is about guessing a number in a limited amount of guesses");

        //Loop game until user selects exit option
        while (true) {
            System.out.println("Play the Game (0) or exit the Game (1)");

            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    case 0:
                        doRound(input);
                        break;
                    case 1:
                        System.out.println("BYE!");
                        return;
                    default:
                        System.out.println("Please enter an acceptable input!");
                        break;
                }
            } else {
                input.next();
                System.out.println("Please enter an integer input!");
            }
        }
    }

    /**Run an entire round of the game
     *
     * @param input
     */
    public static void doRound(Scanner input) {
        int lowInterval = 0;
        int highInterval = 100;
        int difficulty = 1;


        System.out.println("What is the lowest number to guess?");
        try {
            lowInterval = input.nextInt();
        } catch (Exception e) {
            input.next(); //Clear input for next request
            System.out.println("You did not enter a valid number. The number will default to " + lowInterval);
        }


        System.out.println("What is the highest number to guess?");
        try {
            highInterval = input.nextInt();
        } catch (Exception e) {
            input.next(); //Clear input for next request
            System.out.println("You did not enter a valid number. The number will default to " + highInterval);
        }


        System.out.println("Select difficulty: easy (0) medium (1) hard (2)");
        try {
            difficulty = input.nextInt();
        } catch (Exception e) {
            input.next(); //Clear input for next request
            System.out.println("You did not enter a valid difficulty. The difficulty will default to " + difficulty);
        }


        int lives = lives(difficulty);

        System.out.println("You will now start with " + lives + " lives!");

        int correctNumber = randomInInterval(lowInterval, highInterval);


        //Loop guess method until the guess is correct or lives are out
        while (!doGuess(input, correctNumber)) {
            lives--;
            if (lives <= 0) {
                loseGame(correctNumber);
                return;
            }
            System.out.println("You have " + lives + " lives left!");
        }


        winGame(correctNumber, lives);
        return;
    }

    /**Return lives from difficulty
     *
     * @param difficulty
     * @return
     */
    public static int lives(int difficulty) {
        int lives = 10;

        switch (difficulty) {
            //Easy
            case 0:
                return 20;
            //Medium
            case 1:
                return 10;
            //Hard
            case 2:
                return 5;
        }

        System.out.println("You did not enter a valid difficulty. The difficulty will default to Medium");

        return lives;
    }

    /**Check if a guess is correct
     *
     * @param input
     * @param correctNumber
     * @return
     */
    public static boolean doGuess(Scanner input, int correctNumber) {

        System.out.println("\nGuess a number:");
        //ADD TRY CATCH
        while (!input.hasNextInt()) {
            input.next(); //Clear input for next request
            System.out.println("Please enter an integer input!");
        }

        int guess = input.nextInt();

        if (guess == correctNumber) {
            return true;
        } else if (guess < correctNumber) {
            System.out.println("Your guess is too low");
        } else if (guess > correctNumber) {
            System.out.println("Your guess is too high");
        }

        return false;
    }


    /**Get a random number within an interval
     *
     * @param low
     * @param high
     * @return
     */
    public static int randomInInterval(int low, int high) {

        //get number of possible numbers
        int range = high - low;

        int number = 0;
        try {
            //Get a random number out of range number of numbers and add the lower interval to get the correct number.
            number = new Random().nextInt(range) + low;
        } catch (Exception e) {
            System.out.println("Interval was not a positive size. Defaulting to interval 100.");
            number = new Random().nextInt(100);
        }

        return number;
    }

    /**
     *
     * @param correctNumber
     */
    public static void loseGame(int correctNumber) {
        System.out.println("\nYOU LOST!\n");
    }

    /**
     *
     * @param correctNumber
     * @param lives
     */
    public static void winGame(int correctNumber, int lives) {
        System.out.println("\nYOU WON with " + lives + " lives left!\n");
    }
}
