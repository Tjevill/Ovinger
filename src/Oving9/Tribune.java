package Oving9;

import java.io.Serializable;

public abstract class Tribune implements Serializable {

    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;

    public Tribune(String tribunenavn, int kapasitet, int pris){

        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    public String getTribunenavn() {
        return tribunenavn;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public int getPris() {
        return pris;
    }

    public abstract int finnAntallSolgteBilletter();

    public abstract int finnInntekt();
        //inntekt = prisen* antall solgte billetter.

    public abstract Billett[] kjopBilletter(int antBilletter);

    public abstract Billett[] kjopBilletter(String[] tekststrenger);//Navnet på de som skal ha billettene.


    public String toString() {

        return "Tribunenavn: "+getTribunenavn()+"\nKapasitet: "+getKapasitet()+"\nAnt solgte bil: "+finnAntallSolgteBilletter()+
                "\nInntekt: "+finnInntekt()+"\n\n";
    }
}
