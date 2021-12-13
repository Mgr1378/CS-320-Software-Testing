package Contacts;

import java.util.ArrayList; // Resizable Array for contact list
import java.util.Date;
import java.util.List; // ordered objects to access by index
import java.util.UUID;

public class AppointmentService {

	private List<Appointment> appointmentList = new ArrayList<>();

	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	private Appointment searchAppointment(String id) throws Exception {
		for (Appointment appointment : appointmentList) {
			if (appointment.getApptId().equals(id)) {
				return appointment;
			}
		}
		throw new Exception("Appointment does not exist. Try again!");
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void newAppointment(String newUniqueId, Date date, String description) {
		Appointment appt = new Appointment(newUniqueId(), date, description);
		appointmentList.add(appt);
	}

	public void setApptDescription(String uniqueId, String apptDescription) throws Exception {
		searchAppointment(uniqueId).setApptDescription(apptDescription);
	}

	public void deleteAppt(String uniqueId) throws Exception {
		appointmentList.remove(searchAppointment(uniqueId));
	}
}