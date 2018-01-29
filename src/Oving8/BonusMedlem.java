package Oving8;

import java.time.LocalDate;
import java.time.Period;

public class BonusMedlem {

    private final int medlNr;
    private final Personalia pers;
    private final LocalDate innmeldtDato;
    private int poeng = 0;

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato){

        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }

    public int getMedlNr() {
        return medlNr;
    }

    public Personalia getPers() {
        return pers;
    }

    public LocalDate getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }

    public void setPoeng(int poeng) {
        this.poeng += poeng;
    }

    public String toString(){
        return "Medlemsnr: "+getMedlNr()+"\nPersonalia: "+getPers()+"\nInnmeldingsdato: "+getInnmeldtDato()+"\nPoeng: "+getPoeng();
    }

    public int finnKvalPoeng(LocalDate dato){

        int dagerMellom = Period.between(getInnmeldtDato(), dato).getYears();

        if (dagerMellom<1){
            return poeng;
        }
        return 0;
    }

    public boolean okPassord(String passord){
        return pers.okPassord(passord);
    }

    public boolean registrerPoeng(int poeng){
        if(poeng<0){
            return false;
        }
        setPoeng(poeng);
        return true;
    }
}
