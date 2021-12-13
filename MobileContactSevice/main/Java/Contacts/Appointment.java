package Contacts;

import java.util.Date;

public class Appointment {

	private Date apptDate;
	private String apptId;
	private String apptDescription;
	private static final byte apptId_LENGTH = 10;
	private static final int apptDescription_LENGTH = 50;

	public Appointment(String apptId, Date apptDate, String apptDescription) {
		setApptDate(apptDate);
		setApptId(apptId);
		setApptDescription(apptDescription);
	}

	public String getApptId() {
		return apptId;
	}

	public String getApptDescription() {
		return apptDescription;
	}

	public Date getApptDate() {
		return apptDate;
	}

	@SuppressWarnings("deprecation")
	public void setApptDate(Date apptDate) {
		Date currentDate = new Date();
		Date appointmentDate = apptDate;
		if (appointmentDate == null) {
			throw new NullPointerException("Date cannot be null");
		} else if (appointmentDate.before(currentDate)) {
			throw new IllegalArgumentException("Invalid Appintment Date");
		} else {
			this.apptDate = apptDate;
		}
	}

	public void setApptId(String newUniqueApptId) {
		if (newUniqueApptId == null) {
			throw new NullPointerException("Appointment Id cannot be null");
		} else if (newUniqueApptId.length() > apptId_LENGTH) {
			throw new IllegalArgumentException("Invalid Appointment Id.");
		} else {
			this.apptId = newUniqueApptId;
		}
	}

	public void setApptDescription(String apptDescription) {
		if (apptDescription == null) {
			throw new NullPointerException("Appointment Description cannot be null");
		} else if (apptDescription.length() > apptDescription_LENGTH) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		} else {
			this.apptDescription = apptDescription;
		}
	}

}