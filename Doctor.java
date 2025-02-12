public class Doctor {
    //Jihad(42)
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public void treatPatient(Patient patient){
        System.out.println("Dr. "+"is treating "+ patient.getName());
    }
}
