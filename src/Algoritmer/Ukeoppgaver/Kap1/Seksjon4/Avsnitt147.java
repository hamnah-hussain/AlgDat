package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Tabell;

import java.util.Arrays;

public class Avsnitt147 {
    /*1. La din versjon av grensesnittet Komparator inneholde alt det som er laget i Avsnitt 1.4.7, dvs. dette.
     Sørg for at det ligger under mappen (package) eksempelklasser. Flytt også grensesnittet Funksjon over til deg
     (legg det under eksempelklasser).*/

    /*public static void main(String[]args){

        Integer[] a = {6,2,10,9,5,1,8,4,3,7};
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};

        Tabell.innsettingssortering(a, Komparator.omvendtOrden());
        Tabell.innsettingssortering(s, Komparator.omvendtOrden());

        System.out.println(Arrays.toString(a));  // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(s));  // [Thanh, Sohil, Per, Kari, Jon, Ann]
    }*/

    /*2. Sorter og skriv ut tabellen Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11}; Bruk en naturligOrden-komparator.
     Sorter så tabellen motsatt vei (minst til slutt).*/

    /*Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
  Tabell.innsettingssortering(d, Komparator.naturligOrden());

  System.out.println(Arrays.toString(d));
  // Utskrift: [3.14, 3.9, 5.7, 6.5, 7.1, 7.11, 7.12]

  Tabell.innsettingssortering(d, Komparator.omvendtOrden());

  System.out.println(Arrays.toString(d));
  // Utskrift: [7.12, 7.11, 7.1, 6.5, 5.7, 3.9, 3.14] */

    /*3. Gitt Boolean[] b = {false, true, true, false, false, true, false, true}; Bruk en naturligOrden-komparator til
     å sortere tabellen. Skriv ut resultatet.*/

    /*Boolean[] b = {false, true, true, false, false, true, false, true};
  Tabell.innsettingssortering(b, Komparator.naturligOrden());

  System.out.println(Arrays.toString(b));
    // Utskrift: [false, false, false, false, true, true, true, true]  */

    /*4. Ta utgangspunkt i persontabellen p i Programkode 1.4.6 c). Lag kode som sorterer kun med hensyn på etternavn.
     Bruk en orden-teknikk.*/

/*Person[] p = new Person[5];                       // en persontabell
  p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
  p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
  p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
  p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
  p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

  Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
  System.out.println(Arrays.toString(p));*/

    /*5. I Programkode 1.4.7 i) sorteres strenger mhp. lengde. Lag kode som sorterer motsatt vei, dvs. lange strenger
     kommer først. Lag en komparator eller bruk en orden-teknikk.*/

     /*Tabell.innsettingssortering(s, (x,y) -> y.length() - x.length());
    eller

  Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));*/

}
