package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

import Datastrukturer.Eksempelklasser.Student;
import Datastrukturer.Eksempelklasser.Studium;
import Datastrukturer.Tabell;

public class Avsnitt145 {
    /*1. Flytt enumtypen Studium over til deg. Legg den under (package) eksempelklasser. Lag så et program
    der Programkode 1.4.5 b) inngår og kjør programmet.*/

    /*public static void main(String[]args){
        for (Studium s : Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
    }*/

    /*2. Hvis du ikke allerede er kjent med enumtyper, burde du lære deg mer om dem. En enumtype er en referansetype og
     fungerer omtrent som andre referansetyper (klasser og grensesnitt). Det som ramses opp i typedefinisjonen kalles
     enumkonstanter. De bør normalt ha store bokstaver eller minst ha stor forbokstav. Det er mulig å la navnet starte
     med _ (understrek), $ (dollar) eller £ (pund), men det brukes svært sjelden. En enumtype er en subtype til Object
     og har dermed alle Object-metodene. En av dem er toString() som er overskrevet (eng: overridden) i Studium.
     Hvis ikke, ville toString() og name() gi samme resultat, dvs. navnet på enumkonstanten. Det er ikke mulig å
     opprette instanser av en enumtype ved hjelp av new. Trengs det flere, må de settes opp sammen med de andre i
     «oppramsingen». En enumtype er alltid Comparable (og har dermed metoden compareTo). Ordningen er den rekkefølgen
     de har i «oppramsingen». Metoden ordinal() forteller hvilket nummer i rekkefølgen en enumkonstant har. Den første
     har ordinalverdi lik 0, den neste 1, osv.*/


    /*3. Lag enumtypen Måned. Den skal inneholde konstanter for hver måned (med tre bokstaver), JAN, FEB, . . . , NOV,
     DES. La typen få en instansvariabel med navn mndnr og en aksessmetode med samme navn. Det betyr at
     Måned.JAN.mndnr() skal gi 1, osv. til at Måned.DES.mndnr() skal gi 12. La også typen få en instansvariabel med
     navn fulltnavn. For JAN skal det være januar, osv. Overskriv toString() slik at den gir det fulle navnet. Lag også
     public static String toString(int mnd) slik at den gir januar for mnd lik 1, osv. La videre Måned ha fire
      statiske metoder vår(), sommer(), høst() og vinter(). Hver av dem skal reture en Måned-tabell som inneholder
      de tilsvarende enumkonstantene. Vi sier at APRIL og MAI er vår, JUN, JUL og AUG er sommer, SEP og OKT er høst
      og at NOV, DES, JAN, FEB og MAR er vinter. Skriv så ut innholdet ved hjelp av et program av samme type som i
      Programkode 1.4.5 b). Legg Måned under package eksempelklasser.*/


    /*4. Det hender at en elektrostudent tar emnet Algoritmer og datastrukturer. Utvid enumtypen Studium slik at det
     også inngår en enumkonstant Elektro. Legge den f.eks. som nr. fire (foran Enkeltemne). Studiets navn er:
      Ingeniørfag - elektronikk og informasjonsteknologi.*/


    /*5. Flytt klassen Student over til deg (package eksempelklasser) og sjekk at Programkode 1.4.5 d) virker som
    de skal. Legg inn et par elektrostudenter (se Oppgave 4) og et par enkeltemnestudenter i tabellen i Programkode
    1.4.5 d). Kjør programmet.*/

    public static void main(String... args)
    {
        Student[] s = new Student[9];                             // en studenttabell

        s[0] = new Student("Kari","Svendsen",Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic",Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn",Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic",Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen",Studium.Data);     // Kari Pettersen
        s[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
        s[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
        s[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
        s[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie

        Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);
    }

}
