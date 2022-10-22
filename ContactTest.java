package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import contactService.Contact;

public class ContactTest {
	
	@Test
	public void testCreateContact() {
		Contact newContact = new Contact("12345", "firstName", "lastName", "1234567890", "address");
		assertEquals(newContact.getClass(), Contact.class);
		assertEquals("12345", newContact.getContactId());
		assertEquals("firstName", newContact.getFristName());
		assertEquals("lastName", newContact.getLastName());
		assertEquals("1234567890", newContact.getPhoneNumber());
		assertEquals("address", newContact.getAddress());
	}

	@Test
    public void testContactId() {
        // Testing for null
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "firstName", "lastName", "1234567890", "address");
        });

        assertEquals("Invalid Contact ID, needs to be not null and no greater than 10 characters",
                nullException.getMessage());

        // Testing for more than 10 characters
        Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "fristName", "lastName", "phoneNumber", "address");
        });

        assertEquals("Invalid Contact ID, needs to be not null and no greater than 10 characters",
                lengthException.getMessage());
        
        IllegalAccessError idException = assertThrows(IllegalAccessError.class, () -> {
        	Contact newContact = new Contact("12345678", "fName", "lName", "1234567890", "address");
        	newContact.setContactId("123");
        });
        
        assertEquals("Contact ID cannot be changed.", idException.getMessage());

    }

    @Test
    public void testFirstName() {
        // Testing for null
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", null, "lastName", "1234567890", "address");
        });

        assertEquals("Invalid First Name, needs to be not null and no greater than 10 characters",
                nullException.getMessage());

        // Testing for more than 10 characters
        Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "MoreThanTenChars", "lastName", "1234567890", "address");
        });

        assertEquals("Invalid First Name, needs to be not null and no greater than 10 characters",
                lengthException.getMessage());
    }

    @Test
    public void testLastName() {
        // Testing for null
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", null, "1234567890", "address");
        });

        assertEquals("Invalid Last Name, needs to be not null and no greater than 10 characters",
                nullException.getMessage());

        // Testing for more than 10 characters
        Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "MoreThanTenChars", "1234567890", "address");
        });

        assertEquals("Invalid Last Name, needs to be not null and no greater than 10 characters",
                lengthException.getMessage());
    }

    @Test
    public void testPhoneNumber() {
        // Testing for null
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", null, "address");
        });

        assertEquals("Invalid Phone Number", nullException.getMessage());

        // Testing for less than 9 characters
        Exception lessThanTenException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", "123456789", "address");
        });

        assertEquals("Invalid Phone Number", lessThanTenException.getMessage());

        // Testing for more than 10 characters
        Exception moreThanTenException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", "12345678901", "address");
        });

        assertEquals("Invalid Phone Number", moreThanTenException.getMessage());

        // Testing for only digit phone number
        Exception digitException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", "1234567K90", "address");
        });

        assertEquals("All characters need to be digits", digitException.getMessage());
    }

    @Test
    public void testAddress() {
        // Testing for null
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", "1234567890", null);
        });

        assertEquals("Invalid Address, needs to be not null and no greater than 30 characters",
                nullException.getMessage());

        // Testing for more than 30 characters
        Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234", "firstName", "lastName", "1234567890", "ThisHasTooManyMoreThan30Characters");
        });

        assertEquals("Invalid Address, needs to be not null and no greater than 30 characters",
                lengthException.getMessage());
    }

}
