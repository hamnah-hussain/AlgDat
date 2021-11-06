package Algoritmer.Ukeoppgaver.Kap1.Uke35.Seksjon2;

public class Avsnitt126 {
    /*1. Sjekk at versjonen av nestMaks-metoden i Programkode 1.2.5 a) utfører nøyaktig 2n − 3 sammenligninger når
    tabellen er sortert.*/

    //Må sjekke hvordan man gjør sammenlinkinger igjen

    /*2. For hvilke tabeller bruker metoden færrest mulig sammenligninger?*/

    //Det blir færrest mulig sammenligninger når de to største verdiene ligger helt først i tabellen.

    /*3. Er det noen forskjell på gjennomsnittlig effektivitet, effektiviteten i det mest ugunstige tilfellet og
    effektiviteten i det beste tilfellet for maks-metoden, dvs. for den metoden som finner posisjonen til den største
    verdien i en tabell?*/

    /*I maks-metoden er det ingen forskjell når det gjelder sammenligninger. Uansett hvordan en tabell med lengde n
    ser ut, må det utføres n − 1 sammenligninger for å finne den største verdien. Men hvis vi bruker den versjonen av
    maks-metoden vi har i Programkode 1.1.4, så er det også mulig å ta med de tilordningene som utføres når
    a[i] > maksverdi er sann. De blir det flest av hvis tabellen er sortert stigende og færrest av hvis den største
    ligger først.*/

}
