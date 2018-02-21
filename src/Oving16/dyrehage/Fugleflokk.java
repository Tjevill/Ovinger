package Oving16.dyrehage;

public class Fugleflokk extends Dyregruppe {

    private final int gjennomsnittligVekt;
    private final String svommer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
                      String gruppenavn, int antIndivider, int gjennomsnittligLengde, String kanDeleAkvarium,
                      int gjennomsnittligVekt, String svommer){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse,
                gruppenavn, antIndivider);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public int getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public String getSvommer() {
        return svommer;
    }

    public String toString(){
        return super.toString()+"\nGjennomsnittlig vekt: "+getGjennomsnittligVekt()+"\nSvømmer: "+getSvommer();
    }
}
