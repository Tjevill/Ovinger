package Oving8;

//Basicmedlemmer har samlet under 25000 poeng på ett år.

import java.time.LocalDate;

public class BasicMedlem extends BonusMedlem{

    public BasicMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }
}
