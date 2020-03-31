package old;

import java.util.ArrayList;
import java.io.*;

public class hangmanBackend {

    public static void main(String[] args) {

        String inputWord = "WordA nice cool     "; //secret word
        String fixedWord = inputWord.replaceAll("\\s", "").toLowerCase();

        char guessLetter = 'o'; //letter guessed

        String showString = "";

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) != ' ') {
                showString += "_ ";
            } else {
                showString += "  ";
            }
        }

        System.out.println(showString);
        System.out.println(inputWord);
        System.out.println(fixedWord);

        ArrayList<Integer> guessPositions = getGuessPosition(fixedWord, guessLetter); //gets indexes of the letter guessed in word

        System.out.println(guessPositions.isEmpty());//Prints whether or not the character exists in the word
    }


    /**
     * Gets all indexes of a character in a string
     * @param word
     * @param letter
     * @return
     */
    public static ArrayList<Integer> getGuessPosition(String word, char letter) {

        ArrayList<Integer> guessPositions = new ArrayList<>();
        
        letter = Character.toLowerCase(letter);//make the character lowercase

        int index = word.indexOf(letter); //gets first index

        //adds index to list there and searches for another until the position returns -1(when no additional characters can be found)
        while (index >= 0) {
            guessPositions.add(index);
            index = word.indexOf(letter, index + 1);
        }

        return guessPositions;
    }
}