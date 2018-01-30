package Oving8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Medlemsarkiv {

    ArrayList<BonusMedlem> bonusMedlem = new ArrayList<>();

    public Medlemsarkiv(){

    }

    public int nyMedlem(Personalia pers, LocalDate innmeld){

        BasicMedlem b1 = new BasicMedlem(finnLedigNr(), pers, innmeld);
        bonusMedlem.add(b1);
        return b1.getMedlNr();
    }

    private int finnLedigNr(){
        Random tilfTall = new Random();
        int en = tilfTall.nextInt(10000);

        for (int i = 0; i < bonusMedlem.size(); i++) {
            en = tilfTall.nextInt(10000);
            for (int j = 0; j < bonusMedlem.size(); j++) {
                if(bonusMedlem.get(j).getMedlNr()==en) {
                    en = tilfTall.nextInt(10000);
                    j = 0;
                }
            }
            if(bonusMedlem.get(i).getMedlNr()!=en){
                return en;
            }
            en = tilfTall.nextInt(10000);
        }
        return en;
    }

    public int finnPoeng(int medlemsnummer, String passord){
        for (int i = 0; i < bonusMedlem.size(); i++) {
            if(bonusMedlem.get(i).getMedlNr() == medlemsnummer && bonusMedlem.get(i).okPassord(passord)){
                return bonusMedlem.get(i).getPoeng();
            }
        }
        return -1;
    }

    public boolean registrerPoeng(int medlemsnummer, int poeng){
        for (int i = 0; i < bonusMedlem.size(); i++) {
            if(bonusMedlem.get(i).getMedlNr()==medlemsnummer){
                bonusMedlem.get(i).setPoeng(poeng);
                return true;
            }
        }
        return false;
    }

    public void sjekkMedlemmer(){

        LocalDate today =  LocalDate.now();

        for (int i = 0; i < bonusMedlem.size(); i++) {

            int mdlnr = bonusMedlem.get(i).getMedlNr();
            Personalia pers = bonusMedlem.get(i).getPers();
            LocalDate innm = bonusMedlem.get(i).getInnmeldtDato();
            int poeng = bonusMedlem.get(i).getPoeng();

            if(bonusMedlem.get(i) instanceof BasicMedlem){

                if(bonusMedlem.get(i).finnKvalPoeng(today)>=25000 && bonusMedlem.get(i).finnKvalPoeng(today)<75000){
                    //Oppgraderer basic til sølv
                    SoelvMedlem nySoelv = new SoelvMedlem(mdlnr,pers,innm,poeng);
                    bonusMedlem.set(i,nySoelv);
                }
                else if(bonusMedlem.get(i).finnKvalPoeng(today)>=75000){
                    //Oppgraderer basic til gull.
                    GullMedlem gullMedlem = new GullMedlem(mdlnr,pers,innm,poeng);
                    bonusMedlem.set(i,gullMedlem);
                }
            }
            else if(bonusMedlem.get(i) instanceof SoelvMedlem){

                if (bonusMedlem.get(i).finnKvalPoeng(today)>=75000) {
                    //oppgradering til Gullmedlem
                    GullMedlem gullmedlem = new GullMedlem(mdlnr, pers, innm, poeng);
                    bonusMedlem.set(i, gullmedlem);
                }
            }
        }
    }

    public String toString(){
        String txt = "";

        for (int i = 0; i < bonusMedlem.size(); i++) {
            if(bonusMedlem.get(i) instanceof BasicMedlem){
                txt+= "Basicmedlem: \n"+bonusMedlem.get(i).toString()+"\n\n";;
            }
            else if(bonusMedlem.get(i) instanceof SoelvMedlem){
                txt+= "Sølvmedlem: \n"+bonusMedlem.get(i).toString()+"\n\n";;
            }
            else{
                txt+= "Gullmedlem: \n"+bonusMedlem.get(i).toString()+"\n\n";;
            }
        }
        return txt;
    }
}
