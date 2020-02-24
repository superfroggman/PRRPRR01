package spel;

import java.util.Random;
import java.util.Scanner;

//This is the normal number game but with the option to press help for the optimal guessing

public class SpeletHelp {

    static Scanner _input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to my NumberGame! This game is about guessing a number in a limited amount of guesses");

        mainMenu();
    }

    
    public static void mainMenu(){

        //Loop game until user selects exit option
        while (true) {
            System.out.println("Play the Game (0) or exit the Game (1)");

            //Make sure input is a number
            if (_input.hasNextInt()) {

                //Select menu option based on user input
                switch (_input.nextInt()) {
                    case 0:
                        doRound(_input);
                        break;
                    case 1:
                        System.out.println("BYE!");
                        return;
                    default:
                        System.out.println("Please enter an acceptable input!");
                        break;
                }
            } else {
                _input.nextLine();
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
        int lives = lives(difficulty);
        boolean help = false;


        //Loop options menu until canceled
        optionLoop:
        while (true) {

            System.out.println("\nYour current settings are:");
            System.out.println("Lower interval limit: " + lowInterval);
            System.out.println("Higher interval limit: " + highInterval);
            System.out.println("Number of lives: " + lives);
            System.out.println("\nStart game (0)\nChoose lower interval limit (1)\nChoose higher interval limit (2)\nChoose difficulty (3)");


            //Select menu option based on user input
            switch (getInputInt()) {
                case 0:
                    break optionLoop;
                case 1:
                    System.out.println("What is the lowest possible number to guess?");
                    System.out.println("Current setting: " + lowInterval);
                    lowInterval = getInputInt();
                    break;
                case 2:
                    System.out.println("What is the highest possible number to guess?");
                    System.out.println("Current setting: " + highInterval);
                    highInterval = getInputInt();
                    break;
                case 3:
                    System.out.println("Select difficulty: easy (0) medium (1) hard (2)");
                    difficulty = getInputInt();
                    lives = lives(difficulty);
                    break;
                default:
                    System.out.println("Please enter an acceptable input!");
                    break;
            }
        }


        //Randomize the number to guess
        int correctNumber = randomInInterval(lowInterval, highInterval);

        //Enable help option if difficulty is easy
        if (difficulty == 0) {

            help = true;
        }

        //Set initial guess limits for help
        lowGuess = lowInterval;
        highGuess = highInterval;

        //Loop guess method until the guess is correct or lives are out
        while (!doGuess(_input, correctNumber)) {
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
     * @return
     */
    public static int getInputInt() {

        //Discard input until input is an integer
        while (!_input.hasNextInt()) {
            _input.nextLine(); //Clear input for next request
            System.out.println("Please enter an integer input!");
        }

        return _input.nextInt();
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

        System.out.println("You guessed: " + guess);

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
