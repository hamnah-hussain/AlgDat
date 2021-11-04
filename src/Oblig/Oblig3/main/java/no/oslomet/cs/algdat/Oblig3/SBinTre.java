package Oblig.Oblig3.main.java.no.oslomet.cs.algdat.Oblig3;

import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    //Oppgave 1
    //Hentet fra programkoden 5.2.3 a) fra kompendiet
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null) {       // fortsetter til p er ute av treet
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<T>(verdi, q); //oppretter en ny node, her endringen ble gjort

        if (q == null) {
            rot = p; // p blir rotnode
        } else if (cmp < 0) {
            q.venstre = p; // venstre barn til q
        } else {
            q.høyre = p; // høyre barn til q
        }

        antall++; // én verdi mer i treet
        endringer++; //en endring blir gjort til treet
        return true;
    }

    //Oppgave 6
    //Hentet fra 5.2.8 d) i kompendiet
    public boolean fjern(T verdi) {
        if (verdi == null) return false;  // treet har ingen nullverdier

        Node<T> p = rot, q = null;   // q skal være forelder til p

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
            else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
            else break;    // den søkte verdien ligger i p
        }
        if (p == null) return false;   // finner ikke verdi

        if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
            if(b != null){
                b.forelder = q;
            }
            if (p == rot) rot = b;
            else if (p == q.venstre) q.venstre = b;
            else q.høyre = b;
        }
        else  // Tilfelle 3)
        {
            Node<T> s = p, r = p.høyre;   // finner neste i inorden
            while (r.venstre != null)
            {
                s = r;    // s er forelder til r
                r = r.venstre;
            }

            p.verdi = r.verdi;   // kopierer verdien i r til p

            if (s != p) s.venstre = r.høyre;
            else s.høyre = r.høyre;
        }

        antall--;   // det er nå én node mindre i treet
        return true;
    }

    //Oppgave 6
    //Hentet fra oppagve 3 avsnitt 5.2.8 fra kompendiet
    public int fjernAlle(T verdi) {
        if(tom()){ //returnerer null om den er tom
            return 0;
        }

        int fjernetAntall = 0; //teller antallet som blir fjernet

        while (fjern(verdi)){ //fjerner en verdi om gangen
            fjernetAntall++; //øker etterhvert som verdiene slettes
        }
        return fjernetAntall; //returnerer antallet som er fjernet
    }

    //Oppgave 2
    //Hentet fra oppgave 2 i avsnitt 5.2.6 i kompendiet
    public int antall(T verdi) {
        Node<T> p = rot; //p starter i roten
        int antallVerdier = 0; //teller antall verdier i treet

        while (p != null) { //Mens p ikke er null
            int sam = comp.compare(verdi, p.verdi); //sammelikner verdiene
            if (sam < 0) { //hvis verdi er mindre enn p
                p = p.venstre; //går til venstre
            } else {
                p = p.høyre; //går til høyre
                if (sam == 0) { //hvis verdiene er like
                    antallVerdier++; //antall verdier  øker
                }
            }
        }
        return antallVerdier; //returnerer verdien
    }

    //Oppgave 6
    //Hentet fra oppgave 8 avsnitt 5.1.7 i kompenidet
    public void nullstill() { //Rekursiv metode

        if (!tom()){
            nullstill(rot);// nullstiller
        }
        rot = null;//setter roten lik null
        antall = 0;//setter antall lik 0 
    }

    private void nullstill(Node<T> p) {

        if (p.venstre != null) {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.høyre != null) {
            nullstill(p.høyre);        // høyre subtre
            p.høyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }

    //Oppgave 3
    //Hentet fra programkoden 5.1.7 h) i kompendiet
    private static <T> Node<T> førstePostorden(Node<T> p) {
        while (true) {
            if (p.venstre != null) { //hvis den har venstre barn
                p = p.venstre;
            }
            else if (p.høyre != null) { //hvis den har høyre barn
                p = p.høyre;
            }
            else {
                return p; //returner p
            }
        }
    }

    //Oppgave 3
    //Utgangspunkt i 5.1.7 og 5.1.15 i kompendiet
    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node<T> q = p.forelder; //vi setter q lik p sin forelder

        if(q != null) {//hvis forelderen ikke er null
            if (p == q.høyre) {//hvis p er høyre barnet til q
                return q; //Returner q som neste
            } else if (p == q.venstre) {//hvis p er venstre barnet til q
                if (q.høyre == null) { //p er enebarn
                    return q; //returner q som neste
                } else { //hvis den ikke er enebarn
                    p = q.høyre; //vi setter p lik høyrebarne til q
                    while (p.venstre != null || p.høyre != null) { //hvis en av de ikke er null, finn ut hvilken
                        if (p.venstre != null) {
                            p = p.venstre;
                        } else{
                            p = p.høyre;
                        }
                    }
                    return p;
                }
            }
        }
        else{ //hvis den ikke har en forelder
            return null;
        }
        return p;
    }

    //Oppgave 4
    //Utgangspunkt i 5.1.7 pg 5.1.10 i kompendiet
    public void postorden(Oppgave<? super T> oppgave) { //iterativ
        Node<T> p = rot; //starter ved roten
        p = førstePostorden(p); //finne første p

        while (p!=null){ //mens p ikke er null
            oppgave.utførOppgave(p.verdi); //utfør oppgavven
            p=nestePostorden(p); //gi oss neste
        }
    }


    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);//starter ved roten
    }

    //Oppgave 4
    //Hentet fra oppgave 7 i avsnitt 5.1.7
    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) { //rekursiv
       if(p.venstre != null){ //sjekker p har venstre barn
           postordenRecursive(p.venstre,oppgave);//går gjennnom igjen med p.venstre som p
       }
       if(p.høyre != null){ //sjekker p har høyrebarn
           postordenRecursive(p.høyre,oppgave);//går gjennom igjen med p.høyre som p
       }
       oppgave.utførOppgave(p.verdi);//returnerer verdien til p
    }

    //Oppgave 5
    //https://www.softwaretestinghelp.com/java-queue-interface/
    //Utgangspunkt fra 5.1.6 og hentet fra programkode 5.1.6 d) fra kompendiet, og fra nettsiden over
    public ArrayList<T> serialize() {
        if(tom()){ //sjekker om den er tom
            return null;
        }
        ArrayList<T> liste = new ArrayList<>(); //lager en liste den skal gå inn i
        Queue<Node<T>> kø = new ArrayDeque<> (); //lager en kø
        kø.add(rot); //legger til roten først

        while(!kø.isEmpty()) { //mens den ikke er tom
            Node<T> p = kø.remove();//tar ut første index av køen
            liste.add(p.verdi); //legger til verdien i liste

            if (p.venstre != null) {//hvis p har venstre barn
                kø.add(p.venstre);//legg til
            }
            if (p.høyre != null) {//hvis p har høyre barn
                kø.add(p.høyre);//legg til
            }
        }
        return liste;//print ut listen
    }

    //Oppgave 5
    //Utgangspunkt i eksempelet som er i oblig teksten
    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        SBinTre<K> tree = new SBinTre<>(c);//lager et binærtre

        for (K verdi : data){//legger en og en verdi inn i treet fra serialize liste
            tree.leggInn(verdi);
        }

        return tree;//returner treet
    }


} // ObligSBinTre
