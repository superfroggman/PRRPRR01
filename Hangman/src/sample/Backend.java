package sample;

import old.OldLanguage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {

    private static int[] charTypes;
    private static ArrayList<Character> guessedLetters;


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        //Main loop to be able to play multiple times
        while (true) {

            int wrongGuesses = 0;
            guessedLetters = new ArrayList<>();//Reset guessed letters every round

            System.out.println("(0) Play\n(1) Exit");
            if (input.nextInt() == 1) {
                System.out.println("Bye!");
                return;
            }

            String wordInput = OldLanguage.getRandomWord(); //Set word to guess to a random word
            input.nextLine();//Clear input

            generateCharTypes(wordInput);


            while (true) {
                System.out.print("\nLetters you already guessed: ");
                guessedLetters.forEach(letter -> System.out.print(letter + " ")); //Print all letters guessed
                System.out.println();

                System.out.println("He be hung this much: " + wrongGuesses);

                System.out.println(getUnderscoreString(wordInput));
                System.out.println("what you guess?");
                char letterGuessed = input.nextLine().toCharArray()[0];//get first character of input

                //Check if letter is already guessed
                if (guessedLetters.contains(letterGuessed)) {
                    System.out.println("You already guessed that letter!");
                    continue;
                }

                guessedLetters.add(letterGuessed); //Add letter to list of guessed letters

                //Increase number of wrong guesses if the letter is not in the word
                if (!changeCharTypes(wordInput, letterGuessed)){
                    wrongGuesses++;
                }


                if(wrongGuesses >= 10){
                    System.out.println("YOU LOSE!");
                    System.out.println("The word was: " + wordInput);
                    break;
                }

                //Win if all letters are guessed
                if (winCheck()) {
                    System.out.println("YOU WON!");
                    System.out.println("The word was: " + wordInput);
                    break;
                }
            }
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


    public static String getUnderscoreString(String word) {
        String out = "";

        //Replaces letters with underscores and spaces with more spaces
        for (int i = 0; i < word.length(); i++) {
            int type = charTypes[i];

            switch (type) {
                case 0:
                    out += "_";
                    break;
                case 1:
                    out += word.charAt(i);
                    break;
                case 2:
                    out += " ";
                    break;
            }
            out += " ";
        }

        return out;
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


}
