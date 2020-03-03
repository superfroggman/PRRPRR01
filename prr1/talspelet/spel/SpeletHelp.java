package spel;

import java.util.Random;
import java.util.Scanner;

//This is the normal number game but with the option to press help for the optimal guessing

public class SpeletHelp {

    static Scanner _input = new Scanner(System.in);

    //initialize starting variables
    static int startingLives = 10;
    static int lives = startingLives;
    static boolean help = false;
    static int lowInterval = 0;
    static int highInterval = 100;


    public static void main(String[] args) {

        System.out.println("Welcome to my NumberGame! This game is about guessing a number in a limited amount of guesses");

        mainMenu();
    }

    /**
     * Main loop of the game
     */
    public static void mainMenu() {

        //Loop everything so you can play several rounds
        while (true) {
            //Loop options menu until canceled
            optionLoop:
            while (true) {

                //reset lives
                lives = startingLives;

                //Print settings and options to user
                System.out.println("\nYour current settings are:");
                System.out.println("Lower interval limit: " + lowInterval);
                System.out.println("Higher interval limit: " + highInterval);
                System.out.println("Number of lives: " + lives);
                System.out.println("Help enabled: " + help);
                System.out.println("\n(0) Start game\n(1) Choose lower interval limit\n(2) Choose higher interval limit\n(3) Choose difficulty\n(4) Instructions\n(5) Exit Game");


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
                        difficultyMenu();
                        break;
                    case 4:
                        instructions();
                        break;
                    case 5:
                        System.out.println("Thanks for playing!");
                        return;
                    default:
                        System.out.println("Please enter an integer input!");
                        break;
                }
            }


            //Randomize the number to guess
            int correctNumber = randomInInterval(lowInterval, highInterval);

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
    }


    /**
     * @return
     */
    public static int getInputInt() {

        //Discard input until input is an integer
        while (!_input.hasNextInt()) {
            _input.nextLine();
            //Clear input for next request
            System.out.println("Please enter a integer input!");
        }

        return _input.nextInt();
    }


    public static void difficultyMenu() {

        System.out.println("\nYour current settings are:");
        System.out.println("Number of lives: " + lives);
        System.out.println("Help enabled: " + help);
        System.out.println("\n(1) Choose number of lives\n(2) Enable help");
        switch (getInputInt()) {
            case 1:
                System.out.println("Choose number of lives");
                startingLives = getInputInt();
                break;
            case 2:
                System.out.println("Enable help\n(1) Enable\n(2) Disable");
                switch (getInputInt()) {
                    case 1:
                        help = true;
                        System.out.println("Help enabled");
                        break;
                    case 2:
                        help = false;
                        System.out.println("Help disabled");
                        break;
                    default:
                        System.out.println("You did not enter a correct input. Help not changed");
                        break;
                }
                break;
        }
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

        boolean useHelp = false;

        if (help) {
            System.out.println("Since help is enabled you can let the computer guess the answer\n(1) Use help\n(2) Skip help");
            switch (getInputInt()) {
                case 1:
                    useHelp = true;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("The computer will not help you because you entered an invalid input.");

            }
        }


        if (useHelp) {
            guess = (highGuess + lowGuess) / 2;
            System.out.println("The computer guessed: " + guess);
        } else {

            System.out.println("\nGuess a number between " +lowInterval+" and "+highInterval);
            //ADD TRY CATCH
            while (!input.hasNextInt()) {
                input.nextLine(); //Clear input for next request
                System.out.println("Please enter an integer input!");
                System.out.println("Guess a number:");
            }

            guess = input.nextInt();
            System.out.println("You guessed: " + guess);
        }

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
            System.out.println("Interval was not a positive size. Defaulting to interval 0-100.");
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


    /**
     * Prints instructions
     */
    public static void instructions() {
        System.out.println("The goal of the game is to guess an interval within an interval.");
        System.out.println("When you make a guess the game will tell you if the answer is lower or higher, and you can make another guess with that information.");
        System.out.println("You can choose the interval limits and the amount of lives to play with.");
        System.out.println("You can also enable help mode, where you can choose for the computer make an educated guess for you.");
    }
}
