package Oving9;

public class Vip extends Tribune{

    private String[][] tilskuer; //Tabellstørrelse: antall rader * antall plasser pr rad.
    private int rader;
    private int antSeterPrRad = 0;
    private int optPlasser;
    private int radStorrelse;
    private int[] antOpptattPrRad;
    //todo Ikke noe arv, men bruk Billett.java -> SitteplassBillett.
    public Vip(String tribunenavn, int kapasitet, int pris, int rader) {
        super(tribunenavn, kapasitet, pris);
        boolean sjekk = false;
        do{
            if(kapasitet%rader==0){
                antSeterPrRad = kapasitet/rader;
                sjekk = true;
            }
            else {
                kapasitet--;
            }
        }while (!sjekk);
        antOpptattPrRad = new int[rader];
        tilskuer = new String[rader][antSeterPrRad];
    }

    @Override
    public int finnAntallSolgteBilletter() {

        int optPlasser = 0;

        for (int i = 0; i < tilskuer.length; i++) {

            for (int j = 0; j < tilskuer.length; j++) {
                if(tilskuer[i][j]!=null){
                    antOpptattPrRad[i]++;
                    optPlasser++;
                }
            }
        }
        return optPlasser;
    }

    @Override
    public int finnInntekt() {
        return (finnAntallSolgteBilletter()*getPris());
    }


    @Override
    public Billett[] kjopBilletter(int antBilletter) {
        throw new IllegalArgumentException("Duuu kanj itj kjøp VIP uten navn nææj!");
    }

    @Override
    public Billett[] kjopBilletter(String[] navn) {
        Billett[] billett = new Billett[navn.length];

        //Teller opp antall opptatt per rad. Dette kunne vært en egen metode.
        for (int i = 0; i < tilskuer.length; i++) {
            for (int j = 0; j < tilskuer.length; j++) {
                if(tilskuer[i][j]!=null){
                    antOpptattPrRad[i]++;
                }
            }
        }

        if(sjekkAlleNavn(navn)){

            int antBilletter = navn.length;

            for (int i = 0; i < tilskuer.length ; i++) {
                if((antSeterPrRad-antOpptattPrRad[i])>=antBilletter){
                    antOpptattPrRad[i]+=antBilletter;

                    for (int j = 0; j < navn.length; j++) {
                        SitteplassBillett nyBillett = new SitteplassBillett(getTribunenavn(),getPris(),i,antOpptattPrRad[i]-j);
                        billett[j] = nyBillett;
                        tilskuer[i][antOpptattPrRad[i]+j] = navn[j];

                    }
                    return billett;
                }
            }
        }
        return null;
    }

    public boolean sjekkAlleNavn(String[]navn){
        for (int i = 0; i < navn.length; i++) {
            if(navn[i].equals("")){
                return false;
            }
        }
        return true;
    }


    public String toString() {
        return "\nTribunenavn: "+getTribunenavn()+"\nKapasitet: "+getKapasitet()+"\nAnt. solgte bill: "+finnAntallSolgteBilletter()+"\nInntekt: "+finnInntekt();
    }
}
