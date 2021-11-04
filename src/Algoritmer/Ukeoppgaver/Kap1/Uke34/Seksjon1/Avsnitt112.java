package Algoritmer.Ukeoppgaver.Kap1.Uke34.Seksjon1;

public class Avsnitt112 {

    /*	1. Anta at vi har en min-metode, dvs. en metode som finner (og returnerer) posisjonen
    til den minste verdien i en tabell. Hva ville metodekallet min(a) returnere med hvis a
    er tabellen i Figur 1.1.2?*/
    //Den hadde returert 6.
    /*2. Lag en min-metode på samme måte som maks-metoden i
    Programkode 1.1.2, dvs. en metode som finner (og returnerer) posisjonen
    til den minste verdien i en tabell.*/

    public static int min(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m1 = 0; // indeks til foreløpig største verdi (m for minste)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] < a[m1]) m1 = i;  // indeksen oppdateres
        }

        return m1;  // returnerer indeksen/posisjonen til minste verdi

    } // minste

    /*	3. Hvis den største verdien forekommer flere ganger, vil maks-metoden returnere
    posisjonen til den første av dem. Hva må endres for at den skal returnere posisjonen
    til den siste?*/
    //For å få den til å velge den siste og ikke den første må vi sette den (a[i]>=a[m]),
    // da vil den gå gjennom alle.

    //Dette er også en måte fasiten sier man kan starte fra høyre istedenfor venstre, med andre ord bakover

    //En alternativ måte er å gå gjennom tabellen motsatt vei, dvs. starte lengst til høyre og så
    // gå mot venstre. Det kan kodes slik:

    public static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("a er tom");

        int m2 = a.length - 1;  // indeks til største verdi

        for (int i = a.length - 2; i >= 0; i--) // starter nest bakerst
        {
            if (a[i] > a[m2]) m2 = i;  // indeksen oppdateres
        }

        return m2;  // returnerer indeksen/posisjonen til største verdi

    } // maks


}
