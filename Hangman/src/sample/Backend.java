package sample;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Backend {

    public static String wordToGuess;
    public static int[] charTypes;
    public static ArrayList<Character> guessedLetters;

    public static int wrongGuesses = 0;


    public static void initialSetup(String wordIn){
        System.out.println();
        int wrongGuesses = 0;
        guessedLetters = new ArrayList<>();//Reset guessed letters every round

        wordToGuess = wordIn;
        generateCharTypes(wordToGuess);
    }

    public static void makeGuess(char guess){

        //Check if letter is already guessed
        if (guessedLetters.contains(guess)) {
            System.out.println("LETTER ALREADY GUESSED");
            return;
        }

        guessedLetters.add(guess); //Add letter to list of guessed letters

        //Increase number of wrong guesses if the letter is not in the word
        if (!changeCharTypes(wordToGuess, guess)){
            wrongGuesses++;
        }

        //Lose if man is hung
        if(wrongGuesses >= 10){
            //Controller.lose();
        }

        //Win if all letters are guessed
        if (winCheck()) {
            //Controller.win();
        }
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

            //Set value to 0 when not a space and 2 when is a space
            if (word.charAt(i) != ' ') {
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

    public static boolean winCheck() {
        //Check if all letters are guessed
        boolean finished = true;
        for (int charType : charTypes) {
            if (charType == 0) {
                finished = false;
                break;
            }
        }

        return finished;
    }

    public static String getUnderscoreString() {
        String out = "";

        //Replaces letters with underscores and spaces with more spaces
        for (int i = 0; i < wordToGuess.length(); i++) {
            int type = charTypes[i];

            switch (type) {
                case 0:
                    out += "_";
                    break;
                case 1:
                    out += wordToGuess.charAt(i);
                    break;
                case 2:
                    out += " ";
                    break;
            }
            out += " ";
        }

        return out;
    }

    public static String getGuessedLetters(){

        String out = "";
        for (char letter : guessedLetters){
            out += letter;
        }


        return out;
    }
}
