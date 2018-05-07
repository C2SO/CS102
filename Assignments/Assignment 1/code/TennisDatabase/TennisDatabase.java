package TennisDatabase;

import java.io.*;
import java.util.*;

public class TennisDatabase implements TennisDatabaseInterface {

    private TennisPlayersContainer tpc; // Sets tpc to TennisPlayersContainer object
    private TennisMatchesContainer tmc; // Sets tmc to TennisMatchesContainer object

    public TennisDatabase() {
        tpc = new TennisPlayersContainer(); // Instantiates tpc
        tmc = new TennisMatchesContainer(); // Instantiates tmc
    }

    public void loadFile(File inputFile) throws FileNotFoundException { // Loads file
        String line; // Defining a line in the input file
        String[] data; // An array of the line when parsed
        Scanner read = new Scanner(inputFile);
        while (read.hasNext()) { // If there is a line that hasn't been scanned

            line = read.nextLine(); // Scan the line
            data = line.split("/"); // Parse the line

            switch (data[0].charAt(0)) { // Check to see if the line is a player or a match
            case 'P':
                TennisPlayer p = new TennisPlayer(data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]);
                tpc.insertPlayer(p); // Add Player
                break;
            case 'M':
                TennisMatch m = new TennisMatch(data[1], data[2], Integer.parseInt(data[3].substring(0,4)), Integer.parseInt(data[3].substring(4,6)), Integer.parseInt(data[3].substring(6,8)), data[4], data[5]);
                tmc.insertMatch(m); // Add Match
                tpc.insertMatch(m); // Add Match for players
                break;
            }
        }
    }

    public void printAllPlayers() {
        tpc.printAllPlayers(); // Prints all players
    }

    public void printMatchesOfPlayer(String playerId) {
        tpc.printMatchesOfPlayer(playerId); // Prints all matches for player
    }

    public void printAllMatches() {
        tmc.printAllMatches(); // Prints all matches
    }

    public void insertPlayer(String id, String firstName, String lastName, int year, String country) {
        TennisPlayer p = new TennisPlayer(id, firstName, lastName, year, country);
        tpc.insertPlayer(p); // Adds player
    };

    public void insertMatch(String idPlayer1, String idPlayer2, int day, int month, int year, String tournament, String score) {
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, day, month, year, tournament, score);
        tmc.insertMatch(m); // Adds match
    };
}