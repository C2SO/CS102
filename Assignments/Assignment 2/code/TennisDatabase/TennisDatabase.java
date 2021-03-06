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
    private static File outFile;
    private static PrintStream write;
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
                TennisPlayer player1 = tpc.getTennisPlayerNode(data[1]).getPlayer();
                TennisPlayer player2 = tpc.getTennisPlayerNode(data[2]).getPlayer();
                TennisMatch m = new TennisMatch(player1, player2, Integer.parseInt(data[3].substring(0, 4)),
                        Integer.parseInt(data[3].substring(4, 6)), Integer.parseInt(data[3].substring(6, 8)), data[4],
                        data[5]);
                tmc.insertMatch(m); // Add Match
                break;
            }
        }
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
        TennisPlayer player1 = tpc.getTennisPlayerNode(idPlayer1).getPlayer();
        TennisPlayer player2 = tpc.getTennisPlayerNode(idPlayer2).getPlayer();
        TennisMatch m = new TennisMatch(player1, player2, year, month, day, tournament, score);
        tmc.insertMatch(m);
    }

    public void resetDatabase() {
        this.tmc = new TennisMatchesContainer();
        this.tpc = new TennisPlayersContainer();
        loadFile();
    }

    public void exportFile() {
        Scanner terminal = new Scanner(System.in);
        boolean valid = false;
        do {
            try {
                write = new PrintStream("outputFile.txt");
                valid = true;
            } catch (FileNotFoundException invalidFile) {
                System.out.println("Input a valid file name");
            }
        } while (!valid);
        tpc.exportPlayers(write);
        tmc.exportMatches(write);
        System.out.println("The database has been exported to outputFile.txt");
    }
}