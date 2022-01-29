package problem1;

/**
 * This class represents a user has firstName, lastName, phone number, email address and credential pair.
 */
public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private Credentials credentialPair;

    /**
     * Constructor that creates a new user object.
     * @param firstName - first name of the new User object.
     * @param lastName - last name of the new User object.
     * @param phoneNumber - phone number of the new User object.
     * @param emailAddress - email address of the new User object.
     * @param credentialPair - credential pair of the new User object.
     * */
    public User(String firstName, String lastName, String phoneNumber, String emailAddress, Credentials credentialPair) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.credentialPair = credentialPair;
    }

    /**
     * Helper method to valid the phone number consisting of ten characters.
     * @param phoneNumber - length of the new Time object.
     * @return true if inputs are valid.
     * */
    private boolean validPhoneNumber(String phoneNumber){
        if(phoneNumber.length() == 10){
            return true;
        }
        return false;
    }

    /**
     * Get the first name of this Owner.
     * @return the first name of the Owner.
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the owner.
     * @param firstName - set first name of this owner.
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the last name of the Owner.
     * @return the last name of the Owner.
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the owner.
     * @param lastName- set last name of this owner.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the phone number of the Owner.
     * @return the phone number of the Owner.
     * */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the owner.
     * @param phoneNumber- set phone number of this owner.
     * */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Return the email address of the Owner.
     * @return the email address of the Owner.
     * */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the owner.
     * @param emailAddress- set email address of this owner.
     * */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Return the credential pair of the Owner.
     * @return the credential pair of the Owner.
     * */
    public Credentials getCredentialPair() {
        return credentialPair;
    }

    /**
     * Sets the credential pair of the owner.
     * @param credentialPair- set credential pair of this owner.
     * */
    public void setCredentialPair(Credentials credentialPair) {
        this.credentialPair = credentialPair;
    }
}


