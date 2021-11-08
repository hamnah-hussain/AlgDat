package Algoritmer.Ukeoppgaver.Kap1.Seksjon2;

import java.util.Arrays;

public class Avsnitt1213 {
    /*1. Sjekk at Programkode 1.2.13 a) virker. Obs: metoden returnerer størst og nest størst verdi og ikke indeksene.
    Legg inn en setning som skriver ut tabellen b etter ut turneringen er gjennomført.
    Dermed kan en se resultatet av turneringen.*/

    public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        System.out.println(Arrays.toString(b));  // utskrift av b

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks


    /*3. Metoden public static void kopier(int[] a, int i, int[] b, int j, int ant)
    skal virke som arraycopy() fra class System. Lag den!*/

    public static void kopier(int[] a, int i, int[] b, int j, int ant){
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
    }

    /*4. Gitt tabeller int[] a og int[] b med a.length <= b.length. Lag kode, vha. arraycopy() eller vha. kopier()
    fra Oppgave 3, slik at 1) a kopieres inn først i b,  2) a kopieres inn bakerst i b og 3) a kopieres inn på midten
    av b (gitt at lengdeforskjellen er et partall).*/

    /* // kopierer a først i b
  System.arraycopy(a, 0, b, 0, a.length);

  // kopierer a bakerst i b
  System.arraycopy(a, 0, b, b.length - a.length,a.length);

  // kopierer a på midten av b
  System.arraycopy(a, 0, b, (b.length - a.length)/2,a.length);*/

}
