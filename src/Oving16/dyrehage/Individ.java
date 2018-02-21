package Oving16.dyrehage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Implementerer interfacet SkandinaviskeRovdyr.java
public abstract class Individ extends Dyr implements SkandinaviskeRovdyr {

    private final String navn;
    private final int fDato;
    private final String hanndyr;
    private final String farlig;

    public Individ(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
                   String navn, int fDato, String hanndyr, String farlig){

        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    public String getNavn() {
        return navn;
    }

    public int getfDato() {
        return fDato;
    }

    public String getHanndyr() {
        return hanndyr;
    }

    public String getFarlig() {
        return farlig;
    }
    //Tilhører interface
    public String skrivUtInfo()throws ParseException{
        return toString()+"\n"+getAlder()+" år gammel.\n";
    }

    //Fødselsdato = DDMMYYYY"
    //Tilhører interface
    public int getAlder()throws ParseException{

        int alder = getfDato();
        String fDato = ""+alder;
        SimpleDateFormat df = new SimpleDateFormat("DDMMYYYY");
        Date fodelsdato = df.parse(fDato);

        alder = alderKalk(fodelsdato);

        if(alder<0){
            throw new IllegalArgumentException("Alder skrives inn som: DDMMYYYY");
        }

        return alder;
    }

    //Hjelpemetode til getAlder()
    //Finner årsdifferanse.
    private int alderKalk(Date fodselaar){

        Calendar fodsel = Calendar.getInstance();
        fodsel.setTime(fodselaar);
        Calendar idag = Calendar.getInstance();

        int differanse = idag.get(Calendar.YEAR) - fodsel.get(Calendar.YEAR);

        if(idag.get(Calendar.MONTH) < fodsel.get(Calendar.MONTH)){
            differanse--;
        }
        else{
            if(idag.get(Calendar.MONTH) == fodsel.get(Calendar.MONTH)
                    && idag.get(Calendar.DAY_OF_MONTH)<fodsel.get(Calendar.DAY_OF_MONTH)){
                differanse--;
            }
        }

        return differanse;
    }

    //Tilhører interface
    public void flytt(String nyAdresse){
        super.setAdresse(nyAdresse);
    }

    //Tilhører interface
    //Override i Hunnindivid.
    public int getAntKull(){
        return 0;
    }

    //Tilhører interface
    //Override i Hunnindivid.
    public void leggTilNyttKull() {
    }

    public String toString() {
        return super.toString()+"\nNavn: "+getNavn()+"\nFødselsdato: "+getfDato()+"\nKjønn: "+getHanndyr()
                    +"\nFarlig: "+getFarlig()+"\n";
    }
}
