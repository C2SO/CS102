import java.io.*;
import java.util.Scanner;

import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;

public class Assignment1 {

    private static File inputFile; // Defines the input file
    static TennisDatabase tdb;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        System.out.println("What file would you like to imput from?\nExample: inputFile.txt");
        String fileInput = read.next();
        inputFile = new File(fileInput); // Set Input file
        // Check if there are no command line arguments
        tdb = new TennisDatabase();
        // Load Data from file
        tdb.loadFile(inputFile);
        // Check command and activate the relative tennis database opertations
        runProgram();
    }

    public static void runProgram() {
        boolean systemRunning = true;
        int option;
        Scanner user = new Scanner(System.in);
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
                System.out.println("Enter a Player ID");
                String playerId = user.next();
                tdb.printMatchesOfPlayer(playerId);
                break;
            case 4:
                System.out.println("Enter the Player ID");
                String id = user.next();
                System.out.println("Enter the Player's First Name");
                String firstName = user.next();
                System.out.println("Enter the Player's Last Name");
                String lastName = user.next();
                System.out.println("Enter the Player's Birth Year");
                Integer year = user.nextInt();
                System.out.println("Enter the Player's Country");
                String country = user.next();
                tdb.insertPlayer(id, firstName, lastName, year, country);
                break;
            case 5:
                System.out.println("Enter the First Player's ID");
                String idPlayer1 = user.next();
                System.out.println("Enter the Second Player's ID");
                String idPlayer2 = user.next();
                System.out.println("Enter the Day of the Match");
                Integer dayInput = user.nextInt();
                System.out.println("Enter the Month of the Match");
                Integer monthInput = user.nextInt();
                System.out.println("Enter the Year of the Match");
                Integer yearInput = user.nextInt();
                System.out.println("Enter the Name of the Tournament");
                String tournamentInput = user.next();
                System.out.println("Enter the Score\nExample: 6-4,5-7,6-4,6-4");
                String scoreInput = user.next();
                tdb.insertMatch(idPlayer1, idPlayer2, yearInput, monthInput, dayInput, tournamentInput, scoreInput);
                break;
            case 0:
                systemRunning = false;
                break;
            default:
                System.out.println("Please choose an option that was listed...");
                break;
            }
        }
    }
}