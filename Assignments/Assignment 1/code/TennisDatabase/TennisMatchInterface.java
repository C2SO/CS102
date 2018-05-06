/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisMatch class.
// See: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
interface TennisMatchInterface extends Comparable<TennisMatch> {

    // Accessors (getters).
    public String getPlayer1Id(); // Gets 1st Player's ID

    public String getPlayer2Id(); // Get 2nd Player's ID

    public int getDateYear(); // Get's the year of the match

    public int getDateMonth(); // Gets the month of the match

    public int getDateDay(); // Gets the day of the match

    public String getTournament(); // Gets the name of the match(tournament)

    public String getScore(); // Gets the score of the match

    public int getWinner(); // Gets the winner of the match

    public void print(); // Prints this tennis match on the console.

}
