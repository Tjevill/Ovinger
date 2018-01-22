package Oving1;

public class Bord{

    private int ledigeBord;
    private int opptattBord;
    private String[] resListe;

    public Bord(int antBord){

        resListe = new String[antBord];
    }
    public int getLedigBord(){
        ledigeBord = 0;
        for(int i=0;i<resListe.length;i++){
            if(resListe[i]==null){
                ledigeBord++;
            }
        }
        return ledigeBord;
    }
    public int getOptBord(){
        opptattBord = 0;
        for(int i=0;i<resListe.length;i++){
            if(resListe[i]!=null){
                opptattBord++;
            }
        }
        return opptattBord;
    }
    public boolean fjernReservasjon(int index){
        if(resListe[index]!=null){
            resListe[index]=null;
            return true;
        }
        return false;
    }
    public boolean reserverBord(String navn){
        for(int i=0;i<resListe.length;i++){
            if(resListe[i]==null){
                resListe[i]=navn;
                return true;
            }
        }
        return false;
    }

    public int getBordPerson(String navn){
        for(int i=0;i<resListe.length;i++){
            if(resListe[i]==navn){
                return i;
            }
        }
        return -1;
    }
    public String skrivUtBord(){
        String res = "";
        for(int i=0;i<resListe.length;i++){
            res+=resListe[i];
        }
        return res;
    }
}