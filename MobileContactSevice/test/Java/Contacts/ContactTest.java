package Contacts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {

	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private String id;
	private String firstNameLong;
	private String lastNameLong;
	private String numberLong;
	private String numberWithLetters;
	private String addressLong;
	private String idLong;
	private String somethingNull;
	private String numberShort;

	@BeforeEach
	void setUp() {
		id = "122H332BA9";
		firstName = "First Name";
		lastName = "Last Name";
		number = "5555555555";
		address = "1234 Main St.";
		firstNameLong = "This is the first name that is too long";
		lastNameLong = "This is the last name that is too long";
		numberLong = "55555555555";
		numberWithLetters = "555555555a";
		numberShort = "555555555";
		addressLong = "1234567890 Southeast Northwest around the side";
		idLong = "111222333444555666777888999000";
		somethingNull = null;
	}

	@Test
	void testContactAddress() {
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getId().equals(id));
		assertTrue(contact.getFirstName().equals(firstName));
		assertTrue(contact.getLastName().equals(lastName));
		assertTrue(contact.getNumber().equals(number));
		assertTrue(contact.getAddress().equals(address));
	}

	@Test
	void testContactIdLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(idLong, firstName, lastName, number, address);
		});
	}

	@Test
	void testContactFisrtNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstNameLong, lastName, number, address);
		});
	}

	@Test
	void testContactLastNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastNameLong, number, address);
		});
	}

	@Test
	void testContactNumerLengthLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, numberLong, address);
		});
	}

	@Test
	void testContactNumerLengthShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, numberShort, address);
		});
	}

	@Test
	void testContactNumberIsNumbers() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, numberWithLetters, address);
		});
	}

	@Test
	void testContactAddressLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, number, addressLong);
		});
	}

	@Test
	void testNullId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(somethingNull, firstName, lastName, number, address);
		});
	}

	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, somethingNull, lastName, number, address);
		});
	}

	@Test
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, somethingNull, number, address);
		});
	}

	@Test
	void testNullNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, somethingNull, address);
		});
	}

	@Test
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstName, lastName, number, somethingNull);
		});
	}

}
