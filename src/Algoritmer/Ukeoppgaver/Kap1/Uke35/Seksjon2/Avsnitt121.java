package Algoritmer.Ukeoppgaver.Kap1.Uke35.Seksjon2;

import java.util.Arrays;

public class Avsnitt121 {
    /*1. Lag to min-metoder (metoder som finner posisjonen til den minste verdien) tilsvarende de to maks-metodene i
    Programkode 1.2.1 b) og 1.2.1 c). Legg dem i samleklassen Tabell. Se Avsnitt 1.2.2.*/

    public static int min(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minverdi)
            {
                m = i;                // indeks til minste verdi oppdateres
                minverdi = a[m];     // minste verdi oppdateres
            }
        }

        return m;  // posisjonen til minsre verdi i a[fra:til>
    }

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }

    /*5. I Java 1.5 ble det innført en ny type for-løkke - en såkalt for-alle-løkke. Se Programkode 1.2.1 d).
    Den må du lære deg hvis du ikke allerede kan den. Se f.eks. Vedlegg E.*/

    //public static int[] copyOfRange(int[] a, int from, int to) {
       /* Her brukes from og to slik som vi bruker fra og til. Metoden lager en kopi av det halvåpne intervallet
       a[from:to>. I java.util brukes også fromIndex og toIndex om det samme.

                Eksempel: Flg. kode viser hvordan copyOfRange-metoden kan brukes:

        char[] c = {'A','B','C','D','E','F','G','H','I','J'};  // 10 bokstaver

        char[] d = Arrays.copyOfRange(c,4,8);           // en kopi av c[4:8>
        for (char k : d) System.out.print(k + " ");     // kopien d skrives ut

        // Utskrift: E F G H*/

        /*Den nye typen for-løkke kalles en for-alle-løkke og den henter ett og ett element fra en datastruktur
        som kompilatoren oppfatter som Iterable (itererbar). Inntil videre er det kun tabeller som er Iterable for oss.
        Den lages slik:

        for (Datatype x : a) <et eller annet gjøres med x>;
        Bokstaven a står for navnet på en tabell og Datatype er tabellens datatype, f.eks. int, double, Integer, String.
        Programsetningen kan leses slik: for alle x i a gjør . . . . Variabelnavnet x er valgfritt. Du kan velge et
        hvilket som helst navn så sant det ikke kommer i konflikt med andre navn.

        I flg. eksempel skrives innholdet av en String-tabell ut til konsollet:

        String[] s = {"Ola","Per","Kari","Ali","Jasmin"};
        for (String navn : s) System.out.print(navn + " ");*/

        // Utskrift: Ola Per Kari Ali Jasmin
   // }

}
