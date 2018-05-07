/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import java.lang.Object;

// Interface (package-private) providing the specifications for the TennisMatchesContainer class.
interface TennisMatchesContainerInterface {

    // Desc.: Insert a TennisMatch object (reference) into this container.
    // Input: A TennisMatch object (reference).
    // Output: Throws an exception if match cannot be inserted in this container.
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException;

    // Desc.: Prints all tennis matches to the console.
    // Output: Throws an exception if there are no matches in this container.
    public void printAllMatches() throws TennisDatabaseRuntimeException;

}
