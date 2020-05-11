package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class TexturePack {

    public static String selectedPack;

    /**
     * Gets available packs from packs folder
     *
     * @return
     */
    public static ArrayList getPacks() {
        File[] packs = new File("src/sample/packs/").listFiles(); //Get all packs from packs folder

        ArrayList<File> out = new ArrayList<>();
        Collections.addAll(out, packs);
        return out;
    }

    /**
     * Sets pack to selection and set CSS accordingly
     *
     * @param pack
     * @param main
     */
    public static void selectPack(String pack, GridPane main) {
        System.out.println("new pack selected: " + pack);

        selectedPack = pack;

        //Set stylesheet to selected pack's stylesheet
        main.getStylesheets().clear();
        main.getStylesheets().add("sample/packs/" + pack + "/style.css");
    }

    /**
     * Gets image from pack based on number of wrong guesses
     *
     * @param n
     * @return
     * @throws FileNotFoundException
     */
    public static Image getImageByNumber(int n) throws FileNotFoundException {
        return new Image(new FileInputStream(("src/sample/packs/" + selectedPack + "/images/" + n + ".png")));
    }

    /**
     * Gets image from pack based on name of image
     *
     * @param name
     * @return
     * @throws FileNotFoundException
     */
    public static Image getImageByName(String name) throws FileNotFoundException {
        return new Image(new FileInputStream(("src/sample/packs/" + selectedPack + "/images/" + name + ".png")));
    }
}
