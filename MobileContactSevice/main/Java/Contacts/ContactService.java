package Contacts;

import java.util.ArrayList; // Resizable Array for contact list
import java.util.List; // ordered objects to access by index
import java.util.UUID; // Universally Unique Identifier

public class ContactService {

	private List<Contact> contactList = new ArrayList<>();

	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	private Contact searchContacts(String id) throws Exception {
		for (Contact contact : contactList) {
			if (contact.getId().equals(id)) {
				return contact;
			}
		}
		throw new Exception("Contact does not exist. Try Again");
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void newContact(String id, String firstName, String lastName, String number, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, number, address);
		contactList.add(contact);
	}

	public void updateFirstName(String uniqueId, String firstName) throws Exception {
		searchContacts(uniqueId).updateFirstName(firstName);
	}

	public void updateLastName(String uniqueId, String lastName) throws Exception {
		searchContacts(uniqueId).updateLastName(lastName);
	}

	public void updateNumber(String uniqueId, String number) throws Exception {
		searchContacts(uniqueId).updateNumber(number);
	}

	public void updateAddress(String uniqueId, String address) throws Exception {
		searchContacts(uniqueId).updateAddress(address);
	}

	public void deleteContact(String uniqueId) throws Exception {
		contactList.remove(searchContacts(uniqueId));
	}

}