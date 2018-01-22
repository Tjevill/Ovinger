package Oving4;

public class Konferansesenter {


    private java.util.ArrayList<Rom> konf = new java.util.ArrayList<Rom>();
    public int antRom = 0;

    public boolean leggTilRom(int romnr, int romstorrelse){
        for (int i = 0; i < konf.size(); i++) {
            if(konf.get(i).getRomnr()==romnr){
                return false;
            }
        }
        konf.add(new Rom(romnr,romstorrelse));
        antRom++;
        return true;
    }

    public boolean reserverRom(int antPers, Tidspunkt fraTid,Tidspunkt tilTid, Kunde kunde){
        for (int i = 0; i < konf.size(); i++) {
            Reservasjon res = new Reservasjon(fraTid,tilTid, kunde);
            if(antPers<=konf.get(i).getRomstorrelse() && konf.get(i).reserverRom(res)){
                    return true;
                }
            }
        return false;
    }

    public int getAntRom(){
        return antRom;
    }

    public String finnRom(int romnr){
        String res = "Rommet finnes ikke";
        for (int i = 0; i < konf.size(); i++) {
            if(konf.get(i).getRomnr()==romnr){
                return konf.get(i).toString();
            }
        }
        return res;
    }

    private boolean existRom(int index){
        if(konf.get(index)==null){
            return false;
        }
        return true;
    }



    public String finnRomIndex(int index){
        String res = "Rommet finnes ikke";
        if(existRom(index)) {
            return konf.get(index).toString();
        }
        return res;
    }

    public String toString(){
        String utskrift ="";
        for (int i = 0; i < konf.size(); i++) {
            utskrift+=konf.get(i).toString()+"\n";
        }
        return utskrift;
    }
}
