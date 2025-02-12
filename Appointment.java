public class Appointment {
    //Durjoy(40)
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public void printAppointmentDetails() {
        System.out.println("Appointment Details: " + patient.getName() + " with Dr. " + doctor.getName() + " on " + date);
    }
}
