package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class TexturePack {

    public static String selectedPack;

    public static ArrayList getPacks() {
        File[] packs = new File("src/sample/images/").listFiles();

        ArrayList<File> out = new ArrayList<>();
        Collections.addAll(out, packs);
        return out;
    }

    public static void selectPack(String pack) {
        System.out.println("new pack selected: " + pack);
    }
}
