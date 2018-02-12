package Oving9;

import java.io.*;
import java.util.Arrays;

public class mainTest {

    public static void main(String[] args) {


        String[] navn ={"Simon","Per","Frank"};

        Staa staTrib1 = new Staa("Tribune A",100,70);
        Staa staTrib2 = new Staa("Tribune B",100,70);
        Sitte sitte = new Sitte("Sittetribune A",50,120,5);
        Sitte sitte2 = new Sitte("Sittetribune B",100,120,10);
        Vip vip = new Vip("VIP-Tribune",50,260,5);

        Tribune[] tribuner = {staTrib1,staTrib2,sitte,sitte2,vip};
        Billett[] staBill = tribuner[0].kjopBilletter(60);
        Billett[] staBill2 = tribuner[1].kjopBilletter(90);
        Billett[] sitteBill = tribuner[2].kjopBilletter(8);
        Billett[] sitteBill2 = tribuner[3].kjopBilletter(5);
        Billett[] vipparn = tribuner[4].kjopBilletter(navn);

        for (Billett a :
                staBill) {
            System.out.println(a);
        }

        for (Billett a :
                staBill2) {
            System.out.println(a);
        }

        for (Billett a:
             sitteBill) {
            System.out.println(a);
        }

        for (Billett a :
                vipparn) {
            System.out.println(a);
        }

        for (int i = 0; i < tribuner.length; i++) {
            System.out.println(tribuner[i].toString());
        }
        System.out.println();
        System.out.println("SORTERING AV TABELLEN ETTER INNTEKT");

        Arrays.sort(tribuner, (a,b)->b.finnInntekt()-a.finnInntekt());

        for (Tribune a :
                tribuner) {
            System.out.println(a);
        }
        System.out.println();
        System.out.println("HER KOMMER SERIALISERINGEN!!!!!!!");
        try{
            //Skriver til fil
            FileOutputStream fileoutput = new FileOutputStream("filnavn.ser");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(fileoutput);
            objOutputStream.writeObject(tribuner);
            objOutputStream.close();

            //Leser fra fil
            FileInputStream fileInput = new FileInputStream("filnavn.ser");
            ObjectInputStream objInputStream = new ObjectInputStream(fileInput);
            Tribune[] resultat = (Tribune[])objInputStream.readObject();
            objInputStream.close();

            for (int i = 0; i < resultat.length; i++) {
                System.out.println(resultat[i].toString());
            }
        }catch (Exception e){
            System.out.println("Noe gikk forferdelig galt!");
        }
    }
}
