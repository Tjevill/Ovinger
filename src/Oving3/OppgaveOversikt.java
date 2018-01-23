package Oving3;

public class OppgaveOversikt {

    private Student[] studenter = new Student[5];
    private int antStud = 0;

    public OppgaveOversikt(){
    }

    public boolean regNyStudent(String navn){
        if(antStud>studenter.length){
            Student[] nyTab = new Student[studenter.length + 5];
            for (int i = 0; i < antStud; i++) {
                nyTab[i] = studenter[i];
            }
        }
        for (int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().compareTo(navn)==0){
                System.out.println("Studenten er allerede registrert!");
                return false;
            }
        }
        studenter[antStud] = new Student(navn,0);
        antStud++;
        return true;
    }

    public int finnAntStud(){
        return antStud;
    }

    public int finnAntOppgaver(String studentNavn){

        for (int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(studentNavn)){
               return studenter[i].getAntOppg();
            }
        }
        return -1;
    }

    public boolean okAntOppg(String studentNavn, int okning){
        if(okning<1){
            throw new IllegalArgumentException("Tallet kan ikke være negativt!");
        }
        for (int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(studentNavn)){
                studenter[i].okAntOppg(okning);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn(){
        String[] res = new String[antStud];
        for (int i = 0; i < antStud; i++) {
            res[i] = studenter[i].getNavn();
        }
        return res;
    }

    @Override
    public String toString() {
        String alleMann = "";
        for (int i = 0; i < antStud; i++) {
            alleMann+="Navn: "+studenter[i].getNavn()+", Antall Oppgaver: "+studenter[i].getAntOppg()+"\n";
        }
        return alleMann;
    }
}
