package Oving3ArrayList;

public class Student {

    private final String navn;
    private int antOppg;

    public Student(String navn, int antOppg){

        this.navn = navn;
        this.antOppg = antOppg;

    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void setAntOppg(int antOppg){
        if (antOppg>0){
            throw new IllegalArgumentException("Tallet kan ikke være negativt! Prøv igjen.");
        }
        this.antOppg = antOppg;
    }

    public void okAntOppg(int okning){
        if (antOppg<0){
            throw new IllegalArgumentException("Tallet kan ikke være negativt! Prøv igjen.");
        }
        this.antOppg+=okning;
    }

    @Override
    public String toString() {
        return "Student{" +
                "navn='" + navn + '\'' +
                ", antOppg=" + antOppg +
                '}';
    }
}
