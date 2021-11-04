package Algoritmer.Ukeoppgaver.Kap1.Uke35.Seksjon2;

import Datastrukturer.Tabell;

public class Avsnitt122 {
    /*2. 	Kjør programmet i Programkode 1.2.2 b).*/
    public static void main(String ... args)      // hovedprogram
    {
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

    } // main
    /*3. Lag metoden public static void bytt(char[] c, int i, int j). Den skal bytte om innholdet i posisjon i og j
    i char-tabellen c. Legg metoden i samleklassen Tabell.*/

    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    /*4. Lag metoden public static void skriv(int[] a, int fra, int til). Den skal skrive ut tallene i intervallet
    a[fra:til> til konsollet - alle på én linje og et mellomrom mellom hvert tall. Ikke mellomrom og ikke linjeskift
    etter siste verdi. Lag så metoden public static void skriv(int[] a). Den skal skrive ut hele tabellen - alle på én
    linje, en blank mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi. Legg begge metodene i
    samleklassen Tabell.*/



}
