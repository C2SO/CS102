import java.io.*;
import java.util.Scanner;

import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;

public class Assignment1 {

    private static File inputFile; // Defines the input file

    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        System.out.println("What file would you like to imput from?\nExample: inputFile.txt");
        String fileInput = read.next();
        inputFile = new File(fileInput); // Set Input file
        TennisDatabase tdb = new TennisDatabase();
        // Check if there are no command line arguments
        // Load Data from file
        tdb.loadFile(inputFile);
        read.close();
        // Check command and activate the relative tennis database opertations
        runProgram();
    }

    public static void runProgram() {
        boolean systemRunning = true;
        int option;
        Scanner user = new Scanner(System.in);
        TennisDatabase tdb = new TennisDatabase();
        while (systemRunning) {
            System.out.println(
                    "Select an option my entering the option's number:\n1. Print Players\n2. Print Matches\n3. Print All Matches For A Player\n4. Add a Player\n5. Add a Match\n\n0. Exit");
            option = user.nextInt();
            switch (option) {
            case 1:
                tdb.printAllPlayers();
                break;
            case 2:
                tdb.printAllMatches();
                break;
            case 3:
                // Create scanner to scan console for id
                String playerId = user.next();
                tdb.printMatchesOfPlayer(playerId);
                break;
            case 4:
                // Create scanner to scan console for player info
                String id = user.next();
                String firstName = user.next();
                String lastName = user.next();
                Integer year = user.nextInt();
                String country = user.next();
                tdb.insertPlayer(id, firstName, lastName, year, country);
                break;
            case 5:
                // Create scanner to scan console for match info
                String idPlayer1 = user.next();
                String idPlayer2 = user.next();
                Integer dayInput = user.nextInt();
                Integer monthInput = user.nextInt();
                Integer yearInput = user.nextInt();
                String tournamentInput = user.next();
                String scoreInput = user.next();
                tdb.insertMatch(idPlayer1, idPlayer2, dayInput, monthInput, yearInput, tournamentInput, scoreInput);
                break;
            case 0:
                systemRunning = false;
                break;
            default:
                System.out.println("Please choose an option that was listed...");
                break;
            }
        }
        user.close();
    }
}