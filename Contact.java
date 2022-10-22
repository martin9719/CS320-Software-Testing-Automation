package contactService;

public class Contact {
	private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    final static int CHARACTER_LENGTH = 10;
    final static int ADDRESS_LENGTH = 30;

    public Contact(String contactId, String fristName, String lastName, String phoneNumber, String address) {
        this.contactId = validateString(contactId, "Contact ID");
        this.firstName = validateString(fristName, "First Name");
        this.lastName = validateString(lastName, "Last Name");
        this.phoneNumber = validateNumber(phoneNumber);
        this.address = validateString(address, "Address");
    }

    private static String validateString(String varString, String varName) {

        int stringLength = CHARACTER_LENGTH;
        // will change the string length to the right number depending on the name of
        // the
        // variable
        if (varName.equals("Address")) {
            stringLength = ADDRESS_LENGTH;
        }
        // if block to validate the string is not null and less than
        if (varString == null || varString.length() > stringLength) {
            throw new IllegalArgumentException(
                    "Invalid " + varName + ", needs to be not null and no greater than " + stringLength
                            + " characters");
        }

        return varString;
    }

    private static String validateNumber(String varString) {
        if (varString == null || varString.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        } else {
            char[] array = varString.toCharArray();
            for (char character : array) {
                if (!Character.isDigit(character)) {
                    throw new IllegalArgumentException("All characters need to be digits");
                }
            }
        }
        return varString;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFristName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = validateString(firstName, "First Name");
    }

    public void setLastName(String lastName) {
        this.lastName = validateString(lastName, "Last Name");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validateNumber(phoneNumber);
    }

    public void setAddress(String address) {
        this.address = validateString(address, "Address");
    }

    public void setContactId(String contactId) {
        throw new IllegalAccessError("Contact ID cannot be changed.");
    }
}
