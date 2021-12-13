package Contacts;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	protected String apptId;
	protected Date apptDate;
	protected String apptDescription;
	protected Date pastApptDate;
	protected String longDescription;
	protected String longApptId;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		apptId = "122H332BA9";
		apptDescription = "This is the task that I started";
		longDescription = "This is the task that I started when I was out in the city today and I just like to go to the city";
		longApptId = "111222333444555666777888999000";
		apptDate = new Date(2022, Calendar.JUNE, 26);
		pastApptDate = new Date(2021, Calendar.JULY, 31);

	}

	@Test
	void testAppointmentService() {
		AppointmentService appt = new AppointmentService();
		appt.newAppointment(apptId, apptDate, apptDescription);
		assertAll(apptId, () -> assertNotNull(appt.getAppointmentList().get(0).getApptId()),
				() -> assertEquals(apptDate, appt.getAppointmentList().get(0).getApptDate()),
				() -> assertEquals(apptDescription, appt.getAppointmentList().get(0).getApptDescription()));

	}

	@Test
	void updateDescription() throws Exception {
		AppointmentService appt = new AppointmentService();
		appt.newAppointment(apptId, apptDate, apptDescription);
		appt.setApptDescription(appt.getAppointmentList().get(0).getApptId(), apptDescription);
		assertEquals(apptDescription, appt.getAppointmentList().get(0).getApptDescription());
		assertThrows(IllegalArgumentException.class,
				() -> appt.setApptDescription(appt.getAppointmentList().get(0).getApptId(), longDescription));
		assertThrows(NullPointerException.class,
				() -> appt.setApptDescription(appt.getAppointmentList().get(0).getApptId(), null));
		assertThrows(Exception.class, () -> appt.setApptDescription(apptId, apptDescription));
	}

	@Test
	void deleteAppt() {
		AppointmentService appt = new AppointmentService();
		appt.newAppointment(apptId, apptDate, apptDescription);
		assertThrows(Exception.class, () -> appt.deleteAppt(apptId));
		assertAll(() -> appt.deleteAppt(appt.getAppointmentList().get(0).getApptId()));
	}
}
