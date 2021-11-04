package Algoritmer.Ukeoppgaver.Kap1.Uke34.Seksjon1;

public class Avsnitt114 {
    /*1. Hvor mange grunnleggende operasjoner utfører Programkode 1.1.4 hvis tabellen a
    inneholder i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6  ii) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.*/

    public static int maks(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi //1
        int maksverdi = a[0];    // største verdi //2

        for (int i = 1/*1*/; i < a.length/*n*/; i++/*n-1*/) if (a[i] > maksverdi)//2(n-1)
        {
            maksverdi = a[i];     // største verdi oppdateres //2x
            m = i;                // indeks til største verdi oppdateres //x
        }
        return m;   // returnerer indeks/posisjonen til største verdi //1

    } // maks

    //4n+2+3x
    /*
    * x = 0 --> den gikk ikke gjennom fordi 10 er først
    * n = 10 fordi det er 10 tall i tabellen
    * 1. 42
    * 2. 69
    * */
}
