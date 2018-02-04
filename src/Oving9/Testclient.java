package Oving9;

public class Testclient {

    public static void main(String[] args) {

        //Tester ståplass :D :D :D :D :D
        Staa staaplass = new Staa("Simons slumtrib",90,60);

        //System.out.println(staaplass.toString());
        staaplass.kjopBilletter(10);
        String[] navn = {"Simon"};
        String[] navn2 = {"Jens","Morten","Adrian","Knut","Per"};
        staaplass.kjopBilletter(navn);
        //System.out.println(staaplass.toString());

        //Tester sitteplass
        Sitte sitteTribune = new Sitte("Sittetribune",100,120,10);
        sitteTribune.kjopBilletter(9);
        sitteTribune.kjopBilletter(9);
        sitteTribune.kjopBilletter(7);
        sitteTribune.kjopBilletter(navn);

        //System.out.println(sitteTribune.toString());

        //System.out.println(sitteTribune.printRadOppsett());

        Vip vip = new Vip("VIP1",100,240,10);

        vip.kjopBilletter(navn2);
        System.out.println(vip.finnAntallSolgteBilletter());
        System.out.println(vip.finnInntekt());
        System.out.println(vip.toString());
    }
}
