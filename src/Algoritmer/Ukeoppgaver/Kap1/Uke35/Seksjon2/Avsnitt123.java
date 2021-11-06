package Algoritmer.Ukeoppgaver.Kap1.Uke35.Seksjon2;

import Datastrukturer.Tabell;

import java.io.IOException;
import java.util.NoSuchElementException;

import static Datastrukturer.Tabell.fratilKontroll;
import static Datastrukturer.Tabell.skriv;

public class Avsnitt123 {


    /*3. 	Gjør om maks-metoden i Programkode 1.2.1 b), som du nå skal ha lagt inn i class Tabell, slik at
    parameterverditesten blir erstattet med Programkode 1.2.3 b) og c). Lag så et testprogram der maks-metoden inngår
    (bruk main i class Program), men med parameterverdier som du vet vil føre til at unntak kastes. Velg verdier slik
    at du får frem alle de mulige feilmeldingstypene.*/

    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] > maksverdi)
        {
            m = i;               // indeks til største verdi oppdateres
            maksverdi = a[m];    // største verdi oppdateres
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static void main(String[] args) throws IOException
    {
        int[] a = Tabell.randPerm(10);
        int[] c = null;

        Tabell.maks(a,-1,10);
        //Tabell.maks(a,0,11);
        //Tabell.maks(a,10,0);
        //Tabell.maks(a,0,0);
        //Tabell.maks(c,0,0);
    }

    // Feilmeldinger:

    // ArrayIndexOutOfBoundsException: fra(-1) er negativ!
    // ArrayIndexOutOfBoundsException: til(11) > tablengde(10)
    // IllegalArgumentException: fra(10) > til(0) - illegalt intervall!
    // NoSuchElementException: fra(0) = til(0) - tomt tabellintervall!
    // NullPointerException

    /*4. Gå videre fra Oppgave 3. Dvs. lag også kode som tester parameteren a og som gir en fornuftig feilmelding
    hvis a er null.*/

    public static int maks4(int[] a, int fra, int til)
    {
        if (a == null) throw new NullPointerException
                ("parametertabellen a er null!");

        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] > maksverdi)
        {
            m = i;               // indeks til største verdi oppdateres
            maksverdi = a[m];    // største verdi oppdateres
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    /*5. 	I Oppgave 5, 6 og 7 i Avsnitt 1.2.2 skulle det lages metoder som arbeidet i et halvåpent intervall.
    Bruk metoden fratilKontroll() til å sjekke at intervallene er lovlige.*/

    public static void skriv(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    public static void skrivln(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void skriv(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
    }

    public static void skrivln(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
        System.out.println();
    }


}
