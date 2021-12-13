package Contacts;

public class Contact {

	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private String id;
	private static final int NUMBER_LENGTH = 10;
	private static final byte ID_LENGTH = 10;
	private static final byte NAME_LENGTH = 10;
	private static final byte ADDRESS_LENGTH = 30;

	public Contact(String newUniqueId, String firstName, String lastName, String number, String address) {
		updateId(newUniqueId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updateNumber(number);
		updateAddress(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}

	protected void updateId(String newUniqueId) {
		if (newUniqueId == null || newUniqueId.length() > ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID.");
		} else {
			this.id = newUniqueId;
		}
	}

	protected void updateFirstName(String firstName) {
		if (firstName == null || firstName.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid First Name.");
		} else {
			this.firstName = firstName;
		}

	}

	protected void updateLastName(String lastName) {
		if (lastName == null || lastName.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid Last Name.");
		} else {
			this.lastName = lastName;
		}
	}

	protected void updateNumber(String number) {
		String regex = "[0-9]+";

		if (number == null || number.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("Invalid Phone Number.");
		} else if (!number.matches(regex)) {
			throw new IllegalArgumentException("Phone Number can only have numbers, try again.");
		} else {
			this.number = number;
		}

	}

	protected void updateAddress(String address) {
		if (address == null || address.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address Invalid.");
		} else {
			this.address = address;
		}

	}

}