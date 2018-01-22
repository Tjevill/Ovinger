package Oving3ArrayList;


public class OppgaveOversikt {

    private java.util.ArrayList<Student> studenter = new java.util.ArrayList<Student>();
    private int antStud = 0;

    public OppgaveOversikt(){
    }

    public boolean regNyStudent(String navn) {
        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i) != null && studenter.get(i).equals(navn)) {
                return false;
            }
        }
        studenter.add(new Student(navn, 0));
        antStud++;
        return true;
    }

    public int finnAntStud(){
        return antStud;
    }

    public int finnAntOppgaver(String studentNavn){
        int result = 0;
        for (int i = 0; i < studenter.size(); i++) {
            if(studenter.get(i).getNavn().equals(studentNavn)){
                result = studenter.get(i).getAntOppg();
                return result;
            }
        }
        return -1;
    }

    public boolean okAntOppg(String studentNavn, int okning){
        for (int i = 0; i < studenter.size(); i++) {
            if(studenter.get(i).getNavn().equals(studentNavn)){
                studenter.get(i).okAntOppg(okning);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn(){
        String[] res = new String[antStud];
        for (int i = 0; i < studenter.size(); i++) {
            res[i] = studenter.get(i).getNavn();
        }
        return res;
    }

    @Override
    public String toString() {
        String alleMann = "";
        for (int i = 0; i < studenter.size(); i++) {
            alleMann+="Navn: "+studenter.get(i).getNavn()+", Antall Oppgaver: "+studenter.get(i).getAntOppg()+"\n";
        }
        return alleMann;
    }
}
