package Algoritmer.Ukeoppgaver.Kap1.Seksjon3;

import Datastrukturer.Tabell;

public class Avsnitt136 {
    /*3. 	Gitt at søkeverdien har duplikater. Bruker vi 1. eller 2. versjon av binærsøk, vet vi ikke hvem av dem som
    den returnerte indeksen hører til. Gitt verdiene: 1, 3, 4, 4, 5, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15.
    Bruk 1. versjon. Søk etter i) 4, ii) 7, iii) 10 og iv) 15. Hvilken av verdiene hører den returnerte indeksen til?
    Obs. Det er det samme om det er 1. eller 2. versjon. De gir alltid de samme returverdi.*/

    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a,0,a.length,verdi);  // bruker metoden over
    }

    // 2. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk2(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else return m;                           // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk3(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }

    public static void main(String[]args){
        int[] a={1, 3, 4, 4, 5, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
        System.out.println("Binærsøk 1");
        System.out.println(binærsøk1(a, 0, a.length, 4));
        System.out.println(binærsøk1(a, 0, a.length, 7));
        System.out.println(binærsøk1(a, 0, a.length, 10));
        System.out.println(binærsøk1(a, 0, a.length, 15));
        System.out.println("Binærsøk 2");
        System.out.println(binærsøk2(a, 0, a.length, 4));
        System.out.println(binærsøk2(a, 0, a.length, 7));
        System.out.println(binærsøk2(a, 0, a.length, 10));
        System.out.println(binærsøk2(a, 0, a.length, 15));
        System.out.println("Binærsøk 3");
        System.out.println(binærsøk3(a, 0, a.length, 4));
        System.out.println(binærsøk3(a, 0, a.length, 7));
        System.out.println(binærsøk3(a, 0, a.length, 10));
        System.out.println(binærsøk3(a, 0, a.length, 15));
    }


    /*4. 3. versjon av binærsøk returnerer alltid indeksen til den første av dem hvis søkeverdien det søkes forekommer
    flere ganger. Sjekk at det stemmer for tallene i Oppgave 3.*/
}
