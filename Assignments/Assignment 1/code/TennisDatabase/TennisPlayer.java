package TennisDatabase;

public class TennisPlayer implements TennisPlayerInterface {

    public String id;
    public String firstName;
    public String lastName;
    public int year;
    public String country;

    public TennisPlayer(String id, String firstName, String lastName, int year, String country) {

    }

    public int compareTo(TennisPlayer p) {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public int getBirthYear() {
        return 0;
    }

    public String getCountry() {
        return null;
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return null;
    }
}