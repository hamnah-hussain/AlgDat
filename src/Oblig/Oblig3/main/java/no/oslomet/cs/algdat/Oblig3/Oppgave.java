package Oblig.Oblig3.main.java.no.oslomet.cs.algdat.Oblig3;

@FunctionalInterface
public interface Oppgave<T>  // legges under hjelpeklasser
{
    void utførOppgave(T t);    // f.eks. utskrift til konsollet
}
