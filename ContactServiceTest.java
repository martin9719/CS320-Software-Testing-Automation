package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import contactService.Contact;
import contactService.ContactService;

public class ContactServiceTest {

	public static Contact contact = new Contact("123456", "firstName", "lastName", "1234567890", "address");
    public static ContactService contactService = new ContactService();

//    @BeforeAll
//    public void setUp() {
//    	contactService.addNewContact(contact);
//    }
//    
//    @AfterAll
//    public void afterEach() {
//    	contactService.removeContact(contact.getContactId());
//    }
    
    @Test
    public void testAddNewContact() {
        contactService.addNewContact(contact);

        // Testing for adding new contact
        assertTrue(contactService.contacts.containsKey(contact.getContactId()));

        // Testing for already existing contact
        Exception existingException = assertThrows(IllegalArgumentException.class, () -> {
            Contact doubelContact = new Contact("123456", "firstName", "lastName", "1234567890", "address");
            contactService.addNewContact(doubelContact);
        });

        assertEquals("Contact already exists.", existingException.getMessage());
        // removing the contact that was added at the beginning
        contactService.removeContact(contact.getContactId());

    }

    @Test
    public void testRemoveContact() {
         contactService.addNewContact(contact);
        // Testing for contact that doesn't exist
        Exception notExistingException = assertThrows(NullPointerException.class, () -> {
            Contact newContact = new Contact("1234567", "firstName", "lastName",
                    "1234567890", "address");
            contactService.removeContact(newContact.getContactId());
        });

        assertEquals("No contact exists with the specified contact ID.",
                notExistingException.getMessage());

//        assertFalse(contactService.contacts.containsKey(contact.getContactId()));
        contactService.removeContact(contact.getContactId());
    }

    @Test
    public void testUpdateId() {

        // Testing for contact that doesn't exist, this will be the same
        // for all
        // updates,
        // except for updating contact ID
        Exception notExistingException = assertThrows(NullPointerException.class, () -> {
            Contact newContact = new Contact("1234567", "firstName", "lastName",
                    "1234567890", "address");
            contactService.updateFirstName(newContact.getContactId(), "NewName");
        });

        assertEquals("No contact exists with the specified contact ID.",
                notExistingException.getMessage());

//        // Adding a contact to contacts
//        contactService.addNewContact(contact);

//        contactService.removeContact(contact.getContactId());
    }
    
    @Test
    public void testUpdateContactId() {
    	// Adding a contact to contacts
        contactService.addNewContact(contact);
     // Testing to see if updating contact id will throw an error
        IllegalAccessError updatingContactId = assertThrows(IllegalAccessError.class, () -> {
            contactService.updateContactID("123456", "12345679");
        });

        assertEquals("Contact ID cannot be changed.", updatingContactId.getMessage());
        contactService.removeContact(contact.getContactId());
    }
    
    @Test
    public void testUpdateFirstName() {
    	contactService.addNewContact(contact);
    	// Updating the first name of the contact
        contactService.updateFirstName("123456", "NewFName");
        // Testing to check if the updated first name matches
        assertEquals("NewFName", contactService.contacts.get("123456").getFristName());
        contactService.removeContact(contact.getContactId());
    }
    
    @Test
    public void testUpdateLastName() {
    	contactService.addNewContact(contact);
    	// Updating the last name of the contact
        contactService.updateLastName("123456", "newLName");
        // Testing to check if the updated last name matches
        assertEquals("newLName", contactService.contacts.get("123456").getLastName());
        contactService.removeContact(contact.getContactId());
    }
    
    @Test
    public void testUpdatePhoneNumber() {
    	contactService.addNewContact(contact);
    	// Updating the phone number of the contact
        contactService.updatePhoneNumber("123456", "1111111111");
        // Testing to check if the updated phone number matches
        assertEquals("1111111111", contactService.contacts.get("123456").getPhoneNumber());
        contactService.removeContact(contact.getContactId());
    }
    
    @Test
    public void testUpdateAddress() {
    	contactService.addNewContact(contact);
    	// Updating the first name of the contact
        contactService.updateAddress("123456", "newAddress");
        // Testing to check if the updated first name matches
        assertEquals("newAddress", contactService.contacts.get("123456").getAddress());
        contactService.removeContact(contact.getContactId());
    }
    

}
