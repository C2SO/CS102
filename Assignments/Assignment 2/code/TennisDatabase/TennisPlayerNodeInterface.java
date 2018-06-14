/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayerNode class.
interface TennisPlayerNodeInterface {

    // Accessors (getters).
    public TennisPlayer getPlayer(); // Gets player

    // Desc.: Prints all tennis matches in the list of this player to the console.
    // Output: Throws an exception if there are no matches in this list.
    public void printMatches() throws TennisDatabaseRuntimeException;

}
