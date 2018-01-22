package Oving4;

import java.util.ArrayList;

/*
*
*   Rom-nr
*   Trenger romstørrelse
*   Reservasjon
*
*
*/
public class Rom {

    private java.util.ArrayList<Reservasjon> res = new java.util.ArrayList<Reservasjon>();

    public int romnr;
    public int romstorrelse;

    public Rom(int romnr, int romstorrelse){
        if(romstorrelse<1){
            throw new IllegalArgumentException("Feil romstørrelse");
        }
        this.romnr = romnr;
        this.romstorrelse = romstorrelse;
    }

    public int getRomnr() {
        return romnr;
    }

    public void setRomnr(int romnr) {
        this.romnr = romnr;
    }

    public int getRomstorrelse() {
        return romstorrelse;
    }

    public void setRomstorrelse(int romstorrelse) {
        this.romstorrelse = romstorrelse;
    }


    public boolean reserverRom(Reservasjon rom){
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).overlapp(rom.getFraTid(),rom.getTilTid())){
                return false;
            }
        }
        res.add(rom);
        return true;

    }

    public String toString(){
        String utskrift = "Romnr: "+getRomnr()+"\nRomstørrelse: "+getRomstorrelse()+"\n";
        for (int i = 0; i < res.size(); i++) {
            utskrift+=res.get(i).toString()+"\n-----------------";
        }
        return utskrift;
    }

    public static void main(String[] args) {

        //Rom-objekter
        Rom r1 = new Rom(1,5);
        Rom r2 = new Rom(2,5);
        Rom r3 = new Rom(3,4);

        //Arraylist til rom-objekter
        ArrayList rom = new ArrayList();
        rom.add(r1);
        rom.add(r2);
        rom.add(r3);

        //Kunde og reservasjonsopjekt


        //Test 1    -   toString()
        System.out.println("Test 1: toString");
        for (int i = 0; i < rom.size(); i++) {
            System.out.println(rom.get(i).toString());
        }
        System.out.println("Test 1 vellykket");
        //Test 1    -   Vellykket
    }
}


