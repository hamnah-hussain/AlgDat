package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Eksempelklasser.Komparator;
import Datastrukturer.Eksempelklasser.Person;
import Datastrukturer.Eksempelklasser.Student;
import Datastrukturer.Eksempelklasser.Studium;
import Datastrukturer.Tabell;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static Datastrukturer.Tabell.fratilKontroll;

public class Avsnitt146 {
    /*1. Legg Komparator over til deg (under mappen eksempelklasser), legg metoden i Programkode 1.4.6 b) inn i
    samleklassen Tabell og sjekk at Programkode 1.4.6 c) virker. Gjør så slik som i Programkode 1.4.6 e) og til slutt
     slik som i Programkode 1.4.6 f).*/

    /*public static void main(String... args)
    {
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]
    }*/

    /*2. Sjekk at Programkode 1.4.6 g) virker. Utvid tabellen, dvs. med flere studenter og studier. Erstatt så de to
     siste linjene med Programkode 1.4.6 h). Dropp så komparatorvariabelen c og la isteden lambda-uttrykket inngå
      direkte som argument i sorteringsmetoden.*/

    /*public static void main(String[]args)
    {
        Student[] s = new Student[9];                             // en studenttabell

        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic",Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn",Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic",Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen",Studium.Data);     // Kari Pettersen
        s[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
        s[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
        s[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
        s[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie

        Tabell.innsettingssortering(s, (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    return k != 0 ? k : s1.compareTo(s2);
                }
        );

        for (Student t : s) System.out.println(t);
    }*/

    /*3. Lag et lamda-uttrykk som ordner studentene etter studium, fornavn og etternavn.*/

    /*Tabell.innsettingssortering(s,
            (s1,s2) ->
    {
        int k = s1.studium().compareTo(s2.studium());
        if (k != 0) return k;
        k = s1.fornavn().compareTo(s2.fornavn());
        if (k != 0) return k;
        return s1.etternavn().compareTo(s2.etternavn());
    }
  );*/

    /*4. Lag metoden public static <T> int maks(T[] a, Komparator<? super T> c). Bruk f.eks. maks-metoden som
    utgangspunkt. Legg den i samleklassen Tabell.*/

    public static <T> int maks(T[] a, Komparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a, int fra, int til, Komparator<? super T> c)
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

    /*5. Utvid lambda-uttrykket i Programkode 1.4.6 i) slik at like lange strenger ordnes alfabetisk. La så tabellen
     s inneholde "21","18","8","13","20","6","16","25","3","10". Kan du forutsi hvordan den vil bli sortert?
     Kjør så koden.*/

    /*String[] s = {"21","18","8","13","20","6","16","25","3","10"};

  Tabell.innsettingssortering(s, (x,y) ->
    {
      int k = x.length() - y.length();
      return k != 0 ? k : x.compareTo(y);
    }
  );

  System.out.println(Arrays.toString(s));*/

    /*7. 	Lambda-uttrykket i Programkode 1.4.6 h) ordner studiene «naturlig» (dvs. rekkefølgen de har i enumen).
     Gjør om slik at de ordnes alfabetisk etter navn (Anvendt, Data, IT).*/

    /*Komparator<Student> c = (s1,s2) ->
    {
        int cmp = s1.studium().name().compareTo(s2.studium().name());
        return cmp != 0 ? cmp : s1.compareTo(s2);
    };*/
}
