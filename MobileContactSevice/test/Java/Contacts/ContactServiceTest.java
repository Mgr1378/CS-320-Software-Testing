package Contacts;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String number;
	protected String address;
	protected String longFirstName;
	protected String longLastName;
	protected String longNumber;
	protected String longAddress;
	protected String longId;
	protected String numbersWithLetters;

	@BeforeEach
	void setUp() {
		id = "122H332BA9";
		firstName = "Mike";
		lastName = "Richards";
		number = "9182089788";
		address = "99999 S 4444 Rd Sallisaw";
		longFirstName = "MichaelBill";
		longLastName = "Richards-Hicks";
		longNumber = "91820899877";
		longAddress = "12345678 South 4344334 Road Sallisaw, Oklahoma 749555555";
		longId = "111222333444555666777888999000";
		numbersWithLetters = "918aaa3987";
	}

	@Test
	void testContactService() {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		assertAll("contacts", () -> assertNotNull(contacts.getContactList().get(0).getId()),
				() -> assertEquals(firstName, contacts.getContactList().get(0).getFirstName()),
				() -> assertEquals(lastName, contacts.getContactList().get(0).getLastName()),
				() -> assertEquals(number, contacts.getContactList().get(0).getNumber()),
				() -> assertEquals(address, contacts.getContactList().get(0).getAddress()));
	}

	@Test
	void updateFirstName() throws Exception {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		contacts.updateFirstName(contacts.getContactList().get(0).getId(), firstName);
		assertEquals(firstName, contacts.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateFirstName(contacts.getContactList().get(0).getId(), longFirstName));
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateFirstName(contacts.getContactList().get(0).getId(), null));
		assertThrows(Exception.class, () -> contacts.updateFirstName(id, firstName));

	}

	@Test
	void updateLastName() throws Exception {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		contacts.updateLastName(contacts.getContactList().get(0).getId(), lastName);
		assertEquals(lastName, contacts.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateLastName(contacts.getContactList().get(0).getId(), longLastName));
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateLastName(contacts.getContactList().get(0).getId(), null));
		assertThrows(Exception.class, () -> contacts.updateLastName(id, lastName));

	}

	@Test
	void updateNumber() throws Exception {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		contacts.updateNumber(contacts.getContactList().get(0).getId(), number);
		assertEquals(number, contacts.getContactList().get(0).getNumber());
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateNumber(contacts.getContactList().get(0).getId(), longNumber));
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateNumber(contacts.getContactList().get(0).getId(), numbersWithLetters));
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateNumber(contacts.getContactList().get(0).getId(), null));
		assertThrows(Exception.class, () -> contacts.updateNumber(id, number));

	}

	@Test
	void updateAddress() throws Exception {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		contacts.updateAddress(contacts.getContactList().get(0).getId(), address);
		assertEquals(address, contacts.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateAddress(contacts.getContactList().get(0).getId(), longAddress));
		assertThrows(IllegalArgumentException.class,
				() -> contacts.updateAddress(contacts.getContactList().get(0).getId(), null));
		assertThrows(Exception.class, () -> contacts.updateAddress(id, address));

	}

	@Test
	void deleteContact() {
		ContactService contacts = new ContactService();
		contacts.newContact(id, firstName, lastName, number, address);
		assertThrows(Exception.class, () -> contacts.deleteContact(id));
		assertAll(() -> contacts.deleteContact(contacts.getContactList().get(0).getId()));
	}
}
