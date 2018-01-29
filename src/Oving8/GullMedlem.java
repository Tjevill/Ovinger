package Oving8;

import java.time.LocalDate;

//For å bli gullmedlem må kunden tjene opp 75000 poeng i løpet av ett år
public class GullMedlem extends BonusMedlem {

    public GullMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato);
        super.setPoeng(poeng);
    }

    @Override
    public boolean registrerPoeng(int poeng){
        if(poeng<0){
            return false;
        }
        setPoeng((poeng*15)/10);
        return true;
    }
}
