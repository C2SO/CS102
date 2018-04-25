import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/*
Nicholas Rahbany
CS 102
*/

public class TennisPlayer implements TennisPlayerInterface {

    private String id; // Unique Key, Read-only
    private String firstName;
    private String lastName;
    private int birthYear;
    private String country;
    private boolean dummy;
    private TennisPlayerWinLossRecord record; // Read-only

    // constructors
    public TennisPlayer(String id, String firstName, String lastName, int birthYear, String country, boolean dummy, TennisPlayerWinLossRecord record) {
        throw NotImplementedException;
    }

    public toString() {
        throw NotImplementedException;
    }
}