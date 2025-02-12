import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    //Team leader Eastodev(12) and Mohaminul(11)
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void registerPatient(String name, int id) {
        Patient patient = new Patient(name, id);
        patients.add(patient);
        System.out.println("Patient registered: " + name);
    }

    public void addDoctor(String name, String specialization) {
        Doctor doctor = new Doctor(name, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added: Dr. " + name);
    }

    public void scheduleAppointment(int patientId, String doctorName, String date) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorByName(doctorName);
        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            appointment.printAppointmentDetails();
        } else {
            System.out.println("Invalid patient or doctor details.");
        }
    }

    private Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    public void generateReport() {
        System.out.println("--- Hospital Activity Report ---");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Appointments: " + appointments.size());
    }

    public void userInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Generate Invoice");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    registerPatient(patientName, patientId);
                    break;
                case 2:
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    addDoctor(doctorName, specialization);
                    break;
                case 3:
                    System.out.print("Enter Patient ID: ");
                    int appointmentPatientId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Doctor Name: ");
                    String appointmentDoctorName = scanner.nextLine();
                    System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                    String appointmentDate = scanner.nextLine();
                    scheduleAppointment(appointmentPatientId, appointmentDoctorName, appointmentDate);
                    break;
                case 4:
                    System.out.print("Enter Patient Name for Invoice: ");
                    String invoicePatientName = scanner.nextLine();
                    System.out.print("Enter Invoice Amount: ");
                    double amount = scanner.nextDouble();
                    generateInvoice(new Patient(invoicePatientName, 0), amount);
                    break;
                case 5:
                    generateReport();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public void generateInvoice(Patient patient, double amount) {
        Billing.generateInvoice(patient, amount);
    }
}