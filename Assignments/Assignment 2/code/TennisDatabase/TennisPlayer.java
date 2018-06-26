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
    public String year;
    public String country;
    public boolean dummy;

    public TennisPlayer(String idIn, String firstNameIn, String lastNameIn, String yearIn, String countryIn) { // Constructor
        this.id = idIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.year = yearIn;
        this.country = countryIn;
        this.dummy = false;
    }

    public TennisPlayer(String idIn, String firstNameIn, String lastNameIn, String yearIn, String countryIn, Boolean dummyIn) { // Constructor
        this.id = idIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.year = yearIn;
        this.country = countryIn;
        this.dummy = dummyIn;
    }

    public String getId() { // Returns player's ID
        return this.id;
    }

    public void setId(String input) { // Sets player's ID
        this.id = input;
    }

    public String getFirstName() { // Returns player's first name
        return this.firstName;
    }

    public void setFirstName(String input) { // Sets player's first name
        this.firstName = input;
    }

    public String getLastName() { // Return the player's last name
        return this.lastName;
    }

    public void setLastName(String input) { // Sets player's last name
        this.lastName = input;
    }

    public String getBirthYear() { // Return the player's birth year
        return this.year;
    }

    public void setBirthYear(String input) { // Sets player's birth year
        this.year = input;
    }

    public String getCountry() { // Return the player's country
        return this.country;
    }

    public void setCountry(String input) { // Sets player's country
        this.country = input;
    }

    public boolean getDummy() {
        return this.dummy;
    }

    public int compareTo(TennisPlayer tp) {
        String player2 = tp.getId();
        if ((this.id.compareTo(player2)) > 0)// Id comes after tp
            return 1;
        if ((this.id.compareTo(player2)) == 0)// Id == tp
            return 0;
        if ((this.id.compareTo(player2)) < 0)// Id goes before tp
            return -1;
        return 1;
    }

    public void print() { // Prints the player
        System.out.println(toString());
    }

    public String toString() { // Stringifys the player
        String result = this.id + ": " + this.firstName + " " + this.lastName + ", " + this.year + ", " + this.country;
        return result;
    }
}