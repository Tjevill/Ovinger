package Oving16.dyrehage;

public class Rovdyrfabrikk{

    //Brunbjørn - Finals
    private final String norskNavnBB = "Brunbjørn";
    private final String latBB = "Ursus arctos";
    private final String famNavnBB = "Ursidae";
    private final String binne = "Binne";
    private final String hanBjorn = "Hann";

    //Ulv - Finals
    private final String norskNavnUlv = "Ulv";
    private final String latUlv = "Canis lupus";
    private final String famUlv = "Canidae";
    private final String hunUlv = "Tispe";
    private final String hanUlv = "Hann";


    //Farlig - Finals
    private final String erFarlig = "Ja";
    private final String ikkeFarlig = "Nei";

    //Brunbjørn - Binne
    public SkandinaviskeRovdyr nyBinne(int ankommetDato, String adresse, String navn, int fDato, int antKull){

       return new Hunnindivid(norskNavnBB,latBB,famNavnBB,ankommetDato,adresse,navn,fDato,binne,erFarlig, antKull);
    }

    //Brunbjørn - Han
    public SkandinaviskeRovdyr nyHannbjorn(int ankommetDato, String adresse, String navn, int fDato){

        return new Hannindivid(norskNavnBB, latBB, famNavnBB, ankommetDato, adresse, navn, fDato, hanBjorn, erFarlig);
    }

    //Ulv - Tispe
    public SkandinaviskeRovdyr nyUlvetispe(int ankommetDato, String adresse, String navn, int fDato, int antKull){

        return new Hunnindivid(norskNavnUlv, latUlv, famUlv, ankommetDato, adresse, navn, fDato, hunUlv, erFarlig, antKull);
    }

    //Ulv - Han
    public SkandinaviskeRovdyr nyUlvehann(int ankommetDato, String adresse, String navn, int fDato){

        return new Hannindivid(norskNavnUlv, latUlv, famUlv, ankommetDato, adresse, navn, fDato, hanUlv, erFarlig);
    }
}
