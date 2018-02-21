package Oving16.dyrehage;

import java.text.ParseException;

public abstract class Dyr {

    private final String norskNavn;
    private final String latNavn;
    private final String latFamilie;
    private final int ankommetDato;
    private String adresse;

    public Dyr(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse){

        this.norskNavn = norskNavn;
        this.latNavn = latNavn;
        this.latFamilie = latFamilie;
        this.ankommetDato = ankommetDato;
        this.adresse = adresse;
    }

    public String getNorskNavn() {
        return norskNavn;
    }

    public String getLatNavn() {
        return latNavn;
    }

    public String getLatFamilie() {
        return latFamilie;
    }

    public int getAnkommetDato() {
        return ankommetDato;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString(){
        return "Norsk navn: "+getNorskNavn() +"\nLatinsk navn: "+getLatNavn()+"\nLatinsk familie: "+getLatFamilie()
                +"\nAnkommet dato: "+getAnkommetDato()+"\nAdresse: "+getAdresse();
    }
}
