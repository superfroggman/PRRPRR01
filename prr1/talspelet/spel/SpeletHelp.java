package spel;

import java.util.Random;
import java.util.Scanner;

//This is the normal number game but with the option to press help for the optimal guessing

public class SpeletHelp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to my NumberGame! This game is about guessing a number in a limited amount of guesses");

        //Loop game until user selects exit option
        while (true) {
            System.out.println("Play the Game (0) or exit the Game (1)");

            //Make sure input is a number
            if (input.hasNextInt()) {

                //Select menu option based on user input
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
                input.nextLine();
                System.out.println("Please enter an integer input!");
            }
        }
    }

    /**
     * Run an entire round of the game
     *
     * @param input
     */
    public static void doRound(Scanner input) {
        //Declare
        int lowInterval = 0;
        int highInterval = 100;
        int difficulty = 1;

        //Get the lower interval from user input
        System.out.println("What is the lowest possible number to guess?");
        lowInterval = getInputInt(input, lowInterval);

        //Get the higher interval from user input
        System.out.println("What is the highest possible number to guess?");
        highInterval = getInputInt(input, highInterval);

        //Get the difficulty from user input
        System.out.println("Select difficulty: easy (0) medium (1) hard (2)");
        difficulty = getInputDifficulty(input, difficulty);
        int lives = lives(difficulty);
        System.out.println("You will now start with " + lives + " lives!");

        //Randomize the number to guess
        int correctNumber = randomInInterval(lowInterval, highInterval);

        //Set initial guess limits for help
        lowGuess = lowInterval;
        highGuess = highInterval;

        //Loop guess method until the guess is correct or lives are out
        while (!doGuess(input, correctNumber)) {
            lives--;
            //Lose when lives are out
            if (lives <= 0) {
                loseGame(correctNumber);
                return;
            }
            System.out.println("You have " + lives + " lives left!");
        }

        //Win game if method is not returned by losing
        winGame(lives);
        return;
    }

    /**
     * @param input
     * @param defaultSetting
     * @return
     */
    public static int getInputInt(Scanner input, int defaultSetting) {
        int out = defaultSetting;

        try {
            out = input.nextInt();
        } catch (Exception e) {
            input.nextLine(); //Clear input for next request
            System.out.println("You did not enter a valid number. The number will default to " + defaultSetting);
        }
        return out;
    }

    /**
     * @param input
     * @param defaultSetting
     * @return
     */
    public static int getInputDifficulty(Scanner input, int defaultSetting) {
        int out = defaultSetting;

        try {
            out = input.nextInt();
        } catch (Exception e) {
            input.nextLine(); //Clear input for next request
            System.out.println("You did not enter a valid difficulty. The difficulty will default to medium");
        }
        return out;
    }

    /**
     * Return lives from difficulty
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

    /**
     * Check if a guess is correct
     *
     * @param input
     * @param correctNumber
     * @return
     */
    public static int lowGuess;
    public static int highGuess;
    public static boolean doGuess(Scanner input, int correctNumber) {

        int guess = 0;

        System.out.println("HELP? yes (y) no (n)");

        if (input.next().equals("y")) {
            guess = (highGuess + lowGuess) / 2;
        } else {

            System.out.println("\nGuess a number:");
            //ADD TRY CATCH
            while (!input.hasNextInt()) {
                input.nextLine(); //Clear input for next request
                System.out.println("Please enter an integer input!");
                System.out.println("Guess a number:");
            }

            guess = input.nextInt();
        }

        System.out.println("You guessed: "+guess);

        if (guess == correctNumber) {
            return true;
        } else if (guess < correctNumber) {
            System.out.println("Your guess is too low");
            lowGuess = guess;
        } else if (guess > correctNumber) {
            System.out.println("Your guess is too high");
            highGuess = guess;
        }

        return false;
    }


    /**
     * Get a random number within an interval
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
            //Get a random number out of range and add the lower interval limit to get the correct number.
            number = new Random().nextInt(range) + low;
        } catch (Exception e) {
            System.out.println("Interval was not a positive size. Defaulting to interval 100.");
            number = new Random().nextInt(100);
        }

        return number;
    }

    /**
     * @param correctNumber
     */
    public static void loseGame(int correctNumber) {
        System.out.println("\nYOU LOST! The correct number was: " + correctNumber);
    }

    /**
     * @param lives
     */
    public static void winGame(int lives) {
        System.out.println("\nYOU WON with " + lives + " lives left!\n");
    }
}
