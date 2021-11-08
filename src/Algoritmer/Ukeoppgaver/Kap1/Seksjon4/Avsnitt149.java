package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Eksempelklasser.Komparator;
import Datastrukturer.Tabell;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static Datastrukturer.Tabell.*;

public class Avsnitt149 {
    /*1. Gjør om fra Komparator til Comparator i metoden i Programkode 1.4.6 b). Det eneste som trengs er å bytte ut K
     med C i metodens signatur. Se også Programkode 1.4.9 b). Sjekk så at Programkode 1.4.9 c) virker. Gjør det samme
     i maks-metoden hvis du har laget en versjon av den der Komparator inngår (se Oppgave 4 i Avsnitt 1.4.6).*/

    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)
        {
            T temp = a[i];  // flytter a[i] til en hjelpevariabel

            int j = i-1;    // starter med neste tabellposisjon

            // en og en verdi flyttes inntil rett sortert plass er funnet
            for (; j >= 0 && c.compare(temp,a[j]) < 0; j--) a[j+1] = a[j];

            a[j+1] = temp;  // temp legges inn på rett plass
        }
    } // innsettingssortering
    public static <T> int maks(T[] a, Comparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden under
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks

    /*2. Lag en komparator-versjoner (Comparator) av a) utvalgssortering, b) binærsøk, c) kvikksortering og d)
    flettesortering. Legg metodene i samleklassen Tabell.*/

    //a utvalgssortering

    public static <T> void bytt(T[] a, int i, int j)
    {
        T temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;           // indeks til minste verdi i a[fra:til>
        T minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (c.compare(a[i], minverdi) < 0)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }

    //b binærsøk

    public static <T>
    int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }

    //c kvikksortering

    public static <T>
    int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T>
    int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }

    public static <T>
    void kvikksortering(T[] a, Comparator<? super T> c) // sorterer hele tabellen
    {
        kvikksortering(a,0,a.length-1,c);
    }

    //d flettesortering

    private static <T>
    void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T>
    void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }

    /*3. a) Sjekk at Programkode 1.4.9 f) virker og gir den utskriften som står oppgitt.
 	b) Bruk komparatoren fra Programkode 1.4.9 d) i Programkode 1.4.9 f). Virker det?
 	c) De to komparatoren rett under Programkode 1.4.9 e) bruker koordinatene direkte. Bruk dem i Programkode 1.4.9 f).
 	 Virker det?
 	d) Komparatorene i punkt c) over har (Point p) -> p.x i første parentes. Ta vekk Point slik at det kun
 	 står p -> p.x. Hva skjer?
 	e) Komparatoren i Programkode 1.4.9 f) bruker metodene getX og getY som returnerer en double. Deretter blir double
 	 konvertert til Double (autoboksing). Her får vi mer effektiv kode hvis vi isteden bruker comparingDouble og
 	 thenComparingDouble. Prøv det!
 	f) Anta at vi har en samling punkter i 1. kvadrant (ingen negative koordinater). Lag en komparator som ordner
 	 punktene på flg. måte: Et punkt som ligger nærmere origo enn et annet punkt regnes som «mindre» enn det andre.
 	 Hvis de ligger like langt fra origo regnes det som har minst y-koordinat som «minst». Bruk den i Programkode
 	 1.4.9 f).
 	g) Anta at vi har en samling punkter i 1. kvadrant (ingen negative koordinater). Vinkelen til et punkt p forskjellig
 	 fra origo defineres som den vinkelen den rette linjen gjennom origo og p danner med x-aksen. Lag en komparator som
 	 ordner punktene på flg. måte: Det av to punkter som har minst vinkel regnes som «minst». Hvis de to punktene har
 	 samme vinkel, regnes det som minst som ligger nærmest origo. Spesielt gjelder at origo, dvs. punktet (0,0), er
 	 «mindre enn» alle andre punkter. Bruk den i Programkode 1.4.9 f).*/

    //a

    public static void main(String[]args){
        int[] x = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i],y[i]);

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
        System.out.println();                    // linjeskift

        Tabell.innsettingssortering(punkt,
                Comparator.comparing(Point::getX).thenComparing(Point::getY));

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");

        // Utskriften blir:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)
    }

    //b

    /*Tabell.innsettingssortering(punkt, (p1, p2) ->
    {
        int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
        if (d != 0) return d;
        return p1.y - p2.y;     // forskjellen mellom x-koordinatene
    }
  );*/

    //c



    //d

    //e

    //f

    //g

    /*4. a) Flytt Dato til deg (package eksempelklasser). Sjekk at Programkode 1.4.9 h) virker.
 	b) I Programkode 1.4.9 h) inngår den versjonen av innsettingssortering som er laget for sammenlignbare typer,
 	 se Programkode 1.4.2 e). Bruk isteden komparatorversjonen (Programkode 1.4.6 b) og en naturalOrder-komparator.
 	c) Sjekk at compareTo() i datoklassen i Programkode 1.4.9 g) oppfyller kravene 1 - 4.
 	Er det slik at x.compareTo(y) = -y.compareTo(x)?
 	d) Metoden equals() i datoklassen er kodet ved hjelp av compareTo(). Lag egen kode for equals(). Pass på at koden
 	 blir slik at x.equals(y) = y.equals(x) for alle datoer x og y. Pass også på at x.equals(y) = true hvis og bare
 	 hvis x.compareTo(y) = 0.
 	e) hashCode() i Dato er laget ved hjelp av en metode fra klassen Objects. Sjekk hva den gjør. Kommentér vekk så
 	 hashCode(). Bruker du NetBeans vil du ved siden av equals() få en melding (et gult symbol) om at du bør kode
 	 hashCode(). Klikker du på det gule symbolet, vil du få hjelp. Gjør det! Omvendt, har laget hashCode(), men ikke
 	 equals(), vil du også få hjelp. Det finnes tilsvarende muligheter i Eclipse - bruk menyvalget Source.
 	f) Legg inn en ekstra konstruktør i datoklassen. I den skal måneden kunne skrives vha. enumkonstanter fra enum
 	 Måned (se Oppgave 3 i Avsnitt 1.4.5). For eksempel skal 17. mai og julaften kunne opprettes ved:
 	 Dato mai17 = new Dato(17,Måned.MAI,2016); og Dato julaften = new Dato(24,Måned.DES,2016); Uttskrift skal bli slik: 17. mai 2016 og 24. desember 2016. Lag konstruktøren og de tilleggene og endringene som må til. Bruk StringBuilder når du omkoder toString().*/

    /*5. Lag klassen Klokkeslett. Den skal implementere Comparable. Det holder med timer og minutter. Klokkeslett
     skal ordnes slik at 00:00 kommer først og 23:59 sist. Konstruktøren skal ha en String som argument og være på
     formen tt:mm, f.eks. "12:00". Lag også metodene equals(), hashCode() og toString(). Bruk Dato-klassen som mønster.
     Lag en programbit der du oppretter en tabell av klokkeslett som så sorteres og skrives ut.*/

}
