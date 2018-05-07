package TennisDatabase;

import java.lang.String;

// Interface (package-private) providing the specifications for the TennisDatabase class.
interface TennisDatabaseInterface {

      // Desc.: Prints all tennis players in the database to the console (sorted by
      // id, alphabetically).
      // Output: Throws an exception if there are no players in the database.
      public void printAllPlayers() throws TennisDatabaseRuntimeException;

      // Desc.: Prints all tennis matches of input tennis player (id) to the console
      // (sorted by date, most recent first).
      // Input: The id of the tennis player.
      // Output: Throws an exception if the tennis player (id) does not exists, or if
      // there are no tennis matches.
      public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException;

      // Desc.: Prints all tennis matches in the database to the console (sorted by
      // date, most recent first).
      // Output: Throws an exception if there are no tennis matches in the database.
      public void printAllMatches() throws TennisDatabaseRuntimeException;

      // Desc.: Insert a tennis player into the database.
      // Input: All the data required for a tennis player.
      // Warning: player id must be unique.
      // Output: Throws an exception if player id is already in this container.
      public void insertPlayer(String id, String firstName, String lastName, int year, String country)
                  throws TennisDatabaseRuntimeException;

      // Desc.: Insert a tennis match into the database.
      // Input: All the data required for a tennis match.
      // Warning: match score must be valid.
      // Output: Throws an exception if match score is not valid.
      public void insertMatch(String idPlayer1, String idPlayer2, int day, int month, int year, String tournament,
                  String score) throws TennisDatabaseRuntimeException;

}
