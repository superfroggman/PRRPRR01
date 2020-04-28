package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Language {


    /**
     * Gets array of words from file
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private static ArrayList getWordArray(String filename) throws IOException {

        ArrayList words = new ArrayList<>();

        String folder = "src/sample/languages/";

        BufferedReader reader = new BufferedReader(new FileReader(folder + filename)); //Read selected file

        //Add all words from file to an array
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }

        reader.close();

        return words;
    }


    /**
     * Gets random word in uppercase from array of words
     *
     * @return
     * @throws IOException
     */
    public static String getRandomWord(String filename) throws IOException {
        ArrayList<String> words = getWordArray(filename);

        return words.get(new Random().nextInt(words.size())).toUpperCase();

    }
}
