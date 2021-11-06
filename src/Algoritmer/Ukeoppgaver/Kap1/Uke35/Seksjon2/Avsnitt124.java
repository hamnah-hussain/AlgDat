package Algoritmer.Ukeoppgaver.Kap1.Uke35.Seksjon2;

import Datastrukturer.Tabell;

import java.util.ArrayList;

import static Datastrukturer.Tabell.maks;

public class Avsnitt124 {
    /*1. Legg nestMaks-metoden fra Programkode 1.2.4 a) i samleklassen Tabell. Legg så Programkode 1.2.4 b) inn i
    main-metoden i klassen Program og sjekk at du får rett svar. Obs. Du får andre svar enn det som eksempelutskriften
    i Programkode 1.2.4 b) viser siden metoden randPerm gir nye permutasjoner hver gang den kalles.*/

    public static void main(String [] args){
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

        // Eksempel på en utskrift:

        // 12 16 15 6 10 8 9 2 14 19 5 18 20 13 3 7 11 1 4 17
        // Størst(20) har posisjon 12, nest størst(19) har posisjon 9
    }

    /*2. Lag en versjon av nestmaks-metoden der du bytter om slik at den største kommer forrest. Dermed kan letingen
    etter den nest største starte i posisjon 1. Pass på og bytt tilbake før metoden avslutter slik at tabellen kommer
    tilbake i sin originale tilstand. Obs. Det blir et spesialtilfelle her når den nest største verdien ligger forrest
    i tabellen. Pass på at det tilfellet behandles rett.*/

    public static int[] nestMaks1(int[] a)
    {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int m = Tabell.maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a,0,m);  // bytter om slik at den største kommer forrest

        int k = Tabell.maks(a,1,a.length);

        if (k == m) k = 0; // den nest største lå opprinnelig forrest

        Tabell.bytt(a,0,m); // bytter tilbake

        return new int[] {m,k};

    } // nestMaks

    /*3. Som i Oppgave 2, men bytt om slik at den største havner bakerst. Obs. Det blir et spesialtilfelle her når den
    nest største verdien ligger bakerst i tabellen. Pass på at det tilfellet behandles rett.*/

    public static int[] nestMaks2(int[] a)
    {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int n = a.length;   // tabellens lengde

        int m = Tabell.maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a,n-1,m);  // bytter om slik at den største kommer bakerst

        int k = Tabell.maks(a,0,n-1);

        if (k == m) k = n-1; // den nest største lå opprinnelig forrest

        Tabell.bytt(a,n-1,m); // bytter tilbake

        return new int[] {m,k};

    } // nestMaks

    /*4. Idéen i Oppgave 3 kan utvides til å bli en sorteringsalgoritme. Finn først den største og bytt om slik at
    den kommer bakerst. Finn så den største i det intervallet som ikke har med den siste og bytt om slik at den kommer
    nest bakerst. Finn så den største i intervallet som ikke har med de to siste og bytt om slik at den kommer på tredje
    bakerst. Osv. Lag metoden public static void sortering(int[] a) med dette som idé.*/

    public static void sortering(int[] a){
        for (int i = a.length; i > 1; i--)
        {
            int m = Tabell.maks(a,0,i);
            Tabell.bytt(a,i-1,m);
        }
    }

    /*5. Hvis du har en min-metode (se Oppgave 1 i Avsnitt 1.2.1) kan du gjøre som i Oppgave 4, men motsatt vei. Finn
    den minste og bytt om slik at den kommer først. Finn så den minste i det intervallet som starter i posisjon 1 og
    bytt om slik at den kommer nest først (i posisjon 1), osv.*/

    public static void sort(int[] a){
        for (int i = 0; i < a.length-1; i++)
        {
            int m = Tabell.min(a,i,a.length);
            Tabell.bytt(a,i,m);
        }
    }

}
