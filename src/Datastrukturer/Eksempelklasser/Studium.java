package Datastrukturer.Eksempelklasser;

public enum Studium  // legges under package eksempelklasser
    {
        Data ("Ingeniørfag - data"),         // enumkonstanten Data
        IT ("Informasjonsteknologi"),        // enumkonstanten IT
        Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
        Elektro("Ingeniørfag - elektronikk og informasjonsteknologi"), // enumkonstanten Elektro
        Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne;

        private final String fulltnavn;      // instansvariabel
        private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

        public String toString() { return fulltnavn; }
    }
