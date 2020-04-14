package old;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OldLanguage {


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
    public static String getRandomWord() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Select language\n(0) Choose own word\n(1) English\n(2) Swedish\n(3) Lolcatz");
        String filename = "";

        switch (input.nextInt()) {
            case 1:
                filename = "English.txt";
                break;
            case 2:
                filename = "Swedish.txt";
                break;
            case 3:
                filename = "Lolcatz.txt";
                break;
            case 0:
                System.out.println("Choose word/phrase");
                input.nextLine();//Clear input
                return input.nextLine();
        }

        ArrayList<String> words = getWordArray(filename);

        return words.get(new Random().nextInt(words.size()));

    }
}
