package Oving9;


//todo FUNGERER.
public class Sitte extends Tribune {

    private int [] antOpptatt; //Tabellstørrelse = antall rader;
    private int rader;
    private int antSeterPrRad = 0;

    public Sitte(String tribunenavn, int kapasitet, int pris, int rader) {
        super(tribunenavn, kapasitet, pris);
        this.rader = rader;
        antOpptatt = new int[rader];

        boolean sjekk = false;
        do{
            if(kapasitet%rader==0){
                antSeterPrRad = kapasitet/rader;
                sjekk = true;
            }
            else{
                kapasitet--;
            }
        }while(!sjekk);
    }

    public int finnAntallSolgteBilletter() {

        int solgteBil = 0;

        for (int i = 0; i < antOpptatt.length; i++) {
                solgteBil += antOpptatt[i];
        }
        return (solgteBil);
    }

    @Override
    public int finnInntekt() {
        return finnAntallSolgteBilletter()*getPris();
    }

    @Override
    public Billett[] kjopBilletter(int antBilletter) {

        int kapasitetPrRad = getKapasitet() / antOpptatt.length;
        int herErJeg = 0;
        Billett[] billett = new Billett[antBilletter];

        for (int i = 0; i < antOpptatt.length; i++) {
            if ((kapasitetPrRad - antOpptatt[i]) >= antBilletter) {
                antOpptatt[i] += antBilletter;
                herErJeg = i;
                break;
            }
        }
        //antOpptatt[herErJeg]+=antBilletter;
        for (int j = 0; j < antBilletter; j++) {
            SitteplassBillett sittBill = new SitteplassBillett(getTribunenavn(), getPris(), herErJeg, j);
            billett[j] = sittBill;
        }
        return billett;
    }
    //Brukes ikke//
    public int finnLedigRad(int antbill) {
        int kapasitetPrRad = getKapasitet() / antOpptatt.length;

        for (int i = 0; i < antOpptatt.length; i++) { // sjekker hver rad
            if (((kapasitetPrRad - antOpptatt[i]) >= antbill)) {
                return i;
            }
        }
        return -1;
    }
    /*
    På sittetribuner begrenses dette av at alle billetter som selges i en bestilling, skal være på samme rad.
     */
    @Override
    public Billett[] kjopBilletter(String[] navn) {

        int antBilletter = navn.length;//Antall billetter.
        int kapasitetPrRad = getKapasitet() / antOpptatt.length;
        int herErJeg = 0;

        Billett[] billett = new Billett[antBilletter];

        for (int i = 0; i < antOpptatt.length; i++) {
            if ((kapasitetPrRad - antOpptatt[i]) >= antBilletter) {
                antOpptatt[i] += antBilletter;
                herErJeg = i;
                break;
            }
        }
        for (int j = 0; j < antBilletter; j++) {
            SitteplassBillett sittBill = new SitteplassBillett(getTribunenavn(), getPris(), herErJeg, j);
            billett[j] = sittBill;
        }
        return billett;

    }
    @Override
    public String toString(){
        return "\nTribunenavn: "+getTribunenavn()+"\nKapasitet: "+getKapasitet()+"\nAntall rader: "
                +rader+"\nPlasser per rad: "+antSeterPrRad+
                "\nAntall solgte: "+finnAntallSolgteBilletter()+"\nInntekt: "+finnInntekt();
    }

    public String printRadOppsett() {
        String s = "";
        for (int i = 0; i < antOpptatt.length; i++) {

            for (int j = 0; j < antSeterPrRad; j++) {
                if (antOpptatt[i] > j) {
                    s += ("[X]");
                } else {
                    s += ("[ ]");
                }
            }
            s += "\n";
        }
        return s;
    }
}
