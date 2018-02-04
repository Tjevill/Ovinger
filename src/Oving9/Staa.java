package Oving9;

public class Staa extends Tribune {

    private int antSolgteBilletter;

    public Staa(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn, kapasitet, pris);
    }

    @Override
    public int finnAntallSolgteBilletter() {
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt() {
        return (antSolgteBilletter*getPris());
    }

    @Override
    public Billett[] kjopBilletter(int antBilletter) {

        Billett[] billetter = new Billett[antBilletter];
        int kapasitet = getKapasitet() - finnAntallSolgteBilletter();

        if(kapasitet>antBilletter){
            for (int i = 0; i < antBilletter; i++) {
                StaaplassBillett selg = new StaaplassBillett(getTribunenavn(),getPris());
                billetter[i] = selg;
            }
        }
        else {
            throw new IllegalArgumentException("Det er ikke plass!");
        }
        antSolgteBilletter+=antBilletter;
        return billetter;
    }

    @Override
    public Billett[] kjopBilletter(String[] navn) {

        for (int i = 0; i < navn.length; i++) {
            if(navn[i]==null){
                throw new IllegalArgumentException("Navn kan ikke være tom");
            }
        }
        Billett[] billetter = new Billett[navn.length];
        int kapasitet = getKapasitet() - finnAntallSolgteBilletter();
        if(kapasitet>navn.length){
            for (int i = 0; i < navn.length; i++) {
                StaaplassBillett selg = new StaaplassBillett(getTribunenavn(),getPris());
                billetter[i] = selg;
            }
        }
        else{
            throw new IllegalArgumentException("Det er ikke plass");
        }
        antSolgteBilletter+=navn.length;
        return billetter;
    }

    public String toString(){
        return "\nTribunenavn: "+getTribunenavn()+"\nKapasitet: "+getKapasitet()+"\n"
                +"Antall solgte: "+antSolgteBilletter+"\nInntekt: "+finnInntekt();

    }
}
