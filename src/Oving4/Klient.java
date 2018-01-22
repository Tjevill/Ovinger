package Oving4;

import javax.swing.*;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Klient {

    private final static String RESERVER_ROM = "Reserver rom";
    private final static String INFO = "Info om rom";
    private final static String REG_NYTT_ROM = "Registrer rom";
    private final static String FINN_ANT_ROM = "Finn antall rom";
    private final static String FINN_ROM_INDEKS = "Finn rom (Indeks)";
    private final static String FINN_ROM_ROMNR = "Finn rom (Romnr)";
    private final static String AVSLUTT = "Avslutt";


    public static void main(String[] args) {

        //Oppretter konferansesenter
        Konferansesenter test = new Konferansesenter();

        //Legger til rom i konferansesenter.
        test.leggTilRom(1,5);
        test.leggTilRom(2,8);
        test.leggTilRom(3,5);
        test.leggTilRom(4,2);
        test.leggTilRom(5,5);

        //MENY
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String[] valg = {RESERVER_ROM, INFO, REG_NYTT_ROM, FINN_ANT_ROM, FINN_ROM_INDEKS, FINN_ROM_ROMNR, AVSLUTT};

        //DO-WHILE fram til mittValg=AVSLUTT.
        String mittValg;
        do {

            mittValg =(String) showInputDialog(frame,"Choose","Menu",JOptionPane.PLAIN_MESSAGE,null,valg,valg[0]);

            switch (mittValg){
                case RESERVER_ROM:

                    //KUNDEN
                    String kundenavn = showInputDialog("Reservasjonsnavn : ");
                    String tlf = (showInputDialog("Telefon: "));
                    Kunde j = new Kunde(kundenavn, tlf);

                    //Antall personer - Med DO-WHILE helt til klient får riktig informasjon fra bruker.
                    int antPers=0;
                    boolean antPersOk = false;
                    do {
                        try {
                            antPers = Integer.parseInt(showInputDialog("Hvor mange er dere?"));
                            antPersOk = true;
                            //int antPers = 5;
                        } catch (Exception e) {
                            showMessageDialog(null, "Noe gikk galt. Skriv nytt antall.");
                        }
                        if(antPers<1){
                            antPersOk=false;
                        }
                    }while (!antPersOk);

                    //TIDSPUNKT
                    long til=0;
                    long fra=0;
                    boolean tidSjekk;
                    do {
                            try {
                                fra = Long.parseLong(showInputDialog("Fra? (ååååmmddttmm)"));
                                tidSjekk = true;
                            } catch (Exception e) {
                                showMessageDialog(null, "Innskriving feil på fra-tidspunkt. (ååååmmddttmm)");
                                tidSjekk = false;
                            }
                    }while(!tidSjekk);

                    do {
                            try {
                                til = Long.parseLong(showInputDialog("Til? (ååååmmddttmm)"));
                                tidSjekk = true;
                            } catch (Exception e) {
                                showMessageDialog(null, "Innskriving feil på til-tidspunkt. (ååååmmddttmm)");
                                tidSjekk = false;
                            }
                    } while(!tidSjekk);

                    Tidspunkt t1 = new Tidspunkt(fra);
                    Tidspunkt t2 = new Tidspunkt(til);

                    if(test.reserverRom(antPers, t1, t2, j)){
                        showMessageDialog(null,"Reservasjon var vellykket!");
                    }else{
                        showMessageDialog(null, "Reservasjon mislyktes!");
                    }
                    break;

                    //Skriver ut informasjon om alle rommene.
                case INFO:
                    showMessageDialog(null, test.toString());
                    break;

                    //Registrerer nytt rom
                case REG_NYTT_ROM:
                    int romnr = Integer.parseInt(showInputDialog("Romnr: "));
                    int romstorrelse = Integer.parseInt(showInputDialog("Romstørrelse:"));

                    if(test.leggTilRom(romnr,romstorrelse)){
                        showMessageDialog(null,"Rommet er bygget og klart");
                    }else{
                        showMessageDialog(null,"Kan ikke bygge rom nå.");
                    }
                    break;

                    //Gir antall rom til konferansesenteret.
                case FINN_ANT_ROM:
                    showMessageDialog(null, "Konferansesenteret har "+test.getAntRom()+" rom.");
                    break;

                    //Finner rom ved hjelp av array-indeks.
                case FINN_ROM_INDEKS:
                    int indeks = Integer.parseInt(showInputDialog("Indeks til rom: "));
                    showMessageDialog(null,test.finnRomIndex(indeks));
                    break;

                    //Finner rom ved hjelp av rom-id.
                case FINN_ROM_ROMNR:
                    romnr = Integer.parseInt(showInputDialog("Romnr: "));
                    showMessageDialog(null,test.finnRom(romnr));
                    break;

                    //Avslutter programmet.
                case AVSLUTT:
                    System.exit(0);
                    break;

            }
        }while(mittValg!=AVSLUTT || mittValg!=null);
    }
}
