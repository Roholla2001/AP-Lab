/**
 * This class represents a vote from a person in a date
 * @author Roholla Ahmadzadeh
 * @version 1.0
 */
public class Vote {
    private Person person;
    private String date;

    /**
     * Constructs a new vote with a specified voter and date
     * @param person the voter
     * @param date the date of the vote
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * @return the voter
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @return the date of the vote
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the full name of the voter
     */
    @Override
    public String toString() {
        return person.toString();
    }
}
