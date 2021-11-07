package Algoritmer.Ukeoppgaver.Kap1.Uke36.Seksjon3;

import static Datastrukturer.Tabell.*;

public class Avsnitt134 {
    /*1. I Figur 1.3.4 d) er det gjort tre iterasjoner. Hva blir det etter i) 5 og ii) 7 iterasjoner.*/

    //https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit134.html

    /*5. utvalgssortering i Programkode 1.3.4 a) bruker to hjelpemetoder. Det er mest vanlig å kode den uten
    hjelpemetoder. Søk på internett. Bruk «selection sort» som søkeord. Lag så din egen versjon (uten hjelpemetoder)!
    Hvor lang tid bruker den for en tilfeldig tabell med 100000 verdier? Er den bedre enn den fra
    Programkode 1.3.4 a)?*/

    public static void utvalgssortering5(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            int m = i;             // indeks til den foreløpig minste
            int  minverdi = a[i];  // verdien til den foreløpig minste

            for (int j = i + 1; j < a.length; j++)
            {
                if (a[j] < minverdi)
                {
                    minverdi = a[j];  // ny minste verdi
                    m = j;            // indeksen til ny minste verdi
                }
            }
            // bytter om a[i] og a[m]
            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }

    /*9. Lag metoden public static void utvalgssortering(int[] a, int fra, int til). Den skal sortere intervallet
    a[fra:til>. Pass på at du tester lovligheten til intervallet!*/

    public static void utvalgssortering(int[] a, int fra, int til){
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til - 1; i++)
        {
            int m = i;             // indeks til den foreløpig minste
            int  minverdi = a[i];  // verdien til den foreløpig minste

            for (int j = i + 1; j < til; j++)
            {
                if (a[j] < minverdi)
                {
                    minverdi = a[j];  // ny minste verdi
                    m = j;            // indeksen til ny minste verdi
                }
            }
            // bytter om a[i] og a[m]
            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }

    /*10. En sorteringsalgoritme kalles stabil hvis like verdier har samme innbyrdes rekkefølge etter sorteringen
    som de hadde før. Er utvalgssortering stabil?*/

    //https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit134.html

    /*11. Ta utgangspunkt i den versjonen av utvalgssortering som står i Programkode 1.3.4 a). Men gjør ingen ombytting
     i det tilfellet samme verdi vil bli byttet med seg selv. Det vil påføre algoritmen en ekstra kostnad siden det må
     gjøres en sammenligning hver gang, men spare arbeidet med unødvendige ombyttinger. Finn ut, ved å bruke tilfeldige
     permutsajoner, hvor mange ganger det skjer at en verdi ville ha blitt byttet med seg selv. Spesielt hvis tabellen
     allerede er sortert, byttes en verdi med seg i hver iterasjon. Kanskje du klarer å finne en formel for det
     gjennomsnittlige antall ganger en verdi vil bli byttet med seg selv? Vil det lønne seg å ha denne ekstra testen?*/

    //https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit134.html
}
