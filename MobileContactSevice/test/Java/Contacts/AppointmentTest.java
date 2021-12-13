package Contacts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	protected String apptId;
	protected Date apptDate;
	protected String apptDescription;
	protected Date pastApptDate;
	protected String longDescription;
	protected String longApptId;

	@BeforeEach
	void setUp() {
		apptId = "122H332BA9";
		apptDescription = "This is the task that I started";
		longDescription = "This is the task that I started when I was out in the city today and I just like to go to the city";
		longApptId = "111222333444555666777888999000";
		apptDate = new GregorianCalendar(2022, Calendar.JUNE, 26).getTime();
		pastApptDate = new GregorianCalendar(2021, Calendar.JULY, 31).getTime();

	}

	@Test
	void testAppointment() {
		Appointment appt = new Appointment(apptId, apptDate, apptDescription);
		assertEquals(apptId, appt.getApptId());
		assertEquals(apptDate, appt.getApptDate());
		assertEquals(apptDescription, appt.getApptDescription());
	}

	@Test
	void testSetAppointmentId() {
		Appointment appt = new Appointment(apptId, apptDate, apptDescription);
		assertThrows(NullPointerException.class, () -> appt.setApptId(null));
		assertThrows(IllegalArgumentException.class, () -> appt.setApptId(longApptId));
		appt.setApptId(apptId);
		assertEquals(apptId, appt.getApptId());
	}

	@Test
	void testSetAppointmentDate() {
		Appointment appt = new Appointment(apptId, apptDate, apptDescription);
		assertThrows(NullPointerException.class, () -> appt.setApptDate(null));
		assertThrows(IllegalArgumentException.class, () -> appt.setApptDate(pastApptDate));
		appt.setApptDate(apptDate);
		assertEquals(apptDate, appt.getApptDate());
	}

	@Test
	void testSetAppointmentDescription() {
		Appointment appt = new Appointment(apptId, apptDate, apptDescription);
		assertThrows(NullPointerException.class, () -> appt.setApptDescription(null));
		assertThrows(IllegalArgumentException.class, () -> appt.setApptDescription(longDescription));
		appt.setApptDescription(apptDescription);
		assertEquals(apptDescription, appt.getApptDescription());
	}

}
