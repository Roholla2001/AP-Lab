/**
 * A class to represent a person
 * @author Roholla Ahmadzadeh
 * @version 1.0
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a new person with a specified first name and last name
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the first name of this person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the last name of this person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the string representation of a person
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
