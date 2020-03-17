package arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {


    public static void main(String[] args) {
        ArrayList<String> namn = new ArrayList<String>();

        // Lägg in följande namn i arrayListen "namn"
        String[] names = {"Billskog Gabriel" , "Bratland Petter" , "Dahlqvist Ida" , "Erlandsson Malte" , "Favoryt Kalle" , "Gustafsson Emil" , "Hasic Edvin" , "Helenius Anton" , "Jenslöv Max" , "Jonsson Svante" , "Kamo Vivian" , "Khanzade Vakil Kandi Pedram" , "Leisten David" , "Lindqvist Lucas" , "Lindström Linus" , "Markström Stenhammar Zachris" , "Nelin Jacob" , "Niklasson Theodor" , "Nilsson Fredrik" , "Norberg Max" , "Ohlsson Andreas" , "Parsa Filip" , "Richardsson Filippa" , "Roman David" , "Romland Linus" , "Sandström Ludvig" , "Simonsen Johan" , "Simonsen Markus" , "Tammpere Patrik" , "Thilén Philip" , "Utbult David" , "Vins Andreas"};
        Collections.addAll(namn, names);

        // Byt plats på 5:e och 10:e namnet och skriv ut listan
        Collections.swap(namn, 4, 9);

        // Lägg in en dublett av valfritt namn från listan på första platsen och skriv ut listan
        namn.add(0,namn.get(24));

        // Ta bort alla namn som börjar på bokstaven L och skriv ut listan
        for(int i = 0; i < namn.size();){
            if(namn.get(i).charAt(0) == 'L'){
                namn.remove(i);
            }else{
                i++;
            }
        }

        // Flytta ditt namn till första platsen och skriv ut listan
        namn.remove("Helenius Anton");
        namn.add(0, "Helenius Anton");

        // Sortera namnlistan omvänd från Ö till A
        Collections.reverse(namn);

        //Skriv ut alla namn i arraylisten
        for(int i = 0; i < namn.size(); i++){
            System.out.println(namn.get(i));
        }
    }



}