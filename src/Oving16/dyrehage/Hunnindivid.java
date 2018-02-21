package Oving16.dyrehage;

public class Hunnindivid extends Individ {

    private int antKull;

    public Hunnindivid(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, String navn, int fDato, String hanndyr, String farlig, int antKull) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, hanndyr, farlig);
        this.antKull = antKull;
    }

    @Override
    public int getAntKull() {
        return antKull;
    }

    public void setAntKull(int antKull) {
        this.antKull = antKull;
    }

    public void leggTilKull(int antall){
        this.antKull+=antall;
    }

    @Override
    public void leggTilNyttKull() {
        this.antKull+=1;
    }

    @Override
    public String toString() {
        return super.toString()+"Antall kull: "+getAntKull();
    }
}
