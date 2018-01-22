package Oving4;

import javax.swing.*;

public class Menu {

    public String showMenu(){

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        String[] valg = {"Reserver rom", "Registrer nytt rom", "Finn antall rom", "Finn rom (Indeks)", "Finn rom (Romnr)", "Avslutt"};

        String selection = (String) JOptionPane.showInputDialog(frame,"Choose","Menu",JOptionPane.PLAIN_MESSAGE,null,valg,valg[0]);
        String selectionString = selection.toString();
        return selectionString;

    }

    public static void main(String[] args) {

        Menu test = new Menu();

        test.showMenu();
    }
}
