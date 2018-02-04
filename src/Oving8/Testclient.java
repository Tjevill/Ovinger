package Oving8;

import java.time.LocalDate;

public class Testclient {

    public static void main(String[] args) {

        //Oppretter objektet medlemsarkiv.
        Medlemsarkiv test = new Medlemsarkiv();

        //Personalia-objekter
        Personalia ole = new Personalia("Ole", "Olsen", "ole.olsen@dot.com", "ole");
        Personalia tove = new Personalia("Tove", "Hansen", "tove.hansen@dot.com", "tove");
        Personalia simon = new Personalia("Simon","Lilleeng","slilleeng@gmail.com","1234");
        Personalia chr = new Personalia("Christian","Dalseth","Cdalseth@gmail.com","1234");
        Personalia ben = new Personalia("Big Ben","Johnson","bigben@huge.no","1234");

        //nyMedlem-metode i Medlemsarkiv.
        test.nyMedlem(ole,LocalDate.of(2006, 2, 15));
        test.nyMedlem(tove,LocalDate.of(2006, 2, 15));
        test.nyMedlem(simon,LocalDate.of(2006, 2, 15));
        test.nyMedlem(chr,LocalDate.of(2006, 2, 15));
        test.bonusMedlem.add(new BasicMedlem(100, ole, LocalDate.of(2017, 2, 15)));

        System.out.println(test.toString());

        test.registrerPoeng(100,25100);
        test.sjekkMedlemmer();
        //System.out.println(test.toString());

        test.bonusMedlem.add(new BasicMedlem(110, tove, LocalDate.of(2017, 3, 5)));
        test.bonusMedlem.add(new SoelvMedlem(123, ben, LocalDate.of(2017, 3, 5),26000));
        test.registrerPoeng(110,75001);
        test.sjekkMedlemmer();
        test.registrerPoeng(123,50000);
        test.sjekkMedlemmer();
        System.out.println(test.toString());
    }
}
