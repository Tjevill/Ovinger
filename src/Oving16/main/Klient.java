package Oving16.main;
import Oving16.dyrehage.*;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

public class Klient {

    //Top level choice
    private final static String REGISTRER_DYR = "Registrer dyr";
    private final static String KULL_INFO = "Kull-håndtering";
    private final static String GETKULL = "Hent kull";
    private final static String REGENKKULL = "Registrer enkelt kull";
    private final static String REGKULL = "Registrer flere kull";
    private final static String SKRIVUTINFO = "Skriv ut info";
    private final static String FLYTTDYR = "Flytt dyr";
    private final static String AVSLUTT = "Avslutt";
    private final static String TILBAKE = "Tilbake";

    //BJØRN
    private final static String BJORN = "Registrer bjørn";
    private final static String BINNE = "Binne";
    private final static String HANNBjorn = "Hann";

    //ULV
    private final static String ULV = "Registrer ulv";
    private final static String TISPE = "Tispe";
    private final static String HANNUlv = "Hann";

    public static void main(String[] args) throws ParseException {

        //Oppretter rovdyrfabrikk
        Rovdyrfabrikk fabrikk = new Rovdyrfabrikk();

        //Array for dyr
        ArrayList<SkandinaviskeRovdyr> dyr = new ArrayList<>();

        //Enkel meny for kjøring
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        //MENYVALGENE
        String[] valg = {REGISTRER_DYR, FLYTTDYR, KULL_INFO, SKRIVUTINFO, AVSLUTT};
        String[] kullMeny = {GETKULL, REGENKKULL, REGKULL, TILBAKE};
        String[] regDyr = {BJORN, ULV, TILBAKE};
        String[] bjornKjonn = {BINNE, HANNBjorn,TILBAKE};
        String[] ulvKjonn = {TISPE, HANNUlv,TILBAKE};

        //DO-WHILE fram til mittValg=AVSLUTT.
        String mittValg;

        do {
            mittValg = (String) showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, valg, valg[0]);
            switch (mittValg) {

                case (REGISTRER_DYR):
                    mittValg = (String) showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, regDyr, regDyr[0]);

                    switch (mittValg) {
                        case (BJORN):
                            mittValg = (String) showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, bjornKjonn, bjornKjonn[0]);
                            if (mittValg == BINNE) {

                                try {

                                    int ankommetDato = Integer.parseInt(showInputDialog("Ankommet dato:"));
                                    String adr = showInputDialog("Adresse: ");
                                    String navn = showInputDialog("Navn: ");
                                    int fDato = Integer.parseInt(showInputDialog("Fødselsdato? DDMMYYYY"));
                                    int antallKull = Integer.parseInt(showInputDialog("Antall kull: "));

                                    SkandinaviskeRovdyr nyBinne = fabrikk.nyBinne(ankommetDato, adr, navn, fDato, antallKull);
                                    dyr.add(nyBinne);
                                    showMessageDialog(null, "Du registrerte en ny bjørn");
                                    break;


                                } catch (Exception e) {
                                    showMessageDialog(null, "Noe gikk galt. Prøv igjen!");
                                }

                            } else if (mittValg == HANNBjorn) {

                                try {

                                    int ankommetDato = Integer.parseInt(showInputDialog("Ankommet dato: (DDMM)"));
                                    String adr = showInputDialog("Adresse: ");
                                    String navn = showInputDialog("Navn: ");
                                    int fDato = Integer.parseInt(showInputDialog("Fødselsdato? (DDMMYYYY)"));

                                    SkandinaviskeRovdyr nyHann = fabrikk.nyHannbjorn(ankommetDato, adr, navn, fDato);
                                    dyr.add(nyHann);
                                    showMessageDialog(null, "Du registrerte en ny bjørn");
                                    break;

                                } catch (Exception e) {
                                    showMessageDialog(null, "Noe gikk galt. Prøv igjen!");
                                }

                            } else {
                                break;
                            }
                            break;

                        case (ULV):
                            mittValg = (String) showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, ulvKjonn, ulvKjonn[0]);
                            if (mittValg == TISPE) {

                                try {

                                    int ankommetDato = Integer.parseInt(showInputDialog("Ankommet dato: (DDMM)"));
                                    String adr = showInputDialog("Adresse: ");
                                    String navn = showInputDialog("Navn: ");
                                    int fDato = Integer.parseInt(showInputDialog("Fødselsdato? (DDMMYYYY)"));
                                    int antallKull = Integer.parseInt(showInputDialog("Antall kull: "));

                                    SkandinaviskeRovdyr nyTispe = fabrikk.nyUlvetispe(ankommetDato, adr, navn, fDato, antallKull);
                                    dyr.add(nyTispe);
                                    showMessageDialog(null, "Du registrerte en ny ulv");
                                    break;

                                } catch (Exception e) {
                                    showMessageDialog(null, "Noe gikk galt. Prøv igjen!");
                                }
                            } else if (mittValg == HANNUlv) {

                                try {

                                    int ankommetDato = Integer.parseInt(showInputDialog("Ankommet dato: (DDMM)"));
                                    String adr = showInputDialog("Adresse: ");
                                    String navn = showInputDialog("Navn: ");
                                    int fDato = Integer.parseInt(showInputDialog("Fødselsdato? (DDMMYYYY)"));

                                    SkandinaviskeRovdyr nyHann = fabrikk.nyUlvehann(ankommetDato, adr, navn, fDato);
                                    dyr.add(nyHann);
                                    showMessageDialog(null, "Du registrerte en ny ulv");
                                    break;

                                } catch (Exception e) {
                                    showMessageDialog(null, "Noe gikk galt. Prøv igjen!");
                                }

                            } else {
                                break;
                            }
                            break;
                    }
                    break;

                case(FLYTTDYR):

                    String adresser = "";
                    int teller = 0;
                    for (int i = 0; i < dyr.size(); i++) {
                        adresser+="Navn: "+dyr.get(i).getNavn()+"\t, Adresse: "+dyr.get(i).getAdresse()+"\n";
                    }
                    boolean riktigNavn = false;
                    do {
                        String navn = showInputDialog(null, "Hvem vil du flytte? (Navn)\n\n"+adresser);
                        for (int i = 0; i < dyr.size(); i++) {
                            if (navn.compareTo(dyr.get(i).getNavn())==0){
                                String adr = showInputDialog(null, "Ny adresse: ");
                                dyr.get(i).flytt(adr);
                                showMessageDialog(null,"Adresseendring utført.");
                                riktigNavn = true;
                            }
                            else {
                                showMessageDialog(null,"Finner ikke navnet du skrev inn.");
                                teller++;
                                if(teller>3){
                                    riktigNavn = true;
                                }

                            }
                        }
                    }while(!riktigNavn);
                    break;


                case(KULL_INFO):

                    mittValg = (String) showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, kullMeny, kullMeny[0]);
                    switch (mittValg){
                        case (GETKULL):
                            String utskrift = "";
                            for (int i = 0; i < dyr.size(); i++) {
                                utskrift += "\tNavn: "+dyr.get(i).getNavn()+"\n\tAntall kull: "+dyr.get(i).getAntKull()+"\n\n";
                            }
                            showMessageDialog(null,utskrift);
                            break;

                        case (REGENKKULL):
                            riktigNavn = false;
                            int count = 0;
                            utskrift = "";
                            for (int i = 0; i < dyr.size(); i++) {
                                if(dyr.get(i)instanceof Hunnindivid){
                                    utskrift+="Navn: "+dyr.get(i).getNavn();
                                }
                            }
                            do {
                                String navn = showInputDialog(null, "Hvem vil du legge et enkelt kull til på?\n\n" + utskrift);
                                for (int i = 0; i < dyr.size(); i++) {
                                    if (navn.compareTo(dyr.get(i).getNavn()) == 0) {
                                        dyr.get(i).leggTilNyttKull();
                                        showMessageDialog(null,"Registrering fullført.");
                                        riktigNavn=true;
                                    } else {
                                        showMessageDialog(null, "Finner ikke navnet du oppga. Prøv på nytt.");
                                        count++;
                                        if (count > 3) {
                                            showMessageDialog(null, "Du skrev feil for mange ganger");
                                            riktigNavn = true;
                                        }
                                    }
                                }
                            }while (!riktigNavn);
                            break;


                        case (REGKULL):
                            utskrift = "";
                            for (int i = 0; i < dyr.size(); i++) {
                                if (dyr.get(i) instanceof Hunnindivid){
                                    utskrift+="Navn: "+dyr.get(i).getNavn()+"\tAdresse: "+dyr.get(i).getAdresse()+"\tAntall kull: "+dyr.get(i).getAntKull();
                                }
                            }
                            boolean rettNavn;
                            teller = 0;
                            do{
                                rettNavn = false;
                                String navn = showInputDialog(null,"Hvem vil du endre kullet til?\n\n"+utskrift);
                                for (int i = 0; i < dyr.size(); i++) {
                                    if(navn.compareTo(dyr.get(i).getNavn())==0){
                                        int antall = Integer.parseInt(showInputDialog(null,"Hvor mange kull vil du legge til?"));
                                        dyr.get(i).leggTilKull(antall);
                                        showMessageDialog(null,"Registrering av kull fullført.");
                                        rettNavn = true;
                                    }
                                    else{
                                        showMessageDialog(null,"Finner ikke navnet du oppga. Prøv på nytt.");
                                        teller++;
                                        if(teller>3){
                                            showMessageDialog(null,"Du skrev feil for mange ganger");
                                            rettNavn = true;
                                        }
                                    }
                                }
                            }while (!rettNavn);
                            break;
                    }

                case(SKRIVUTINFO):
                    for (int i = 0; i < dyr.size(); i++) {
                        System.out.println(dyr.get(i).skrivUtInfo());
                    }
                    break;
            }
        } while (mittValg.compareTo(AVSLUTT)!=0);
    }
}
