package TennisDatabase;

import java.io.*;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface {
    private TennisPlayersContainer tpc = new TennisPlayersContainer();
    private TennisMatchesContainer tmc = new TennisMatchesContainer();

    public TennisDatabase() {
    }

    public void loadFile(File inputFile) throws FileNotFoundException {
        String line; // Defining a ling in the input file
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
                TennisMatch m = new TennisMatch(data[1], data[2], Integer.parseInt(data[3]), data[4], data[5]);
                tmc.insertMatch(m); // Add Match
                break;
            }
        }
        read.close();
    }

    public void printAllPlayers() {
        tpc.printAllPlayers();
    }

    public void printMatchesOfPlayer(String playerId) {
        tpc.printMatchesOfPlayer(playerId);
    }

    public void printAllMatches() {
        tmc.printAllMatches();
    }

    public void insertPlayer(String id, String firstName, String lastName, int year, String country) {
        TennisPlayer p = new TennisPlayer(id, firstName, lastName, year, country);
        tpc.insertPlayer(p);
    };

    public void insertMatch(String idPlayer1, String idPlayer2, int date, String tournament, String score) {
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, date, tournament, score);
        tmc.insertMatch(m);
    };
}