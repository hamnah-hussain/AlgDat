package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Tabell;

import java.util.Arrays;

import static Datastrukturer.Tabell.fratilKontroll;

public class Avsnitt143 {
    /*2. Omtrent hver gang Java kommer i ny versjon er det noen nye ting i klassen Integer. I API-en vil en se i
    hvilken versjon det har kommet nye ting. Ta en rask gjennomgang av API-en og se om det er konstanter og metoder
    der som kan være nyttige. Noen viktige nyheter i Java 8 er metoder for å kunne arbeide uten fortegn. Her er noen
    eksempler på metoder: toUnsignedString, parseUnsignedInt, compareUnsigned, remainderUnsigned og divideUnsigned.
    Hva tror du flg. metodekall returnerer: Integer.compare(-1, 1); ? Hva med: Integer.compareUnsigned(-1, 1); ?*/

    //Noen eksempler:

    /*public static void main(String[]argsg) {
        String s = Integer.toUnsignedString(-1);
        String t = Integer.toUnsignedString(Integer.MIN_VALUE);
        System.out.println(s + " " + t);  // 4294967295 2147483648

        int k1 = -1 / 10;                        // kvotient k1 = -(1/10) = 0
        int k2 = Integer.divideUnsigned(-1, 10);  // kvotient
        System.out.println(k1 + " " + k2);       // 0 429496729

        int d1 = Integer.compare(-1, 1);
        int d2 = Integer.compareUnsigned(-1, 1);
        System.out.println(d1 + " " + d2);       // -1 1
    }*/
    //Metodekallet Integer.compare(-1, 1); returnerer -1. Det er slik det skal være siden -1 er mindre 1.
    // Men metodekallet Integer.compareUnsigned(-1, 1); returnerer 1. Binærkoden til -1 har 32 1-biter. Men det er
    //tallet 4294967295 når vi ser bort fra fortegn. Men 4294967295 er større enn 1. Dermed returnerer metoden 1.

    /*5. Lag metoden public static void skriv(Object[] a, int fra, int til). Den skal skrive elementene (mellomrom
    mellom hvert) fra a[fra:til> på én linje (uten mellomrom til slutt). Lag så en skriv-metode som skriver ut hele a.
     Lag også tilsvarende metoder med navn skrivln (de skal avslutte med linjeskift). Lag også metoden public static
     void bytt(Object[] a, int i, int j). Den skal bytte om elementene på plassene i og j i tabellen a. Legg alle
     metodene i samleklassen Tabell.v*/

    public static void skriv(Object[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0){
            System.out.print(a[fra]);
        }
        for (int i = fra + 1; i < til; i++){
            System.out.print(" " + a[i]);
        }
    }

    public static void skrivln(Object[] a, int fra, int til){
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(Object[] a){
        skrivln(a, 0, a.length);
    }

    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*6. Legg bytt og randPermInteger fra Programkode 1.4.3 d) inn i samleklassen Tabell og sjekk at
    Programkode 1.4.3 e) virker. Lag større tabeller, f.eks. med 20 verdier.*/

    public static void main(String[]args){
        Integer[] a = Tabell.randPermInteger(20);
        System.out.println(Arrays.toString(a));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    /*7. Gitt tabellen: double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};  Lag kode som lager en Double-tabell ved
    hjelp av den gitte double-tabellen og som så bruker den generiske innsettingssorteringen. Se Programkode 1.4.3 c).*/

    /*double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
  Double[] b = new Double[d.length];

  // hvert element b lages som en instans av class Double
  for (int i = 0; i < b.length; i++) b[i] = d[i];  // autoboksing

  Tabell.innsettingssortering(b);
  Tabell.skrivln(b);  // se Oppgave 5*/

    /*8. Det kan oppstå tvetydigheter hvis primitive typer og omslagsklasser blandes. Metoden
    public static void f(int a, Integer b) { } har først en int og så en Integer som argument. I metoden
    public static void f(Integer a, int b) { } er det motsatt. Dermed er disse metodene forskjellige. Hva vil
    kompilatoren si til metodekallet f(1,1); Hva skjer hvis en av metodene kommenteres vekk? Hvis begge metodene finnes,
     hvordan kan en da endre i kallet f(1,1); for at en bestemt av dem skal brukes?*/

    /*Hvis du har tilgang til begge metodene i et program, vil metodekallet f(1,1); føre til at kompilatoren gir en
    feilmelding som denne: Reference to f is ambiguous. Both method f(int,Integer) og method f(Integer,int) match.
    Det kommer av at hvis den første f-en skal brukes, må det andre 1-tallet konverteres til en Integer. Hvis derimot
    den andre f-en skal brukes, må de første 1-tallet konverteres til en Integer. Det ene er ikke noe riktigere enn det
     andre. Derfor er det tvetydig.
    Hvis en av metodene tas vekk, vil metodekallet f(1,1); bli utført. Det er det samme hvilken som tas vekk.
    En kan bestemme hvem av dem som skal brukes ved å konvertere ett av tallene til en Integer:
  f(1, (Integer)1);  // nå brukes f(int a, Integer b)
  f((Integer)1,1);   // f(Integer a, int b)*/

}
