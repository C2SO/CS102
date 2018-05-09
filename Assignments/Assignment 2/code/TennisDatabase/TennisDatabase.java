/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import java.io.*;
import java.util.*;

public class TennisDatabase implements TennisDatabaseInterface {
    private TennisPlayersContainer tpc;
    private TennisMatchesContainer tmc;
    private static File inFile;
    private static Scanner read;

    public TennisDatabase() {
        tpc = new TennisPlayersContainer();
        tmc = new TennisMatchesContainer();
    }

    public void loadFile() {
        Scanner terminal = new Scanner(System.in);
        String fileName;
        boolean valid = false;
        do {
            try {
                System.out.println("Enter a file name: ");
                System.out.println("Example: inputFile.txt");
                fileName = terminal.next();
                inFile = new File(fileName);
                read = new Scanner(inFile);
                valid = true;
            } catch (FileNotFoundException invalidFile) {
                System.out.println("Input a valid file name");
            }
        } while (!valid);
        String line; // Defining a line in the input file
        String[] data; // An array of the line when parsed
        while (read.hasNext()) { // If there is a line that hasn't been scanned
            line = read.nextLine(); // Scan the line
            data = line.split("/"); // Parse the line
            switch (data[0].charAt(0)) { // Check to see if the line is a player or a match
            case 'P':
                insertPlayer(data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]); // Add Player
                break;
            case 'M':
                TennisMatch m = new TennisMatch(data[1], data[2], Integer.parseInt(data[3].substring(0, 4)),
                        Integer.parseInt(data[3].substring(4, 6)), Integer.parseInt(data[3].substring(6, 8)), data[4],
                        data[5]);
                tmc.insertMatch(m); // Add Match
                tpc.insertMatch(m); // Add Match for players
                break;
            }
        }
        read.close();
    }

    public void printAllPlayers() {
        tpc.printAllPlayers(tmc); // Prints all players
    }

    public void printMatchesOfPlayer(String Id) {
        tmc.printMatchesOfPlayer(Id, tpc); // Prints matches of players
    }

    public void printAllMatches() {
        tmc.printAllMatches(tpc); // Prints all matches
    }

    public void insertPlayer(String id, String firstName, String lastName, int year, String country) { // Inserts player
        TennisPlayer p = new TennisPlayer(id, firstName, lastName, year, country);
        tpc.insertPlayer(p);
    }

    public void deletePlayer(String deletePlayerId) {
        tpc.deletePlayer(deletePlayerId);
    }

    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament,
            String score) { // Inserts a match
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month, day, tournament, score);
        tmc.insertMatch(m);
        tpc.insertMatch(m);
    }

    public void resetDatabase() {
        this.tmc = new TennisMatchesContainer();
        this.tpc = new TennisPlayersContainer();
        loadFile();
    }
}