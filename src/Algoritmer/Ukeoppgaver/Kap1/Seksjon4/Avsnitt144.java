package Algoritmer.Ukeoppgaver.Kap1.Seksjon4;

public class Avsnitt144 {
    /*1. Kopier class Heltall fra Programkode 1.4.4 a) over til deg selv. Opprett mappen (package) eksempelklasser og
    legg den der.
 	a) Lag og kjør et program med Programkode 1.4.4 c).
 	b) Bruk Programkode 1.4.4 b) i compareTo-metoden. Sjekk at alt virker som før!
 	c) La  return verdi - h.verdi;  være kode i compareTo-metoden. Matematisk sett blir det korrekt. Sjekk at alt
 	virker som før. Det er imidlertid et problem her. Hva er det?
 	d) Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
   System.out.println(x.compareTo(y) + "  " + x.equals(y));
   Lag et program som inneholder koden over. Hva blir utskriften? Kommenter så vekk equals-metoden i class Heltall.
   Da vil det bli den versjonen av equals som arves fra class Object, som brukes. Hva blir nå utskriften? Slå opp i
   kildekoden til class Object og se hvordan metoden equals er kodet der.
 	e) Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
   System.out.println(x.hashCode() + "  " + y.hashCode());
   Lag et program som inneholder koden over. Hva blir utskriften? Kommenter så vekk hashCode-metoden i class Heltall.
   Da vil det bli den versjonen av hashCode som arves fra class Object, som brukes. Hva blir nå utskriften? Slå opp i
   kildekoden til class Object og se hva som står der om metoden hashCode.
   */

/*  2.	Kopier klassen Person fra Programkode 1.4.4 d) over til deg. Legg den under package eksempelklasser:
 	a) Legg inn flere personer i Person-tabellen i Programkode 1.4.4 e).
 	b) Kjør Programkode 1.4.4 e) etter at du har gjort som i a).
 	c) Bruk sort-metoden fra class Arrays i Programkode 1.4.4 e).
 	d) Legg inn kode i konstruktøren slik at det kastes en NullPointerException hvis fornavn eller etternavn er null. Ta med en tekst som forteller hvilket navn som er null.
 	e) Lag en mer direkte versjon av metoden equals(), dvs. uten å bruke compareTo(). Bruk også getClass() != o.getClass() istedenfor !(o instanceof Person). Men da må det først være kode som returnerer false hvis o er null. Hvis ikke, vil o.getClass() kaste en NullPointerException.
 	f) Lag metoden public boolean equals(Person p). Da trengs ingen typesjekking.
 	g) Metoden hashCode() i klassen Person kan kodes på mange måter. Hvis equals() er kodet, men ikke hashCode(), vil f.eks. NetBeans og Eclipse si ifra og samtidig komme med forslag om hvordan hashCode() skal kodes. Sjekk dette. Obs: I NetBeans er dette en del av standardoppsettet. I Eclipse må du selv sette det som en opsjon. Men du får tilbudet i menyvalget Source. Hash-teknikk blir tatt opp mer grundig i Kapittel 6.
 	h) I metoden toString i klassen Person skjøtes fornavn, et mellomrom og etternavn sammen. Dette kan også gjøres ved hjelp av metoden join i klassen String. Prøv på det!
 	i) Legg Programkode 1.4.4 f) bakerst i Programkode 1.4.4 e). Kjør programmet!
 	j) Programkode 1.4.4 f) inneholder tre programlinjer. Gjør det om slik at det blir kun én programlinje.*/
}
