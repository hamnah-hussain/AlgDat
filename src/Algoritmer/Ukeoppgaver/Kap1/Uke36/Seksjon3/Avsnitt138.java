package Algoritmer.Ukeoppgaver.Kap1.Uke36.Seksjon3;

import Datastrukturer.Tabell;

import java.util.Arrays;

public class Avsnitt138 {
    /*3. Sett deg inn i metodene copyOf() og copyOfRange() fra klassen Arrays. De brukes både til å «utvide» en tabell
    og til å lage en kopi av hele eller en del av en tabell.*/

    //Metodene copyOf() og copyOfRange() vil ofte bli brukt. Begge er laget for alle standardtypene og for en generisk
    // type T. Bruker vi f.eks. typen int, har de flg. signaturer:

    //public static int[] copyOf(int[] original, int newLength)
    //public static int[] copyOfRange(int[] original, int from, int to)
    //I copyOf() kan ikke newLength være negativ, men den kan være 0, mindre enn, lik eller større enn original.length.
    // Hvis den er støøre enn original.length, blir tabellen «utvidet» med 0-er på de plassene som har kommet i tillegg.
    //I copyOfRange() må vi ha 0 <= from <= to og from <= original.length. Hvis to > original.length, blir det 0-er på
    // de nye plassene. Eksempel:

    /*int[] b = {1,2,3,4,5,6};
    b = Arrays.copyOfRange(b, 3, 9);*/
    // b = {4,5,6,0,0,0}

    /*4. Setningen for (int i = antall; i > k; i--) a[i] = a[i-1]; i Programkode 1.3.8 a) forskyver verdier i tabellen.
     Dette kan også gjøres ved hjelp av metoden arraycopy() i klassen System. Gjør det!*/

    /*
    int[] a = {3,5,6,10,10,11,13,14,16,20,0,0,0,0,0};  // en tabell
    int antall = 10;                                   // antall verdier

  if (antall >= a.length) throw new IllegalStateException("Tabellen er full");

    int nyverdi = 10;                                  // ny verdi
    int k = Tabell.binærsøk(a, 0, antall, nyverdi);    // søker i a[0:antall>
  if (k < 0) k = -(k + 1);                           // innsettingspunkt
    System.arraycopy(a, k, a, k + 1, antall - k);
    antall++;                                          // øker antallet

  Tabell.skrivln(a, 0, antall);  // Se Oppgave 4 og 5 i Avsnitt 1.2.2*/

    /*5. Se på innsettings- og utvalgssortering. Se Figur 1.3.8 g). Hvor mange sammenligninger brukes i gjennomsnitt i
    hver av dem hvis det er 1000 verdier?*/

    /*Innsettingssortering bruker i gjennomsnitt n(n + 3)/4 - Hn sammenligninger for å sortere n forskjellige tall.
    Hn er tilnærmet lik log(n) + 0,577 og H1000 tilnærmet lik 7,5. Dermed får vi 1000(1000 + 3)/4 - 7,5 = 250.742,5
    sammenligninger i gjennomsnitt for n = 1000. For utvalgssortering blir det 1000(1000 - 1)/2 = 499.500
    sammenligninger for n = 1000. Med andre ord halvparten så mange i innsettingssortering sammenlignet med
    utvalgssortering.*/

    /*6. Lag kode som viser tidsforbruket til innsettings- og utvalgssortering. Den første har bare halvparten så mange
     sammenligninger, men har flere ombyttinger (eller tilordninger).*/

    /*int[] a = Tabell.randPerm(100000);
    int[] b = a.clone();
    long tid1 = System.currentTimeMillis();
  Tabell.utvalgssortering(a);
    tid1 = System.currentTimeMillis() - tid1;

    long tid2 = System.currentTimeMillis();
  Tabell.innsettingssortering(b);
    tid2 = System.currentTimeMillis() - tid2;

  System.out.println("Utvalgssortering: " + tid1);
  System.out.println("Innsettingssortering: " + tid2);*/

    /*7. Lag en versjon av innsettingssortering som sorterer i tabellintervallet a[fra:til>. Legg den i samleklassen
    Tabell.*/

    public static void innsettingssortering(int[] a, int fra, int til)
    {
        for (int i = fra+1; i < til; i++)  // starter med i = 1
        {
            int temp = a[i];  // hjelpevariabel
            for (int j = i - 1; j >= 0 && temp < a[j]; j--) Tabell.bytt(a, j, j + 1);
        }
    }

    /*8. En sorteringsmetode kalles stabil hvis like verdier har samme innbyrdes rekkefølge etter som før sorteringen.
     Sjekk at innsettingssortering er stabil.*/

    /*Innsettingssortering er stabil fordi indre for-løkke har setningen temp < a[j]. Det betyr at letingen etter rett
    sortert plass stopper hvis temp er lik a[j] og temp blir satt inn i a[j+1], dvs. etter a[j].*/

}
