import java.util.ArrayList;

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String timeSlot;
    private String status;

    public Appointment(Doctor doctor, Patient patient, String timeSlot) {
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.status = "Booked";
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void cancel() {
        status = "Cancelled";
    }

    public boolean isBooked() {
        return "Booked".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Doctor : " + doctor.getName() + " (" + doctor.getSpecialization() + ")\n"
                + "Patient : " + patient.getName() + " (Age: " + patient.getAge() + ")\n"
                + "Time : " + timeSlot + "\n"
                + "Status : " + status;
    }
}

public class Main {

    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static boolean isSlotBooked(Doctor doctor, String timeSlot) {

        for (Appointment a : appointments) {
            if (a.getDoctor().getName().equals(doctor.getName())
                    && a.getTimeSlot().equals(timeSlot)
                    && a.isBooked()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== Hospital Appointment Booking System ===\n");

        Doctor drSharma = new Doctor("Dr. Sharma", "Cardiology");
        Doctor drMehta = new Doctor("Dr. Mehta", "Neurology");

        Patient rahul = new Patient("Rahul", 28);
        Patient priya = new Patient("Priya", 25);

        String slot = "10:00 AM";

        System.out.println(">> Checking slot: Dr. Sharma | " + slot);

        if (!isSlotBooked(drSharma, slot)) {

            System.out.println("Available slot: " + slot);

            Appointment a1 =
                    new Appointment(drSharma, rahul, slot);

            appointments.add(a1);

            System.out.println("Appointment booked successfully!\n");

            System.out.println("--- Appointment Details ---");
            System.out.println(a1);
        }

        System.out.println("\n>> Attempting same slot: Dr. Sharma | 10:00 AM");

        if (isSlotBooked(drSharma, slot)) {
            System.out.println("Error: Slot already booked!");
        }

        Appointment a2 =
                new Appointment(drMehta, priya, "11:30 AM");

        appointments.add(a2);

        System.out.println("\n>> Cancelling: Rahul | 10:00 AM");

        appointments.get(0).cancel();

        System.out.println("Appointment cancelled successfully!");
        System.out.println("Status : " + appointments.get(0).getStatus());

        System.out.println("\n=== All Appointments ===\n");

        for (int i = 0; i < appointments.size(); i++) {

            Appointment a = appointments.get(i);

            System.out.println(
                    "[" + (i + 1) + "] "
                            + a.getDoctor().getName()
                            + " | "
                            + a.getPatient().getName()
                            + " | "
                            + a.getTimeSlot()
                            + " | "
                            + a.getStatus()
            );
        }
    }
}
