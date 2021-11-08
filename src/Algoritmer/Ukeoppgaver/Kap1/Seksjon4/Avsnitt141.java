package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Tabell;

public class Avsnitt141 {
    /*1. Legg de to maks-metodene fra Programkode 1.4.1 a) og b) inn i samleklassen Tabell og lag et program som
    utfører Programkode 1.4.1 c).*/

    public static void main(String[]args){
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s

        System.out.println(a[k] + "  " + d[l] + "  " + s[m]);

        // Utskrift:  9  7.12  Thanh
    }

    /*2. Lag en maks-metode som finner posisjonen til den «største» verdien i en char-tabell. Hvor mange endringer
    må du gjøre hvis du tar utgangspunkt i maks-metoden for datatypen double, dvs. Programkode 1.4.1 a). Test
    metoden din ved å legge inn en char-tabell i Programkode 1.4.1 c). Hint: En char-tabell c som for eksempel
    inneholder tegnene J, A, S, M, I og N, kan lages slik: char[] c = "JASMIN".toCharArray();*/

    //Datatypen char er egentlig ikke en heltallstype, men fungerer som det i mange sammenhenger. Variabler av typen char kan inngå i logiske og aritmetiske utrykk. For eksempel slik:

    char a = 'A';
    char b = 'B';

    int c = a - b;    // verdien til c er nå -1

    //Hvis to tegn sammenlignes ved hjelp av en logisk operator, er det tegnenes ascii-verdier som sammenlignes. Det betyr at av to tegn er det "størst" som alfabetisk kommer sist av de to. En maks-metode for en char-tabell kan dermed lages slik:

    public static int maks(char[] c)
    {
        int m = 0;                    // indeks til "største" tegn
        char maksverdi = c[0];        // "største" tegn

        for (int i = 1; i < c.length; i++) if (c[i] > maksverdi)
        {
            maksverdi = c[i];     // "største" tegn oppdateres
            m = i;                // indeks til "største" tegn oppdaters
        }
        return m;     // returnerer posisjonen til "største" tegn

    } // maks

    /*3. Lag en maks-metode som finner posisjonen til den største verdien i en Integer-tabell. Hvor mange endringer
    må du gjøre hvis du tar utgangspunkt i maks-metoden for tegnstrenger, dvs. Programkode 1.4.1 b). Test metoden. En
    testtabell kan du opprette slik: Integer[] a = {5,2,7,3,9,1,8,4,6};*/

    public static int maks(Integer[] a)
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];           // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi

    } // maks

    /*4. La a og b være ta variabler av typen Integer. Finn ut f.eks. ved å eksperimentere, hva a.compareTo(b)
    returnerer. Sett så opp den regelen som metoden er kodet etter.*/

    //Hvis a er mindre enn b, vil a.compareTo(b) returnere -1, hvis de er like, vil metodekallet returnere 0 og
    // hvis a er større enn b, blir det 1.

    /*5. Finn ut, ved å eksperimentere, hva metoden compareTo i class String returnerer. Du kan f.eks. lage et program som inneholder:
  String s = "A", t = "B";
  System.out.println(s.compareTo(t));
    Se hvilket tall utskriften gir. Bytt så ut A og B med andre bokstaver, og se om du finner et mønster. Hva blir det
    hvis s = "A" og t = "a"? Hvilket tall gir utskriften hvis s = "Æ" og t = "Å"? Hva hvis s = "Ø" og t =
    "Å"? (Se også Avsnitt 1.4.10). Bruk så ord istedenfor enkelttegn. Se spesielt på situasjonen der s utgjør
    første del av t eller t første del av s, for eksempel s = "Karianne" og t = "Kari". Kildekoden til class String
    vil gi deg fasiten.*/

    /*Metoden compareTo i class String virker slik: Hvis strengen s er forskjellig fra strengen t, s ikke utgjør første del av t og t ikke utgjør første del av s, så finnes det en første posisjon der s og t har forskjellige tegn. La f.eks. s = "Jasmin" og t = "Jason". Første posisjon der disse er forskjellige, er posisjon 3 siden tegnet m er forskjellig fra tegnet o. (Obs. første posisjon i en streng er 0). Metoden compareTo returnerer da differansen mellom ascii-verdiene til disse to tegnene. I dette tilfellet vil s.compareTo(t) returnere 'm' - 'o' = -2.

    Hvis s og t er gitt slik som i oppgaveteksten, dvs. s = "A" og t = "B", vil s.compareTo(t) returnere verdien 'A' - 'B' = -1.

    Problemet med Æ, Ø og Å er at de er plassert i feil innbyrdes rekkefølge i både UTF-8, Unicode og ISO-8859-1. Se Avsnitt 1.4.9.

    Vi får et spesialtilfelle hvis s utgjør første del av t eller t første del av s. F.eks. s = "Karianne" og t = "Kari". Da vil s.compareTo(t) returnere differansen mellom de to strengenes lengder. I dette tilfellet blir det 8 - 4 = 4. Legg også merke til at s eller t eller begge, kan være tomme. Hvis f.eks. s = "" og t = "Petter", utgjør egentlig s første del av t. Dermed vil s.compareTo(t) returnere verdien 0 - 6 = -6.

    Til slutt får vi at s.compareTo(t) vil returnere 0 hvis s og t har nøyaktig samme innhold.

    Flg. metode sammenlign er kodet slik at hvis s og t er to vilkårlige tegnstrenger, vil s.compareTo(t) og sammenlign(s,t) alltid gi samme returverdi:*/

    public static int sammenlign(String s1, String s2)
    {
        int n1 = s1.length();    // lengden til s1
        int n2 = s2.length();    // lengden til s2

        int n = n1 < n2 ? n1 : n2;    // den minste av n1 og n2

        for (int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) return c1 - c2;
        }
        return n1 - n2;
    }

    /*6. Ulikhetstegn gjelder ikke for boolean. F.eks. er false < true ulovlig. Men Boolean har metoden public static
    int compare(boolean x,boolean y) og ved hjelp av den kan vi finne hva som regnes som «minst» og «størst» av false
    og true. Hva blir utskriften:
  System.out.println(Boolean.compare(false, true));*/
    //Resultatet blir -1 siden false er «mindre enn» true.
}
