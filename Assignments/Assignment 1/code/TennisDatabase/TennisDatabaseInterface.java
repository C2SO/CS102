
/*
Nicholas Rahbany
CS 102
*/

// Interface providing the specifications for the TennisDatabse class
import java.lang.Object;

interface TennisDatabaseInterface {

    public void printAllPlayers();

    public void printMatchesOfPlayers(String playerId);

    public void printAllMatches();

    public void addPlayer(String id, String firstName, String lastName, int year, String country);

    public void addMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String country, String score1, String score2, String score3);

}