package sample;

import java.util.ArrayList;

public class NewBackend {

    public static int[] charTypes;
    public static ArrayList<Character> guessedLetters;

    public static int wrongGuesses = 0;


    public static void initialSetup(String wordToGuess){
        int wrongGuesses = 0;
        guessedLetters = new ArrayList<>();//Reset guessed letters every round

        generateCharTypes(wordToGuess);
    }

    public static void makeGuess(char guess){

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

}
