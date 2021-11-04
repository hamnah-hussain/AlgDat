package Algoritmer.Oblig.Oblig1.test.java.no.oslomet.cs.algdat.Oblig1;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    // Test for oppgave 1
    @org.junit.jupiter.api.Test
    void maks() {/*
        int antallFeil = 0;

        boolean unntak = false;
        int[] tom = {};
        try {
            Oblig1.maks(tom);  // kaller maks-metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Opgave 1: a) Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println("Opgave 1: b) Kast unntak for en tom tabell!");
            antallFeil++;
        }

        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        int[] e = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] f = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};
        if (Oblig1.maks(a) != 3 || Oblig1.maks(b) != 8 ||
                Oblig1.maks(c) != 5 || Oblig1.maks(d) != 5) {
            System.out.println("Oppgave 1: c) Maks-metoden: Feil resultat!");
            antallFeil++;
        }
        Oblig1.maks(e);
        if (!Arrays.equals(e, f)) {
            System.out.println("Oppgave 1: d) Maks-metoden: feil i ombyttingene!");
            antallFeil++;
        }
        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 1");
        */
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        /*
        int antallFeil = 0;
        boolean unntak = false;
        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        int[] e = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] f = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};



        a = new int[]{6, 5, 4, 3, 2, 1};
        b = new int[]{1, 2, 3, 4, 5};
        c = new int[]{4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        d = new int[]{2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

        if (Oblig1.ombyttinger(a) != 5 || Oblig1.ombyttinger(b) != 0
                || Oblig1.ombyttinger(c) != 7 || Oblig1.ombyttinger(d) != 6) {
            System.out.println("Oppgave 1: e) Feil opptelling i ombyttingsmetoden!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 1");

         */
    }

    //Testing oppgave 2
    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        /*
            int antallFeil = 0;

            int[] a = {};
            int[] b = {1};
            int[] c = {1, 2, 3, 4, 5, 4};

            try {
                Oblig1.antallUlikeSortert(a);  // kaller metoden
                Oblig1.antallUlikeSortert(b);  // kaller metoden
            } catch (Exception e) {
                System.out.println
                        ("Oppgave 2: a) Ikke unntak for tabell med 0 eller 1 verdi!");
                antallFeil++;
            }

            boolean unntak = false;

            try {
                Oblig1.antallUlikeSortert(c);  // kaller metoden
            } catch (Exception e) {
                unntak = true;
                if (!(e instanceof IllegalStateException)) {
                    System.out.println
                            ("Oppgave 2: b) Feil unntak for en usortert tabell!");
                    antallFeil++;
                }
            }

            if (!unntak) {
                System.out.println
                        ("Oppgave 2: c) Kast et unntak for en usortert tabell!");
                antallFeil++;
            }

            int[] d = {1, 1};
            int[] e = {1, 2, 3, 4, 5, 6, 7};
            int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

            if (Oblig1.antallUlikeSortert(a) != 0
                    || Oblig1.antallUlikeSortert(b) != 1
                    || Oblig1.antallUlikeSortert(d) != 1
                    || Oblig1.antallUlikeSortert(e) != 7
                    || Oblig1.antallUlikeSortert(f) != 7) {
                System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
                antallFeil++;
            }
            assertEquals(0, antallFeil, "Du har for mange feil i oppgave 2");

         */
        }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        /*
        assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        /*
        assertEquals(true, false, "Implementer delsortering og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {

        /*
        int antallFeil = 0;

        char[] a = {};

        try {
            Oblig1.rotasjon(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 5: a) Skal ikke kaste unntak for en tom tabell!!");
            antallFeil++;
        }

        char[] b = {'A'};
        char[] b0 = {'A'};
        Oblig1.rotasjon(b);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 5: b) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        char[] c = {'A', 'B'};
        char[] c0 = {'B', 'A'};
        Oblig1.rotasjon(c);
        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 5: c) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        Oblig1.rotasjon(d);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 5: d) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 5");

         */

        /*

        int antallFeil = 0;

        char[] a = {};

        try {
            Oblig1.rotasjon(a, 1);  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 6: a) Skal ikke kaste unntak for en tom tabell!!");
            antallFeil++;
        }

        char[] b = {'A'};
        char[] b0 = {'A'};
        Oblig1.rotasjon(b, 0);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: b) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        Oblig1.rotasjon(b, 1);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: c) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        Oblig1.rotasjon(b, -1);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: d) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        char[] c = {'A', 'B'};
        char[] c0 = {'B', 'A'};
        Oblig1.rotasjon(c, 1);

        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 6: e) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        c = new char[]{'A', 'B'};

        Oblig1.rotasjon(c, -1);
        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 6: f) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'G', 'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F'};

        Oblig1.rotasjon(d, 4);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 6: g) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        d = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(d, -6);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 6: h) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        char[] x = new char[100_000];
        long tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 99_999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: i) Metoden "
                    + "er for ineffektiv. Må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 199_999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: j) Metoden "
                    + "er for ineffektiv. Må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 50_000);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: k) Metoden "
                    + "er for ineffektiv. Må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, -40_000);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: l) Metoden "
                    + "er for ineffektiv. Må forbedres!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 6");

         */


    }

    @org.junit.jupiter.api.Test
    void flett() {
        /*
        assertEquals(true, false, "Implementer flett og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        /*
        assertEquals(true, false, "Implementer indekssortering og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        /*
        assertEquals(true, false, "Implementer tredjeMin og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        /*
        assertEquals(true, false, "Implementer bokstavNr og denne testen");

         */
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        /*
        assertEquals(true, false, "Implementer inneholdt og denne testen");

         */
    }
}