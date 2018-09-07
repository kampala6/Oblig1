package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class  Oblig1 {

    public static void main(String[] args) {
	// write your code here
        int [] b = {3,3,4,5,5,6,7,7,7,8,9,9};
        System.out.println(antallUlikeSortert(b));

        char[] c = "ABCDEFGHIJ".toCharArray();
         rotasjon(c);

        System.out.println(Arrays.toString(c));

        rotasjon1(c);
        System.out.println(Arrays.toString(c));


//        int [] b = randPerm(3);
//
//        System.out.println(Arrays.toString(b));
//
//        System.out.println(maks(b));
//
//        System.out.println(Arrays.toString(b));
//
//        System.out.println(ombytteringer(b));

    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j){
        char temp = a[i];
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
     * HejperMethoder
     * @param a
     * @param v
     * @param h
     */
    public static void snu(char[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h)
            bytt(a, v++, h--);
    }



    /**
     *Oppgave 1
     * @param a
     * @return
     */
    public static int maks(int[] a){
        if(a.length < 1)
            throw new NoSuchElementException("tabellen er tomt!");

        //int størteVerdieBarkerst = a.length -1;
        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i - 1, i); // Hvis a[0] > a[1] bytter de to verdiene plass

            }
        }
        //return a[størteVerdieBarkerst];
        return a[a.length - 1];//Her vi det legger den størte verdi siden den settes bak
    }

    /**
     * Oppgave 1b
     * Method should return the number of changed places or changes
     * between a[i-i] > a[i]
     * @param a
     * @return
     */
    public static int ombyttinger(int[] a){

        int antallOmbyttinger = 0;

        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
                antallOmbyttinger++;
            }
        }return antallOmbyttinger;
    }

    /**
     * Oppgave 2
     * This will return the number of similar or numbers that
     * are alike
     * @param a
     * @return
     */
    public static int antallUlikeSortert(int[] a){
        if(a.length < 2) return a.length;
        int antallUlikeSortert = 1;
        int i = 1;
        for (; i < a.length; i++) {
            if(a[i - 1] > a[i]){
                //throw new IllegalArgumentException("Tabellen er ikke sortert stigende");
                throw  new IllegalStateException("Tabellen er ikke sortert stigende");
            }else {
                if(a[i - 1] < a[i]){
                    antallUlikeSortert++;
                }
            }
        }return antallUlikeSortert;
    }

    /**
     * Oppgave 3
     * @param a
     * @return
     */
    public static int antallUlikeUsortert(int[] a){
        if(a.length < 2) return a.length; // this is important for the value in test oppgave 3b
        int n = a.length;

        int antallULikeUsortert = 1;
        int i = 1;
        for (; i < n; i++) {

            int j = 0;
            for (; j < i; j++) {
                int likeverdie = a[i];
                if(a[j] == likeverdie)break;
            }
            if(j == i) antallULikeUsortert++;
        }
        return antallULikeUsortert;
    }

    public static void rotasjon(char[] a){
        int n = a.length;
        if(n < 2) return;  // tomt eller en verdi i tabellen

       if(a.length > 1) {
           char sistChar = a[n - 1];  //siste element bokstava i tabellen
           for (int i = n - 1; i > 0; i--) { // Starter fra bak siden det er den som skal bytter
                   a[i] = a[i - 1];
               }
               a[0] = sistChar;  // her vi sist bokstav fylt plass med den i posisjon a[0] som er A

       }
    }

    public static void rotasjon1(char[] a){
        int n = a.length;
        if(n < 2) return;  // tomt eller en verdi i tabellen

        if(a.length > 1 ) {
            for (int i = 0; i < n; i++) {
                char temp = a[i + 1];
                if(i != n - 1){
                    a[i + 1] = a[i];
                }
            }
        }
    }

    /**
     * Vi skall prøve å dele tabellen i to
     * A = (n - k), b = (k)
     * Reverse A(r) and B(r)
     * Reverse A(r)B(r)=(A(r)B(r))
     * Reverse
     * @param a
     * @param k
     */
    public static void rotasjon(char[] a, int k){
        int n = a.length;
        if( n <= 1) return;
        k %= n;   // k < a.length

        if(k < 0) k += n;  // Vi bruke k som indeks

        snu(a, 0 ,n - 1);
        snu(a, 0, k - 1);
        snu(a,  k, n -1);

    }

    /**
     * HjelpMethod
     * @param a
     * @param fra
     * @param til
     * @return
     */
    public static  int min(int[] a, int fra, int til){
        if(fra < 0 || til > a.length || fra >= til){
            throw new IllegalArgumentException("Illegalt interval!");
        }
        int m = fra;
        int minverdi = a[fra];

        for (int i = fra; i < til; i++) {
            if(a[i] < minverdi){
                m = i;
                minverdi = a[m];
            }
        }return m;
    }

    public static int min(int[] a){
        return min(a, 0, a.length);
    }

    public static int[] tredjeMin(int[] a){
        int n = a.length;
        if(n < 3){
            throw new java.util.NoSuchElementException("a.lenght(" + n + ") < 2!");
        }

        int m = min(a); // m er posisjonen til tabellens minste verdi
        int nm;

        int tm = 0;

        if(m == 0){  // den minste ligger først
            nm = min(a, 1, n);  // leter i a[1:n>
        }else if(m == n -1){ // den minste liger bakerst
            nm = min(a, 0, n - 1); //leter i a[0: n -1]
        }else{
            int mv = min(a, 0 , m); //leter i a[0:m
            int mh = min(a, m + 1, n); //leter i a[m+1:n>

            nm = a[mh] > a[mv] ? mv : mh; // hvem er minst
        }

        if(nm < m){
            int vnm = min(a, 0, nm);
            int nmM = min(a, nm + 1, m);
            int mth = min(a, m + 1, n);

            if(a[vnm] < a[nmM] && a[vnm] < a[mth]){
                tm = vnm;
            }else if(a[nmM] < a[vnm] && a[nmM] < a[mth]){
                tm = nmM;
            }else if(a[mth] < a[vnm] && a[mth] < a[nmM]){
                tm = mth;
            }
        }
        return new int[]{m , nm, tm};
    }
}
