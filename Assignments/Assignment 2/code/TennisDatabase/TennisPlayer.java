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
        return this.firstName;
    }

    public String getLastName() { // Return the player's last name
        return this.lastName;
    }

    public int getBirthYear() { // Return the player's birth year
        return this.year;
    }

    public String getCountry() { // Return the player's country
        return this.country;
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