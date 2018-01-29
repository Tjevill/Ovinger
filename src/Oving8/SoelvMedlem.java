package Oving8;


//For å bli sølvmedlem må kunden tjene opp 25000 poeng i løpet av ett år

import java.time.LocalDate;

public class SoelvMedlem extends BonusMedlem {
    public SoelvMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato);
        super.setPoeng(poeng);
    }

    @Override
    public boolean registrerPoeng(int poeng){
        if(poeng<0){
            return false;
        }
        setPoeng((poeng*12)/10);
        return true;
    }
}
