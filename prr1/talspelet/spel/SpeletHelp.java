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

    /**
     * Main loop of the game
     */
    public static void mainMenu(){

        //Loop game until user selects exit option
        while (true) {
            System.out.println("(1) Play the Game\n(2) Instructions\n(0) Exit the Game");

            //Make sure input is a number
            if (_input.hasNextInt()) {

                //Select menu option based on user input
                switch (_input.nextInt()) {
                    case 1:
                        doRound(_input);
                        break;
                    case 2:
                        instructions();
                        break;
                    case 0:
                        System.out.println("Thanks for playing!");
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

    static int lives = 10;
    static boolean help = false;
    /**
     * Run an entire round of the game
     *
     * @param input
     */
    public static void doRound(Scanner input) {
        //Declare
        int lowInterval = 0;
        int highInterval = 100;


        //Loop options menu until canceled
        optionLoop:
        while (true) {

            System.out.println("\nYour current settings are:");
            System.out.println("Lower interval limit: " + lowInterval);
            System.out.println("Higher interval limit: " + highInterval);
            System.out.println("Number of lives: " + lives);
            System.out.println("Help enabled: "+help);
            System.out.println("\n(0) Start game\n(1) Choose lower interval limit\n(2) Choose higher interval limit\n(3) Choose difficulty");


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
                    difficultyMenu();
                    break;
                default:
                    System.out.println("Please enter an acceptable input!");
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

    /**
     * @return
     */
    public static int getInputInt() {

        //Discard input until input is an integer
        while (!_input.hasNextInt()) {
            _input.nextLine(); //Clear input for next request
            System.out.println("Please enter a boolean input!");
        }

        return _input.nextInt();
    }

    /**
     *
     * @return
     */
    public static boolean getInputBool() {

        //Discard input until input is an integer
        while (!_input.hasNextBoolean()) {
            _input.nextLine(); //Clear input for next request
            System.out.println("Please enter an integer input!");
        }

        return _input.nextBoolean();
    }


    public static void difficultyMenu(){

        System.out.println("\nYour current settings are:");
        System.out.println("Number of lives: " + lives);
        System.out.println("Help enabled: "+help);
        System.out.println("\n(1) Choose number of lives\n(2) Enable help");
        switch (getInputInt()){
            case 1:
                System.out.println("Choose number of lives");
                lives = getInputInt();
                break;
            case 2:
                System.out.println("Enable help\n(1) Enable\n(2) Disable");
                int input = getInputInt();
                switch (input){
                    case 1:
                        help = true;
                    case 2:
                        help = false;
                    default:
                        System.out.println("You did not enter a correct input. Help not changed");
                }
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

        if(help){
            System.out.println("Since help is enabled you can let the computer guess the answer\n(1) Use help\n(2) Skip help");
            switch (getInputInt()){
                case 1:
                    System.out.println("The computer will now guess for you.");
                    useHelp = true;
                    break;
                case 2:
                    System.out.println("You will now have to guess for yourself.");
                    break;
                default:
                    System.out.println("The computer will not help you because you entered an invalid input.");

            }
        }


        if (useHelp) {
            guess = (highGuess + lowGuess) / 2;
            System.out.println("The computer guessed: "+guess);
        } else {

            System.out.println("\nGuess a number:");
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


    public static void instructions(){
        System.out.println("Fina instruktioner\nbla bla bla\n");
    }
}
