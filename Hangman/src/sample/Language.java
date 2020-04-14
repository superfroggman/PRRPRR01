package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

        //English words from https://www.ef.com/wwen/english-resources/english-vocabulary/top-1000-words/
        BufferedReader reader = new BufferedReader(new FileReader(folder + filename));

        String line;
        while ((line = reader.readLine()) != null) {
            //line = line.toUpperCase();
            words.add(line);
        }

        reader.close();

        return words;
    }


    /**
     * Gets random word from array of words
     *
     * @return
     * @throws IOException
     */
    public static String getRandomWord(String filename) throws IOException {
        ArrayList<String> words = getWordArray(filename);

        return words.get(new Random().nextInt(words.size()));

    }
}
