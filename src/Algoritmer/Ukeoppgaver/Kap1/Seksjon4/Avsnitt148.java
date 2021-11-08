package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

public class Avsnitt148 {
    /*1. Utvid din Komparator med det som er laget i Avsnitt 1.4.8, dvs. at den blir lik dette.*/

    /*2. Blir Komparator.orden(x -> x) og Komparator.naturligOrden() det samme? Forklar!*/

    /*Lambda-uttrykket x -> x representerer det som i matematikk kalles identitetsfunksjonen, dvs. funksjonen f som er
     slik at f(x) = x. Det betyr at det ordnes mhp. x og det er samme som naturlig ordning siden x er en instans av en
     sammenlignbar type. Dermed er Komparator.orden(x -> x) og Komparator.naturligOrden() det samme.*/

    /*4. I Programkode 1.4.7 i) ble det laget en komparator for datatypen String som ordner etter lengde. Men strenger
     med samme lengde får ingen bestemt orden. Bruk metoden deretter() slik at strenger med samme lengde ordnes
      alfabetisk. Bruk dette til å sortere s = {"21","18","8","13","20","6","16","25","3","10"};*/

    /*Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(x -> x));*/

}
