package Oblig.Oblig1.main.java.no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        // Marks the last index in an array
        int index = a.length - 1;

        try {
            //If the array is empty, throw an exception
            if (a.length < 1) {
                throw new NoSuchElementException("For liten array");
            } else {
                //I chose to use a modified version of bubblesort

                //Outer loop: counts the number of cards we have sorted so far
                for (int i = 0; i < a.length - 1; i++) {
                    //Inner loop: loops from end of the deck and forward through the
                    //unsorted cards, and bubbles up
                    for (int j = i; j < i + 1; j++) {
                        //Swaps the cards if they are out of order
                        if (a[j] > a[j + 1]) {
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                        }
                    }
                }
                //Returns the last index in an array, which is the biggest number.
                return a[index];
            }
        }
        // Catch exception
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("For liten array");
        }
    }

    public static int ombyttinger(int[] a) {

        // Variabel that will count the number of "Switches" that occurs
        int AntallOmbyttinger = 0;

        try {
            //If the array is empty, throw an exception
            if (a.length < 1) {
                throw new NoSuchElementException("For liten array");
            } else {
                //Chose to use a modified version of bubblesort

                //Outer loop: counts the number of cards we have sorted so far
                for (int i = 0; i < a.length - 1; i++) {
                    //Inner loop: loops from start of the deck and forward through the
                    //unsorted cards, and bubbles up
                    for (int j = i; j < i + 1; j++) {
                        //Swap the cards if they are out of order
                        if (a[j] > a[j + 1]) {
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                            // Adds ammount of "Switches" with 1
                            AntallOmbyttinger++;
                        }
                    }
                }
                //Returns the amount of switches that occur
                return AntallOmbyttinger;
            }
        }
        //Catch exception
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("For liten array");
        }
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        /*Testen for å se om den er i stigende rekkefølge er
         hentet fra kompendiet (Programkode 1.3.2 c)
        https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#1.3.2)*/

        for (int j = 1; j < a.length; j++) { //Sjekker om arrayen er sortert i stigende rekkefølge
            if (a[j - 1] > a[j]) {
                throw new IllegalStateException("Denne arrayen er ikke sortert i stigende rekkefølge");
            }
        }
        int counter = 1; //Teller første verdi
        if (a.length == 0) {//Hvis arrayen er tom skal det vises 0
            return 0;
        } else if (a.length > 0) {
            int num = a[0]; //Starter fra 0 indeks

            /*Den sjekker om num verdien er den samme som den i indeksen
             * Hvis den er ulik vil den telle det og sette det som det som det nye tallet.*/

            for (int i = 1; i < a.length; i++) {
                if (a[i] != num) {
                    counter++;
                    num = a[i];
                }
            }
        }
        return counter;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        //Sjekker om a.length er mindre enn 0. Da returnere den 0
        if (a.length < 1) {
            return 0;
        }
        int counter = 1;
        int j;
        for (int i = 1; i < a.length; i++) {
            for (j = 0; j < i; j++)
                if (a[i] == a[j])
                    break;
            if (i == j)
                counter++;
        }
        return counter;
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;


    }


    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        if (a.length <= 0) {
            return;
        }

        int v = 0;
        int h = a.length - 1;

        /*
            Går gjennom arrayet engang for å partisjonere
            Arrayet i to deler. Odetall på venstre, partall
            På høyre
        */
        while (v < h) {
            // Letter etter et partall fra venstre side
            while (v <= h && a[v] % 2 != 0) {
                v++;
            }
            // Letter etter et oddetall fra høyre side
            while (v <= h && a[h] % 2 == 0) {
                h--;
            }
            /*
                Hvis jeg finner et partall på venstre side og et odetall på høyre side
                Bytter jeg plass på dem. Når if-statementen er feil så breaker jeg ut av
                While loopen sånn at v har skille verdien.
            */
            if (v < h) {
                bytt(a, v, h);
            } else
                break;
        }


        /*
            Implementerte en QuickSort metode.
            Brukte den til å sortere de to
            delene hver for seg
        */
        KvikkSortering(a, 0, v - 1);
        KvikkSortering(a, v, a.length - 1);

    }

    public static int partisjon(int[] a, int v, int h) {
        int pivot = a[h];
        int i = v - 1;

        for (int j = v; j < h; j++) {
            if (a[j] < pivot) {
                i++;
                bytt(a, i, j);
            }
        }
        bytt(a, i + 1, h);
        return i + 1;
    }

    public static void KvikkSortering(int[] a, int v, int h) {
        if (v >= h) {
            return;
        }
        int p = partisjon(a, v, h);
        KvikkSortering(a, v, p - 1);
        KvikkSortering(a, p + 1, h);
    }


    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        try {
            // Rotates every value one place to the right
            for (int i = 0; i < 1; i++) {
                //Variable for last value of an array
                char last;

                //Stores the last value of array
                last = a[a.length - 1];

                for (int j = a.length - 1; j > 0; j--) {
                    //Shift element of array by one
                    a[j] = a[j - 1];
                }

                //Last element of array will be added to the start of array.
                a[0] = last;
            }
        } catch (Exception e) {

        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static int gcd(int a, int b) {        // Euklids algoritme
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void rotasjon(char[] a, int k) {
        try {
            // Lengden til arrayet
            int n = a.length;

            // Sjekke om arrayet skal roteres mot høyre eller venstre
            if ((k %= n) < 0) k += n;

            // Finne gcd ved hjelp av metoden gcd
            // for å gjøre koden mer effektiv
            int s = gcd(n, k);

            for (int l = 0; l < s; l++) {
                char verdi = a[l];

                for (int i = l - k, j = l; i != l; i -= k) {
                    if (i < 0) i += n;
                    a[j] = a[i];
                    j = i;
                }
                a[l + k] = verdi;
            }
        } catch (Exception e) {

        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)

    //Det er fra oppgave 1b til 1.3.11 om fletting
    //https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit1311.html

    public static String flett(String s, String t) {
        int k = Math.min(s.length(), t.length());//Minst hvor lang den må være den må være
        StringBuilder sb = new StringBuilder();//Bygge en ny string
        for (int i = 0; i < k; i++) {//Gå gjennom begge stringene
            sb.append(s.charAt(i)).append(t.charAt(i));//Fletter stringene sammen annenhver
        }
        sb.append(s.substring(k)).append(t.substring(k));//Legger til det som blir igjen
        return sb.toString();//Printer ut resultatet
    }

    /// 7b)
    public static String flett(String... s) {
        int count;
        String result = "";
        for (int i = 0;; i++) {
            count = s.length;
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() > i) {
                    result += s[j].charAt(i);
                    count--;
                }
            }
            if (count == s.length)
                break;
        }
        return result;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

        int[] index = new int[a.length]; //Indeks array
        int[] kopi = new int[a.length]; //Kopi av a[]

        for (int i = 0; i < a.length; i++) {//Kopierer innholdet fra a til kopi
            kopi[i] = a[i];
        }

        //Bobblesort
        for (int i = 0; i < a.length-1; i++) { //Går gjennom så lengden
            for(int j=a.length-1; j>i;j--){ //Går gjennom kopi
                if (kopi[j] < kopi[j-1]) { //Bytter
                    bytt(kopi, j, j-1);
                }
            }
        }

        for(int i=0;i<a.length;i++){ //Går gjennom lengden
            for(int j =0;j<kopi.length;j++){ //Går gjennom kopi
                if (kopi[i] == a[j]) { //Finner samme verdi i arrayet a
                    index[i] = j; //Setter indeksen til a verdien inn i index
                }
            }
        }
        return index;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        // Sjkker om størrelsen er gyldig
        if (a.length < 3) {
            throw new NoSuchElementException("Denne tabellen har ikke nok verdier!");
        }
        /*
            Lager en copi de tre første indeksene av arrayet
            Bruker de i indeksortering for å få de tre første
            indeksene sortert.
         */
        int[] copy = new int[3];
        System.arraycopy(a, 0, copy, 0, 3);
        int[] start  = indekssortering(copy);
        int m = start[0];
        int nm = start[1];
        int nnm = start[2];


        /*
            Bruker samme metode som i kompendiet 1.2.5 a)
            La til et par ekstra if settninger fordi det er
            tre verdier og ikke to
         */
        for (int i = 3; i<a.length; i++) {
            if (a[i] < a[nnm]) {
                if (a[i] < a[nm]) {
                    if (a[i] < a[m]) {
                       nnm = nm;
                       nm = m;
                       m = i;
                    } else {
                        nnm = nm;
                        nm = i;
                    }
                } else {
                    nnm = i;
                }
            }
        }
        return new int[] {m, nm, nnm};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NoSuchElementException();

    }

    public static boolean inneholdt(String a, String b) {

        //Gjorde om en bokstav til et heltall. Da kan man bruke et array til å telle opp de forskjellige bokstavene
        int[] a1 = new int[256];
        int[] b1 = new int[256];

        //Bruker toCharArray til å konverte streng til et char array.
    char []stringaTilArray = a.toCharArray();
    char []stringbTilArray = b.toCharArray();

//for-alle-løkke for å traverese en hel datastruktur.
        for (char i : stringaTilArray) a1[i]++;
        for (char i : stringbTilArray) b1[i]++;


        for (int i = 0; i < a1.length; i++) {
            if (a1[i] > 0)
                if (a1[i] > b1[i]) {
                    return false;
                }
        }
        return true;
    }


}



 // Oblig1
