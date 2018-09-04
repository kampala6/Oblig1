package com.company;

import java.util.Arrays;
import java.util.Random;

public class  Oblig1 {

    public static void main(String[] args) {
	// write your code here

        int [] b = randPerm(3);

        System.out.println(Arrays.toString(b));

        System.out.println(maks(b));

        System.out.println(Arrays.toString(b));


        System.out.println(ombytteringer(b));

    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Method to produce random array values
     * This is to produce a given number
     * HjelperMethod(This method is from the school konpendium)
     * @return
     */
    public static int[] randPerm(int n){
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0 ; k--) {
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }return a;
    }

    /**
     *
     * @param a
     * @return
     */
    public static int maks(int[] a){

        int n = a.length -1;
        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
            }
        }
        return a[n];//Her vi det legger den størte verdi siden den settes bak
    }

    /**
     * Oppgave 1b
     * Method should return the number of changed places or changes
     * between a[i-i] > a[i]
     * @param a
     * @return
     */
    public static int ombytteringer(int[] a){

        int antallOmbyttinger = 1;

        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
                antallOmbyttinger++;
            }
        }return antallOmbyttinger;
    }
}
