/*
Nicholas Rahbany
CS102
*/

import java.io.*;
import java.util.Scanner;

import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;

public class Assignment2 {

    static TennisDatabase tdb;

    public static void main(String[] args) throws FileNotFoundException {
        // Check if there are no command line arguments
        tdb = new TennisDatabase();
        // Load Data from file
        tdb.loadFile();
        // Check command and activate the relative tennis database opertations
        runProgram();
    }

    public static void runProgram() {
        boolean systemRunning = true; // Tells code if program is running
        int option; // User input option
        Scanner user = new Scanner(System.in); // Scans console for user input
        while (systemRunning) { // While system is running, ask for the user to select an option
            System.out.println(
                    "\nSelect an option my entering the option's number:\n1. Print Players\n2. Print Matches\n3. Print All Matches For A Player\n4. Add a Player\n5. Add a Match\n6. Delete a Player\n7. Export Database\n8. Import Another File\n9. Reset Database\n\n0. Exit\n\n");
            option = user.nextInt(); // Takes in user input
            switch (option) {
            case 1:
                tdb.printAllPlayers(); // Print All Players
                break;
            case 2:
                tdb.printAllMatches(); // Print All Matches
                break;
            case 3:
                System.out.println("Enter a Player ID");
                String playerId = user.next();
                tdb.printMatchesOfPlayer(playerId); // Print Matches of Player Inputed
                break;
            case 4: // Asks user to fill in all data to add a player
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
                tdb.insertPlayer(id, firstName, lastName, year, country); // Adds player
                break;
            case 5: // Asks user to fill in all data to add a match
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
                tdb.insertMatch(idPlayer1, idPlayer2, yearInput, monthInput, dayInput, tournamentInput, scoreInput); // Adds match
                break;
            case 6: // Asks user to giver player ID to delete
                System.out.println("What Player ID would you like to delete?");
                String deletePlayerId = user.next();
                tdb.deletePlayer(deletePlayerId);
                break;
            case 7: // Exports Database
                // tdb.exportFile();
                break;
            case 8: // Imports another file
                tdb.loadFile();
                break;
            case 9: // Resets Database
                // System.out.println();
                // System.out.println("Would you like to export the database? (Y or N)");
                // String export = user.next();
                // if (export == "Y" || export == "y") {
                //     System.out.println("Not implemented yet");
                // }
                tdb.resetDatabase();
                break;
            case 0:
                systemRunning = false; // Stops the program
                break;
            default:
                System.out.println("Please choose an option that was listed..."); // If user selected an option not shown
                break;
            }
        }
        user.close();
    }
}