package Oving1;
import java.util.*;

public class Restaurant{

    private String navn;
    private int etabAar;
    private Bord bord;
    Calendar l = new GregorianCalendar();
    int age = l.get(l.YEAR);

    public Restaurant(String navn, int etabAar, Bord bord){

        this.navn = navn;
        this.etabAar = etabAar;
        this.bord = bord;
    }
    public String getNavn(){
        return navn;
    }
    public void setNavn(String nyttNavn){
        this.navn = nyttNavn;
    }
    public void setEtabAar(int etabAar){
        this.etabAar = etabAar;
    }
    public int getEtabAar(){
        return etabAar;
    }
    public int getAlder(){
        int alder = age-etabAar;
        return alder;
    }
    public int getLedigeBord(){
        return bord.getLedigBord();
    }
    public int getOptBord(){
        return bord.getOptBord();
    }
    public boolean resBord(String navn){
        return bord.reserverBord(navn);
    }
    public int getBordPerson(String navn){
        return bord.getBordPerson(navn);
    }
    public void tomBord(int index){
        bord.fjernReservasjon(index);
    }
    public String skrivUtBord(){
        return bord.skrivUtBord();
    }
    public String toString(){
        return "Navn: "+getNavn()+"\nEtableringsår: "+getEtabAar()+"\nRestauranten er "+getAlder()+" år.";
    }
}