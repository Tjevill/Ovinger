package Oving1;

class Klient{

    public static void main(String[]args){

        Bord bord = new Bord(5);
        Restaurant minRes = new Restaurant("Simons pizzeria",1998,bord);

        System.out.println(minRes.toString());
        System.out.println(minRes.getLedigeBord());
        System.out.println(minRes.getOptBord());
        System.out.println(minRes.resBord("Ann-Therese"));
        System.out.println(minRes.resBord("Simon"));
        System.out.println(minRes.resBord("Simon"));
        System.out.println(minRes.resBord("Simon"));
        System.out.println(minRes.resBord("Simon"));
        System.out.println(minRes.resBord("Simon"));
        System.out.println(minRes.getOptBord());
        System.out.println(minRes.getBordPerson("Simon"));
        System.out.println(minRes.getOptBord()+" opptatte bord.");
        System.out.println(minRes.skrivUtBord());
        minRes.tomBord(0);
        System.out.println(minRes.getOptBord()+ " opptatte bord etter rydding.");
        System.out.println(minRes.skrivUtBord());
        minRes.setNavn("Ole's veganerhjørne");
        minRes.setEtabAar(2018);
        System.out.println(minRes.toString());



    }
}