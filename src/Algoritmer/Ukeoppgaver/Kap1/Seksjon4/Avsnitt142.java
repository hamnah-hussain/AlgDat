package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Tabell;

import java.util.Arrays;

public class Avsnitt142 {
    /*1. Legg inn maks-metoden fra Programkode 1.4.2 b) i klassen Tabell (legg også inn, hvis du ikke gjorde det i
    forrige avsnitt, maks-metoden fra 1.4.1 b). Lag et program som utfører Programkode 1.4.2 d). Hvilken metode velges?
     Fjern så maks-metoden for String (dvs. Programkode 1.4.1 b) fra Tabell og utfør Programkode 1.4.2 d) på nytt.*/

    public static void main(String[]args){
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[k]);      // Utskrift:  Thanh

        //innsettingssortering

        String[] t = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(t);
        System.out.println(Arrays.toString(t));  // [Ali, Anne, Eva, Kari, Ole, Per]
    }

    /*2. Legg Programkode 1.4.2 e) i klassen Tabell og sjekk at Programkode 1.4.2 f) virker.*/


}
