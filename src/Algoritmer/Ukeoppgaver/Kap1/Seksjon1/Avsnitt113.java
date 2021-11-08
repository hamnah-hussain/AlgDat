package Algoritmer.Ukeoppgaver.Kap1.Seksjon1;

public class Avsnitt113 {
    /*5. Lag en metode public static int[] minmaks(int[] a). Den skal ved hjelp av en int-tabell
    med lengde 2 returnere posisjonene til minste og største verdi i tabellen a. Hvis du har
    funnet at m1 er posisjonen til den minste og m2 til den største, kan du returnere tabellen
    b definert ved:   int[] b = {m1, m2}; Hvor mange sammenligninger bruker metoden din?*/

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


    public static int[] minmaks(int[] a){
        int[] b = new int[2]; //1
        b[0] = min(a); //n-1
        b[1] = maks(a); //n-1
        return b;//1
    }

    public static int[] minmakss(int[] a)
    {
        return new int[]{min(a),maks(a)};
    } //2n-2 --> fordi den alltid er n-1 til hver kalling

    //litt effektiv

    public static int[] minmaksss(int[] a)
    {
        int mi = 0, minverdi = a[0];
        int ma = 0, maksverdi = a[0];

        int verdi = 0;

        for (int i = 1; i < a.length; i++)
        {
            verdi = a[i];

            if (verdi > maksverdi) { maksverdi = verdi; ma = i;}
            else if (verdi < minverdi) {minverdi = verdi; mi = i;}
        }

        return new int[]{mi,ma};
    }

    /*6. Utrykket n! betyr n fakultet og er gitt ved n! = n · (n-1) ·  ·  · 2 · 1 . Lag en metode
    long fak(int n) som regner ut n!. Hvor mange multiplikasjoner utføres i metoden?*/

    public static long fak(int n){
        if (n < 0){
            throw new IllegalArgumentException("n < 0");
        }
        long fak = 1;
        for(int i=2; i<=n; i++){
            fak=fak*i;
        }
        return fak;
    }
}
