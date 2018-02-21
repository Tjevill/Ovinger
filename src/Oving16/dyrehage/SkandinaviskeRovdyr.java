package Oving16.dyrehage;

import java.text.ParseException;

//Implementeres av Individ.java
public interface SkandinaviskeRovdyr {


    String getNavn();

    int getfDato();

    //Alder skrives DDMMYYYY.
    int getAlder()throws ParseException;

    String getAdresse();

    void flytt(String nyAdresse);

    int getAntKull();

    void leggTilKull(int antall);

    void leggTilNyttKull();

    String skrivUtInfo()throws ParseException;

}
