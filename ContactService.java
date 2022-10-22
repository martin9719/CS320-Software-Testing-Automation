package contactService;

import java.util.HashMap;

public class ContactService {
	public HashMap<String, Contact> contacts = new HashMap<>();

    public void addNewContact(Contact newContact) {
        if (this.contacts.containsKey(newContact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists.");
        } else {
            this.contacts.put(newContact.getContactId(), newContact);
        }
    }

    public void contactExists(String contactId) {
        if (!this.contacts.containsKey(contactId)) {
            throw new NullPointerException("No contact exists with the specified contact ID.");
        }
    }

    public void removeContact(String contactId) {
        contactExists(contactId);
        this.contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        contactExists(contactId);
        contacts.get(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        contactExists(contactId);
        contacts.get(contactId).setLastName(lastName);
    }

    public void updatePhoneNumber(String contactId, String phoneNum) {
        contactExists(contactId);
        contacts.get(contactId).setPhoneNumber(phoneNum);
    }

    public void updateAddress(String contactId, String address) {
        contactExists(contactId);
        contacts.get(contactId).setAddress(address);
    }

    public void updateContactID(String contactId, String newId) {
        throw new IllegalAccessError("Contact ID cannot be changed.");
    }
}
