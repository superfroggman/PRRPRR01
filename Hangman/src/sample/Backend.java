package sample;

import java.util.ArrayList;

public class Backend {

    public static String wordToGuess;
    public static int[] charTypes; //a number for each letter in the word showing what type of character it is
    public static ArrayList<Character> guessedLetters;

    public static int wrongGuesses = 0;

    public static boolean win = false;
    public static boolean lose = false;

    /**
     * Resets variables and words to be able to play multiple times
     *
     * @param wordIn
     */
    public static void initialSetup(String wordIn) {
        System.out.println("Setting up backend");

        //reset variables
        wrongGuesses = 0;
        win = false;
        lose = false;

        guessedLetters = new ArrayList<>();//Reset guessed letters

        wordToGuess = wordIn;
        generateCharTypes(wordToGuess);
    }

    /**
     * Entire code for making a guess and reacting accordingly
     *
     * @param guess
     */
    public static void makeGuess(char guess) {

        //Check that guess is a letter
        if (!Character.isLetter(guess)) {
            System.out.println("GUESS NOT A LETTER");
            return;
        }

        //Check if letter is already guessed
        if (guessedLetters.contains(guess)) {
            System.out.println("LETTER ALREADY GUESSED");
            return;
        }

        guessedLetters.add(guess); //Add letter to list of guessed letters

        //Increase number of wrong guesses if the letter is not in the word
        if (!changeCharTypes(wordToGuess, guess)) {
            wrongGuesses++;
        }

        //Lose if man is hung
        if (wrongGuesses >= 10) {
            lose = true;
        }

        //Win if all letters are guessed
        win = winCheck();
    }

    /**
     * Generates arrays from word with values specifying i.e. spaces
     *
     * @param word in
     */
    public static void generateCharTypes(String word) {

        charTypes = new int[word.length()];

        //loop through all letters
        for (int i = 0; i < word.length(); i++) {

            //Set value to 0 when character is a letter and 2 when character is not a letter
            if (Character.isLetter(word.charAt(i))) {
                charTypes[i] = 0;
            } else {
                charTypes[i] = 2;
            }
        }
    }

    /**
     * Changes charTypes array based on letters in word
     *
     * @param word
     * @param letter
     * @return Return true if the guessed letter was in the word
     */
    public static boolean changeCharTypes(String word, char letter) {
        //Get positions of guessed letter
        ArrayList<Integer> guessPositions = getGuessPosition(word, letter);

        //Change charTypes for guessed letter
        for (Integer guessPosition : guessPositions) {
            charTypes[guessPosition] = 1;
        }

        return !guessPositions.isEmpty();
    }

    /**
     * Gets all indexes of a character in a string
     *
     * @param word   in
     * @param letter in
     * @return guessPositions
     */
    public static ArrayList<Integer> getGuessPosition(String word, char letter) {

        ArrayList<Integer> guessPositions = new ArrayList<>();

        letter = Character.toLowerCase(letter); //make the character lowercase
        word = word.toLowerCase(); //make the character lowercase

        int index = word.indexOf(letter); //gets first index

        //adds index to list there and searches for another until the position returns -1(when no additional characters can be found)
        while (index >= 0) {
            guessPositions.add(index);
            index = word.indexOf(letter, index + 1);
        }

        return guessPositions;
    }

    /**
     * Check if all letters are guessed
     *
     * @return
     */
    public static boolean winCheck() {
        boolean finished = true;

        for (int charType : charTypes) {
            if (charType == 0) {
                finished = false;
                break;
            }
        }

        return finished;
    }

    /**
     * Gets string of characters and underscores based on what letters of the word has already been guessed
     *
     * @return
     */
    public static String getUnderscoreString() {
        String out = "";

        //Loop through all letters in word
        for (int i = 0; i < wordToGuess.length(); i++) {
            int type = charTypes[i];

            switch (type) {
                case 0: //Underscore if not guessed
                    out += "_";
                    break;
                case 1:
                case 2: //Actual character if guessed or non-guessable
                    out += wordToGuess.charAt(i);
                    break;
            }
            out += " "; //Add spacing
        }

        return out;
    }

    /**
     * Gets string of characters from array of guessed letters
     *
     * @return
     */
    public static String getGuessedLetters() {
        String out = "";
        for (char letter : guessedLetters) {
            out += letter;
        }

        return out;
    }
}
