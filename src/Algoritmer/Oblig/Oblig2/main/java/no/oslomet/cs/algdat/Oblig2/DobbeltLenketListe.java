package Algoritmer.Oblig.Oblig2.main.java.no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    //hjelpemetode
    private Node<T> finnNode(int indeks) {
        Node<T> returnNode;
        if (indeks < antall / 2) {
            returnNode = hode;
            for (int i = 0; i < indeks; i++) {
                returnNode = returnNode.neste;
            }
        } else { //error
            returnNode = hale;
            for (int i = 1; i < (antall - indeks); i++) {
                returnNode = returnNode.forrige;
            }

        }
        return returnNode;

    }


    public DobbeltLenketListe() {
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a);
        Node<T> itr = new Node(null);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                this.antall++;
                this.endringer++;
                if (this.hode == null) {
                    this.hode = new Node<T>(a[i]);
                    itr = hode;

                } else {
                    Node<T> n = new Node<T>(a[i], itr, null);
                    itr.neste = n;
                    itr = itr.neste;
                }
            }
        }
        if (itr.verdi != null) {
            this.hale = itr;
        }
    }

    private void fratilKontroll(int antall, int fra, int til) {
        if (fra < 0) {
            throw new IndexOutOfBoundsException("ULOVLIG");
        }

        if (til > antall) {
            throw new IndexOutOfBoundsException("");
        }
        if(fra > til){
            throw new IllegalArgumentException("");
        }
    }

    public Liste<T> subliste(int fra, int til) {
        endringer=0;
        fratilKontroll(antall,fra,til);
        DobbeltLenketListe<T> subliste= new DobbeltLenketListe<>();

        for(int i=fra; i< til; i++){
            subliste.leggInn(hent(i));
        }
        return subliste;
    }



    @Override
    public int antall() {
        antall = 0;
        for (Node T = hode; T != null; T = T.neste) {
            antall++;
        }
        return antall;
    }

    @Override
    public boolean tom() {
        if (antall == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        if (verdi == null){
            Objects.requireNonNull(verdi, "Tabellen a er null!");
        }
        else {
            Node q = new Node(verdi);

            if ( (hode == null) && (hale == null) ) {
                hode = q;
                hale = q;
                antall++;
            }
            else {
                Node p = hale;
                hale = q;
                q.forrige = p;
                p.neste = q;
                antall++;
            }
        }
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier ");
        indeksKontroll(indeks, true);

        if (antall == 0) {
            hode = hale= new Node<>(verdi,null,null);
        }
        else if (indeks == 0) {
            hode = hode.forrige=new Node<>(verdi, null, hode);
        }
        else if (indeks == antall) {
            hale=hale.neste=new Node<>(verdi,hale,null);
        } else{
           Node <T> p=finnNode(indeks);
           p.forrige=p.forrige.neste=new Node<>(verdi,p.forrige,p);
        }
        endringer++;
        antall++;

        }


    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi)!=-1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false); // antall er ulovlig
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (hent(i).equals(verdi)){

                return i;
        }
    }
                return -1;
    }


    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "null er ulovlig ");
        indeksKontroll(indeks, false); //indeks = antall er ulovlig

        Node <T> gammelNode= finnNode(indeks);
        T gammelverdi= gammelNode.verdi;

        gammelNode.verdi=nyverdi;
        endringer++;
        return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (antall == 0) {
            return false;
        }
        Node<T> node = hode;
        boolean fjernet = false;

        if (hode.verdi.equals(verdi)) {
            if (node.neste != null) {
                node.neste.forrige = null;
                hode = node.neste;
            } else {
                hode = null;
                hale = null;
            }
            fjernet = true;
        }
        else if (hale.verdi.equals(verdi)) {
            node = hale;
            node.forrige.neste = null;
            hale = node.forrige;
            fjernet = true;
        }
        else {
            while (node.neste != null) {
                node = node.neste;
                if (node.verdi.equals(verdi)) {
                    node.forrige.neste = node.neste;
                    node.neste.forrige = node.forrige;
                    fjernet = true;
                }
            }
        }
        if (fjernet) {
            antall--;
            endringer++;
        }
        return fjernet;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);
        Node<T> node = hode;
        T returVerdi;

        if (indeks == 0) {
            returVerdi = node.verdi;
            if (node.neste != null) {
                hode = node.neste;
                hode.forrige = null;
            } else {
                hale = null;
                hode = null;
            }
        }

        else if (indeks == antall-1) {
            node = hale;
            returVerdi = node.verdi;
            hale = node.forrige;
            hale.neste = null;
        }

        else {
            for (int i = 0; i < indeks; i++) {
                node = node.neste;
            }
            returVerdi = node.verdi;

            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }

        antall--;
        endringer++;
        return returVerdi;
    }

    @Override
    public void nullstill() {
        for (Node<T> node = hode; node != null;) {
            Node<T> nesteNode = node.neste;
            node.verdi = null;
            node.neste = null;
            node.forrige = null;
            node = nesteNode;
        }
        hode = null; hale = null;
        antall = 0;
        endringer++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node T = hode; T != null; T = T.neste){
            sb.append(T.verdi);
            if (T != hale){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String omvendtString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node T = hale; T != null; T = T.forrige){
            sb.append(T.verdi);
            if (T != hode){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            Node<T> node = hode;
            for (int i = 0; node != null; i++) {
                if (i == indeks) {
                    denne = node;
                }
                node = node.neste;
            }
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T verdi = denne.verdi;
            denne = denne.neste;
            fjernOK = true;
            return verdi;
        }

        @Override
        public void remove() {
            if(!fjernOK){
                throw new IllegalStateException("Kan ikke fjerne akkurat nå!"); //Metoden kan ikke kalles på
            }
            if(iteratorendringer != endringer){
                throw new ConcurrentModificationException("Listen er forandret!"); //iteratorendring og endring er annerledes
            }
            fjernOK = false; //Kan ikke kalle metoden på nytt

            if(antall == 1){ //Hvis det kun er en node
                hode = null; //Hode skal bli null
                hale = null; //Hale skal bli null
            }
            else if(denne == null){ //Siste fjernes
                hale = hale.forrige; //Hale sin forrige være nye halen
                hale.neste = null; //Hale neste blir null
            }
            else if(denne.forrige == hode){ //Første fjernes
                hode = hode.neste; //Hode blir hode neste
                hode.forrige = null; //Hode forrige blir null
            }
            else{ //Fjerne en node i midten
                denne.forrige.neste = denne.neste; //Peker på den foran
                denne.neste.forrige = denne.forrige; //Peker på den bak
            }

            antall--; //en verdi blir fjernet
            endringer++; //en endring blir gjort
            iteratorendringer++; // en iterator endring blir gjort
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        if(liste.tom()){ //Hvis listen er tom
            return;
        }
        else{ //Hvis listen har tall
            for(int i=0;i< liste.antall();i++){ //Går foran fra
                for(int j=0;j>liste.antall()-1;j--){ //Går bak ifra
                    T I = liste.hent(i);
                    T J = liste.hent(j);
                    if((c.compare(I, J))<0){//sammenlikner
                        T temp = I;
                        //oppdaterer
                        liste.oppdater(i, J);
                        liste.oppdater(j, temp);
                    }
                }
            }
        }
    }

} // class DobbeltLenketListe


