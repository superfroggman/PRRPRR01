import java.lang.reflect.Array;
import java.util.ArrayList;

public class Laxa1 {

    public static void main(String[] args) {
        // 100 tal i intervallet [0-9]
        int[] numbers = {1, 1, 1, 2, 6, 7, 8, 4, 3, 7, 8, 9, 3, 1, 3, 7, 8, 5, 3, 4, 8, 9, 6, 4, 2, 4, 7, 9, 7, 4, 3, 2, 3, 6, 7, 8, 7, 7, 5, 7, 9, 6, 1, 4, 0, 8, 6, 5, 6, 8, 9, 0, 7, 5, 4, 3, 2, 4, 5, 9, 8, 5, 9, 8, 8, 4, 5, 6, 7, 8, 9, 0, 9, 0, 9, 7, 5, 2, 1, 2, 3, 4, 5, 4, 4, 5, 3, 4, 5, 0, 8, 7, 0, 7, 9, 7, 0, 6, 5, 4};


        // 100 namn
        String[] names = {"Crystal", "Tam", "Ed", "Beulah", "Daina", "Benjamin", "Kia", "Clelia", "Cassy", "Gita", "Celsa", "Karoline", "Talitha", "Lewis", "Betsy", "Colin", "Glendora", "Carola", "Rosalba", "Jeanie", "Yevette", "Armand", "Neal", "Lilla", "Dorethea", "Delta", "Maye", "Nikita", "Shoshana", "Carola", "Margie", "Haywood", "Venessa", "Natacha", "Gilbert", "Kandi", "Tyisha", "Tammie", "Blossom", "Penney", "Diana", "Audrey", "Willard", "Zoraida", "Drusilla", "Jacquline", "Cyndy", "Janiece", "Tressie", "Kami", "Lashanda", "Leann", "Tom", "Santana", "Junita", "Gisela", "Tom", "Marquerite", "Bryant", "Lauralee", "Yael", "Kelle", "Samantha", "Tom", "Meta", "Lanette", "Wanetta", "Carola", "Jana", "Neal", "Brady", "Rigoberto", "Felicia", "Hellen", "Georgeann", "Carola", "Isaias", "Ellis", "Roseanne", "Lenard", "Ela", "Ophelia", "Alesha", "Mafalda", "Flor", "Kelsi", "Autumn", "Sondra", "Pasty", "Jacquelyne", "Benjamin", "Emmie", "Mickie", "Lang", "Jamee", "Felice", "Daniella", "Carola", "Nathalie", "Genevive"};
        System.out.println("number of unique names: " + uniqueNames(names));
    }


    public static int sevens(int[] numbers){
        int sevens = 0;

        for(int number:numbers){
            if(number==7) sevens++;
        }

        return sevens;
    }

    public static int toms(String[] names){
        int toms = 0;

        for(String tom:names){
            if(tom.equals("Tom")) toms++;
        }

        return toms;
    }

    /**
     *
     * @param numbers
     * @return []
     */
    /*
    public static int[] leastMost(int[] numbers){

        int[] things = new int[10];

        for(int number:numbers){
            things[number-1]++;
        }

        int lowestNumber = things[0];
        int highestNumber = things[0];
        for(int thing:things){
            if(thing<lowestNumber)lowestNumber=thing;
            if(thing<lowestNumber)highestNumber=thing;
        }



        return new int[lowestNumber, highestNumber];
    }

     */

    public static int uniqueNames(String[] inputNames) {

        ArrayList<String> uniqueNames = new ArrayList<>();

        for (String inputName : inputNames) {
            boolean unique = true;
            for (String uniqueName : uniqueNames) {
                if (inputName.equals(uniqueName)) unique = false;
            }

            if (unique) {
                uniqueNames.add(inputName);
            }
        }

        return uniqueNames.size();
    }

    public static void commonName(String[] inputNames) {

        int[] amount = new int[inputNames.length];

        for(int i = 0; i< inputNames.length;i++){

        }



    }
}
