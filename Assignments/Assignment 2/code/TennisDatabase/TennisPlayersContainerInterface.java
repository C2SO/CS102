/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayersContainer class.
interface TennisPlayersContainerInterface {

    // Desc.: Insert a TennisPlayer object (reference) into this container.
    // Input: A TennisPlayer object (reference).
    // Output: Throws an exception if player id is already in this container.
    public void insertPlayer(TennisPlayer p) throws TennisDatabaseRuntimeException;

    // Desc.: Insert a TennisMatch object (reference) into this container.
    // Input: A TennisMatch object (reference).
    // Output: Throws an exception if the tennis match score is not valid.
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException;

    // Desc.: Prints all tennis players to the console.
    // Output: Throws an exception if there are no players in this container.
    public void printAllPlayers(TennisMatchesContainer tmc) throws TennisDatabaseRuntimeException;

    // Desc.: Prints all tennis matches of input tennis player (id).
    // Input: The id of the tennis player.
    // Output: Throws an exception if the tennis player (id) does not exits, or if
    // there are no tennis matches.
    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException;

}
