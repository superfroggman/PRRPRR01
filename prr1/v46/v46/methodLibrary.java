package v46;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class methodLibrary {

    public static void main(String[] args) {

        pq(8, 7, true);

        prim();
    }


    /**
     * @param p
     * @param q
     * @param print
     * @return
     */
    static double[] pq(double p, double q, boolean print) {
        double x1;
        double x2;

        double del1 = -(p / 2);
        double del2 = Math.sqrt(Math.pow((p / 2), 2) - q);
        x1 = del1 + del2;
        x2 = del1 - del2;

        if (print) {
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }

        return new double[]{x1, x2};
    }

    /**
     *
     * @return
     */

    static void prim() {

        Scanner input = new Scanner(System.in);

        //int[] k = new int[10];
        ArrayList<Integer> k = new ArrayList<Integer>();
        ArrayList<Integer> e = new ArrayList<Integer>();

        //get all inputs
        int i = 0;
        while(true) {

            System.out.println("constant");
            k.add(input.nextInt());

            System.out.println("exponent");
            e.add(input.nextInt());

            System.out.println("press 0 to calculate, 1 to input more");
            if (input.nextInt() == 0) break;
            i++;
        }


        //print output
        System.out.println("Prim: ");
        for (int j = 0; j < k.size(); j++) {
            //using the derriveringsregler
            k.set(j, k.get(j)*e.get(j));
            e.set(j, e.get(j)-1);


            //print number with exeptions
            if (e.get(j)==0) {
                //do nothing here
            }else if (e.get(j) != 0) {
                System.out.print(k.get(j) + "X^" + e.get(j));
            } else {
                System.out.print(k.get(j));
            }

            //add + between numbers
            if(j<k.size()-1 && k.get(j)!=0){
                System.out.print(" + ");
            }
        }
    }
}