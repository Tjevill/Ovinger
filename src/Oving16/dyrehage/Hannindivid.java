package Oving16.dyrehage;

public class Hannindivid extends Individ {


    private int antKull;

    public Hannindivid(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, String navn, int fDato, String hanndyr, String farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, hanndyr, farlig);
        this.antKull = 0;
    }

    public int getAntKull() {
        return antKull;
    }

    public void leggTilKull(int antall){
    }
}
