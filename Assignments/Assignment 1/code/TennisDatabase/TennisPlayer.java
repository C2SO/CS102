/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayer implements TennisPlayerInterface {

    // Defines variables used in class
    public String id;
    public String firstName;
    public String lastName;
    public int year;
    public String country;

    public TennisPlayer(String idIn, String firstNameIn, String lastNameIn, int yearIn, String countryIn) { // Constructor
        this.id = idIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.year = yearIn;
        this.country = countryIn;
    }

    public String getId() { // Returns player's ID
        return this.id;
    }

    public String getFirstName() { // Returns player's first name
        return null;
    }

    public String getLastName() { // Return the player's last name
        return null;
    }

    public int getBirthYear() { // Return the player's birth year
        return 0;
    }

    public String getCountry() { // Return the player's country
        return null;
    }

    public void print() { // Prints the player
        System.out.println(toString());
    }

    public String toString() { // Stringifys the player
        String result = this.id + ": " + this.firstName + " " + this.lastName + ", " + this.year + ", " + this.country;
        return result;
    }
}