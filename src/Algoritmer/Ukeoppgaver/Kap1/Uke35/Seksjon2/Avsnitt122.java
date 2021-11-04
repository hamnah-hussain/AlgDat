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
        skrivln(a);

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

    public static void skriv(int[] a, int fra, int til){
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        if (til - fra > 0){
            System.out.print(a[fra]);
        }
        for (int i = fra + 1; i < til; i++){
            System.out.print(" " + a[i]);
        }
    }

    public static void skriv(int[] a){
        skriv(a, 0, a.length);
    }

    /*5. Lag to skrivln-metoder. De skal ha samme signatur og fungere på samme måte som de to skriv-metodene i
    Oppgave 4 , men utskriften skal avsluttes med et linjeskift. Legg begge metodene i samleklassen Tabell.*/

    public static void skrivln(int[] a, int fra, int til){
        skriv(a,fra,til);
        System.out.println();
        /*if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        if (til - fra > 0){
            System.out.println(a[fra]);
        }
        for (int i = fra + 1; i < til; i++){
            System.out.println(a[i]);
        }*/
    }

    public static void skrivln(int[] a){
        skrivln(a, 0, a.length);
    }

}
