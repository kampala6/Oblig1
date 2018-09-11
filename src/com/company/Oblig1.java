package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class  Oblig1 {


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

        int i = 1;
        while (i < a.length) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
                antallOmbyttinger++;
            }
            i++;
        }
        return antallOmbyttinger;
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

    /**
     * Oppgave 4
     * @param a
     */
    public static void delsortering(int[] a){
        int v = 0, h = a.length - 1;
        if (!(v >= a.length || (a[v] & 1) == 0)) {
            do v++;
            while (v < a.length && (a[v] & 1) != 0);
        }
        while (h >= 0 && (a[h] & 1) == 0) h--;

        while (true){
            if(v < h){
                bytt(a, v++, h--);
            }else {
                break;
            }
            while (true) {
                if ((a[v] & 1) == 0) break; //bitwise operation if number ends in 0 even number
                v++;
            }
            while (true) {
                if ((a[h] & 1) != 0) break; // if its 1 then its and odd number
                h--;
            }
        }
        Arrays.sort(a, 0, v);
        Arrays.sort(a, v, a.length);
    }
    /**
     * Oppgave 5
     * @param a
     */
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

//    public static void rotasjon1(char[] a){
//        int n = a.length;
//        if(n < 2) return;  // tomt eller en verdi i tabellen
//
//        if(a.length > 1 ) {
//            for (int i = 0; i < n; i++) {
//                char temp = a[i + 1];
//                if(i != n - 1){
//                    a[i + 1] = a[i];
//                }
//            }
//        }
//    }

    /**
     * Oppgave 6
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

        if (k >= 0) {
        } else {
            k += n;  // Vi bruke k som indeks
        }

        snu(a, 0 ,n - 1);
        snu(a, 0, k - 1);
        snu(a,  k, n -1);

    }//end of rotasjon

    /**
     * Oppgvae 7
     * @param s
     * @param t
     * @return
     */
    public static String flett(String s, String t){
       StringBuilder txt = new StringBuilder(s.length() + t.length());// bygger textten og beholder lengden uten å forrander det

       int i = 0;
       while (i != (s.length() + t.length())){
           if(i < s.length()){
               txt.append(s.charAt(i));
           }
           if(i < t.length()){
               txt.append(t.charAt(i));
           }i++;
       }return txt.toString();

    }//end fleet2


    /**
     * Oppgave 7b
     * @param s
     * @return
     */
    public static String flett(String... s){
        int textlengde = 0;
        for(String item : s){
            textlengde += item.length();
        }

        StringBuilder txt = new StringBuilder(textlengde);
        int i = 0;
        while (txt.length() != textlengde){
            for(String item : s){
                if(item.length() > i){
                    txt.append(item.charAt(i));
                }
            }i++;
        }return txt.toString();
    }//end flett

    /**
     *
     * @param a
     * @return
     */
    public static int[] indekssortering(int[] a){
        int [] indx = new int[a.length]; // index tabell but with the lenght of a

        for (int i = a.length - 1; i >= 0; i--) {
            indx[i] = i;
        }

        int tempindex, j;

        int i = 1;
        while (i < a.length) {
            tempindex = indx[i]; j = i - 1;
            for (; j >= 0 && a[tempindex] < a[indx[j]]; j--) {
                indx[j + 1] = indx[j];
            }
            indx[j + 1] = tempindex;
            i++;
        }

        return indx;
    }//end indekssortering

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
    }//end min

    /**
     * HjelpMethod
     * @param a
     * @return
     */
    public static int min(int[] a){
        return min(a, 0, a.length);
    }//end min


    /**
     * Oppgave 9
     * Kodert av
     * @param a
     * @return
     */
    public static int[] tredjeMin(int[] a){
        if(a.length < 3) throw new NoSuchElementException("Verdi ellet innholdt er mindre en !3");

        int[] indx = indekssortering(Arrays.copyOf(a,3));  //Sorterting av index på riktige plass

        int minv = indx[0];
        int nestMin = indx[1];
        int tredjeMin = indx[2];

        int minVerdi = a[minv];
        int nestMinVerdi = a[nestMin];
        int tredjeMinverdi = a[tredjeMin];

        for (int i = 3; i < a.length; i++) {
            int hjempVerdiMin = a[i];
            if (hjempVerdiMin < tredjeMinverdi){
                if(hjempVerdiMin < nestMinVerdi){
                    if(hjempVerdiMin < minVerdi){
                        tredjeMin = nestMin;
                        tredjeMinverdi = nestMinVerdi;

                        nestMin = minv;
                        nestMinVerdi = minVerdi;    //opptatering

                        minv = i;
                        minVerdi = hjempVerdiMin;
                    }else {
                        tredjeMin = nestMin;
                        tredjeMinverdi = nestMinVerdi;

                        nestMin = i;
                        nestMinVerdi = hjempVerdiMin;
                    }
                }else{
                    tredjeMin = i;
                    tredjeMinverdi = hjempVerdiMin;
                }
            }
        }return new int[] {minv, nestMin, tredjeMin};
    }//end of tredjeMin

//    public static int[] tredjeMin(int[] a){
//        int n = a.length;
//
//        if(n < 3){
//            throw new NoSuchElementException("a.lenght(" + n + ") < 2!");
//        }
//    }

    /**
     * Oppgave 10 by s929577
     * @param a
     * @param b
     * @return
     */
    public static boolean inneholdt(String a, String b){
        int[] antallA = new int[29];
        int[] antallB = new int[29];

        int i = 0;
        while (i < a.length()) {
            char c = a.charAt(i);
            if( c <= 'Z') antallA[c - 65]++;
            else if(c == 'Ø') antallA[27]++;
            else if(c == 'Æ'){
                antallA[28]++;
            }else {
                antallA[26]++;
            }
            i++;
        }

        int j = 0;
        while (j < b.length()) {
            char bInnholdt = b.charAt(j);
            if(bInnholdt <= 'Z') antallB[bInnholdt - 65]++;
            else if (bInnholdt == 'Ø'){
                antallB[27]++;
            }else if(bInnholdt == 'Æ'){
                antallB[28]++;
            }else {
                antallB[26]++;
            }
            j++;
        }

        for (int xdx = 0; xdx < 29; xdx++) {
            if(antallA[xdx] > antallB[xdx]){
                return false;
            }
        }
        return true;
    }//end innholdt
}//end of oblig1
