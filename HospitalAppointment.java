public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String timeSlot;
    private String status; // Booked or Cancelled

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
        this.status = "Cancelled";
    }

    public boolean isBooked() {
        return "Booked".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Doctor: " + doctor.getName() + "\n"
                + "Patient: " + patient.getName() + "\n"
                + "Time: " + timeSlot + "\n"
                + "Status: " + status;
    }
}
