package v46;

import java.util.Scanner;

public class methodLibrary {

    public static void main(String[] args) {

        pq(8,7, true);

    }


    /**
     *
     * @param p
     * @param q
     * @param print
     * @return
     */
    static double[] pq(int p, int q, boolean print){
        double x1;
        double x2;
        x1 = -(p/2)+Math.sqrt(Math.pow((p/2), 2)-q);
        x2 = -(p/2)-Math.sqrt(Math.pow((p/2), 2)-q);

        if(print){
            System.out.println("x1: "+x1);
            System.out.println("x2: "+x2);
        }

        return new double[] {x1, x2};
    }



    static double prim(){

        Scanner input = new Scanner(System.in);

        int[] k = new int[10];
        int[] e = new int[10];

        int i = 0;
        while (true){
            System.out.println("constant");
            k[i] = input.nextInt();
            System.out.println("exponent");
            e[i] = input.nextInt();

            System.out.println("press 0 to calculate, 1 to input more");
            if(input.nextInt()==0) break;
            i++;
        }



        return 1;
    }
}