package Algoritmer.Ukeoppgaver.Kap1.Seksjon2;

public class Avsnitt129 {
    /*1. Finn antall noder i Figur 1.2.8 a)? Hvor mange er bladnoder? Hvor mange er indre noder?*/

    //Treet i Figur 1.2.8 a) har 31 noder, 16 bladnoder og 15 indre noder.
    //Indre noder er foreldrene
    //Bladnoder har ingen barn
    //Noder er antall noder tilsammen

    /*2. Hvor mange noder er det på nivå k (k = 0, 1, 2, . . ) i et turneringstre av den typen som Figur 1.2.8 a)
    viser?*/

    //I et turneringstre av samme type som i Figur 1.2.8 a) (dvs. et perfekt tre) er det 2k noder på nivå k.

    /*3. Anta at antall deltagere n i en turnering er på formen n = 2k, dvs. n = 1, 2, 4, 8, osv. Finn svarene på flg.
    spørsmål uttrykt ved n: Hvor mange noder får turneringstreet? Hvilken høyde får treet? Hvor mange er bladnoder og
    hvor mange er indre noder? Hvor mange sammenligninger utføres i turneringen?*/

    /*La antallet deltagere n = 2k. Da vil treet ha 2n - 1 noder, ha høyde lik log2n og ha n bladnoder. I turneringen
    vil det bli utført n - 1 sammenligninger, dvs. et samme som antallet indre noder.*/

}
