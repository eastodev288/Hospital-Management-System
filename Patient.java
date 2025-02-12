public class Patient {
    //Manik (06)
    private final String name;
    private final int id;
    private String diagnosis;

    public Patient(String name, int id){
        this.name=name;
        this.id=id;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getDiagnosis(){
        return diagnosis;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
}
