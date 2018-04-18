
/*
Nicholas Rahbany
CS102
*/

import TennisDatabase.TennisMatchesContainer;
import TennisDatabase.TennisPlayersContainer;

import java.util.*;
import java.io.*;

public class Assignment1 {

    private static File inputFile; // Defines the input file
    private static Scanner read; // Used to read the input file
    private static Scanner user; // Used to read the user's input

    public static void main(String[] args) throws IOException {
        inputFile = new File("inputFile.txt"); // Set Input file
        read = new Scanner(inputFile); // Create the Scanner object
        user = new Scanner(System.in);
        TennisMatchesContainer tmc = new TennisMatchesContainer(); // Create TennisMatchesContainer variable
        TennisPlayersContainer tpc = new TennisPlayersContainer(); // Create TennisPlayersContainter variable
        readFile(inputFile); // Read the file
        runProgram();
        read.close();
        user.close();
    }

    public static void readFile(File inputFile) {
        String line; // Defining a ling in the input file
        String[] data; // An array of the line when parsed
        while (read.hasNext()) { // If there is a line that hasn't been scanned

            line = read.nextLine(); // Scan the line
            data = line.split("/"); // Parse the line

            switch (data[0].charAt(0)) { // Check to see if the line is a player or a match
            case 'P': // If it is a player
                // Have to make more secure
                // tpc.addPlayers(data[1], data[2], data[3], data[4], ata[5]);
                break;
            case 'M': // If it is a match
                // Have to make more secure
                // tmc.addMatches(data[1], data[2], data[3], data[4], data[5]);
                break;
            }
        }
    }

    public static void runProgram() {
        boolean systemRunning = true;
        int option;
        while (systemRunning) {
            System.out.println(
                    "Select an option my entering the option's number:\n1. Print Players\n2. Print Matches\n3. Print All Matches For A Player\n4. Add a Player\n5. Add a Match\n\n0. Exit");
            option = user.nextInt();
            switch (option) {
            case 1:
                // Print Players
                break;
            case 2:
                // Print Matches
                break;
            case 3:
                // Print All Matches For A Player
                break;
            case 4:
                // Add a Player
                break;
            case 5:
                //Add a Match
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