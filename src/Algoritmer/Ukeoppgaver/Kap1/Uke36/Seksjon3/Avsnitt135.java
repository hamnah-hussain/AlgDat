package Algoritmer.Ukeoppgaver.Kap1.Uke36.Seksjon3;

import Datastrukturer.Tabell;

public class Avsnitt135 {

    /*2. Sjekk at metoden lineærsøk gir korrekt returverdi hvis det søkes etter en verdi som er mindre enn den minste
    i tabellen. Hva skjer hvis tabellen er tom, dvs. a.length = 0? La a være tabellen i Figur 1.3.5 a).
    Hva blir returverdiene fra lineærsøk hvis vi søker etter 2, 15, 16, 40 og 41?*/

    public static void main(String[]args){
        int[] a = {};  // Figur 1.3.5 a)
        System.out.println(Tabell.lineærsøk(a,32));              // utskrift: -1
        int[] b = {3,8,10,12,14,16,21,24,27};
        System.out.println(Tabell.lineærsøk(b,31));              // utskrift: -11
        System.out.println(Tabell.lineærsøk(b,1));              // utskrift: -1
        System.out.println(Tabell.lineærsøk(b,41));              // utskrift: -16
        System.out.println(kvadratrotsøk(b,16));
    }

    /*3. Hvis verdi forekommer flere ganger i tabellen a, vil posisjonen til den første av dem (fra venstre) bli
    returnert. Lag en versjon av lineærsøk der det er posisjonen til den siste av dem som returneres. Gjør det
    f.eks. ved å lete motsatt vei, dvs. fra høyre mot venstre.*/

    public static int motsattLineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        // vi leter motsatt vei, dvs. starter bakerst
            if (a.length == 0 || verdi < a[0])
                return -1;  // verdi er mindre enn den største

            int i = a.length - 1; for( ; a[i] > verdi; i--);

            return verdi == a[i] ? i : -(i + 2);
    }

    /*5. I lineærsøk sammenlignes én og én tabellverdi med verdi. Algoritmen stopper på verdi hvis den finnes og på den
     første som er større hvis den ikke finnes. Dette kan forbedres hvis vi «hopper» bortover i tabellen. La oss si at
     tabellen a har 100 verdier. Da kan vi f.eks. se på hver 10-ende verdi inntil vi har kommet langt nok
     (eller eventuelt havnet utenfor tabellen). Den søkte verdien må da, hvis den er i tabellen, ligge blant de 10
     siste verdiene vi hoppet over.*/

 	/*a)  I metoden public static int lineærsøk(int[] a, int k, int verdi) skal a og verdi være som i vanlig lineærsøk.
 	Parameter k (et positivt heltall) er «hopplengden». I beskrivelsen over var k lik 10. Metoden skal returnere
 	nøyaktig det samme som vanlig lineærsøk, også i det tilfellet den søkte verdien ikke finnes.*/

    public static int lineærsøk(int[] a, int k, int verdi)
    {
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k);

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++);

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }

 	/*c)  Hvis «hopplengden» k settes lik heltallsdelen av kvadratroten til tabellens lengde, får vi den beste
 	utnyttelsen av metodens idé. Hvilken orden vil metoden da få? Bruk det til å lage metoden public static int
 	kvadratrotsøk(int[] a, int verdi).*/

    public static int kvadratrotsøk(int[] a, int verdi)
    {
        return lineærsøk(a,(int)Math.sqrt(a.length),verdi);
    }

}
