/*
Nicholas Rahbany
CS102
*/

import TennisDatabase.TennisMatchesContainer;
import TennisDatabase.TennisPlayersContainer;

import java.util.*;
import java.io.*;

public class Assignment1 {
    private static File inputFile;
    private static Scanner read;
    private static int playersIndex = 0;
    private static int matchesIndex = 0;
    
    public static void main(String[] args) throws IOException {
        inputFile = new File("inputFile.txt");
        read = new Scanner(inputFile);
        TennisMatchesContainer tmc = new TennisMatchesContainer();
        TennisPlayersContainer tpc = new TennisPlayersContainer();
        readFile(inputFile);
        System.out.println(playersIndex);
        System.out.println(matchesIndex);
        // int[] res = tmc.addMatches(10);
        // res = tmc.addMatches(20);
        // res = tmc.addMatches(30);
        // res = tmc.addMatches(40);
        // res = tmc.addMatches(50);
    }

    public static void readFile(File inputFile) {
        String line;
        String[] data;
        while(read.hasNext()) {
            line = read.nextLine();
            data = line.split("/");

            switch(data[0].charAt(0)) {
                case 'P':
                    // Have to make more secure
                    // tpc.addPlayers(data[1], data[2], data[3], data[4], ata[5]);
                    playersIndex++;
                    break;
                case 'M':
                    // Have to make more secure
                    // tmc.addMatches(data[1], data[2], data[3], data[4], data[5]);
                    matchesIndex++;
                    break;
            }
        }
    }
    
}