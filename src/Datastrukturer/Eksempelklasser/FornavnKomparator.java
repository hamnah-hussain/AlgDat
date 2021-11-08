package Datastrukturer.Eksempelklasser;

import java.util.*;

public class FornavnKomparator implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)  // sammenligner to personer
    {
        // bruker compareTo-metoden fra String-klassen
        int cmp = p1.fornavn().compareTo(p2.fornavn());

        if (cmp != 0)
        {
            return cmp;     // fornavnene er forskjellige
        }
        // ordner etter etternavn hvis fornavnene er like
        return p1.etternavn().compareTo(p2.etternavn());
    }

} // class FornavnKomparator
