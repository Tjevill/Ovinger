package Oving16.dyrehage;

public class Fiskestim extends Dyregruppe {

    private final int gjennomsnittligLengde;
    private final String kanDeleAkvarium;

    public Fiskestim(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
                     String gruppenavn, int antIndivider, int gjennomsnittligLengde, String kanDeleAkvarium){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse,
                gruppenavn, antIndivider);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public int getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public String getKanDeleAkvarium() {
        return kanDeleAkvarium;
    }

    public String toString(){
        return super.toString()+"\nGjennomsnittlig lengde: "+getGjennomsnittligLengde()+"\nKan dele akvarium: "+getKanDeleAkvarium();
    }

}
