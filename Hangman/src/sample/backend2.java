package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class backend2 {

    private static int[] charTypes;
    private static ArrayList<Character> guessedLetters = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String wordInput = "Cool Word";
        generateWordArray(wordInput);

        while (true) {
            System.out.println("what you guess?");
            char letterGuessed = input.nextLine().toCharArray()[0];//get first character of input

            //Check if letter is already guessed
            if (guessedLetters.contains(letterGuessed)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.add(letterGuessed);

            //Get positions of guessed letter
            ArrayList<Integer> guessPositions = getGuessPosition(wordInput, letterGuessed);

            //Change charTypes for guessed letter
            for (Integer guessPosition : guessPositions) {
                charTypes[guessPosition] = 1;
            }

            //Win if all letters are gueesed
            if (winCheck()){
                System.out.println("YOU WON!");
            }


            //Print all charTypes
            for (int charType : charTypes) {
                System.out.print(charType);
            }
        }
    }


    /**
     * Generates arrays from word with values specifying i.e. spaces
     *
     * @param word
     */
    public static void generateWordArray(String word) {

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
     * Gets all indexes of a character in a string
     *
     * @param word
     * @param letter
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


    public static boolean winCheck(){
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
}
