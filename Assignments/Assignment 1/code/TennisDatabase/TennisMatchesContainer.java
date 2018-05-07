/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {

    // Defines all variables used in class
    private TennisMatch[] tma;
    private int sizeLogical;
    private int sizePhysical;

    public TennisMatchesContainer() { // Cunstructor for TennisMatchesContainer
        sizePhysical = 2;
        sizeLogical = 0;
        tma = new TennisMatch[sizePhysical];
    }

    public void insertMatch(TennisMatch m) { // Inserts match into a resizable array
        if (sizeLogical == sizePhysical) {
            TennisMatch[] tmn = new TennisMatch[tma.length + 1];
            for (int index = 0; index < tma.length; index++) {
                tmn[index] = tma[index];
            }
            tma = tmn;
            sizePhysical++;
        }
        int index;
        for (index = 0; (index < sizeLogical) && (m.compareTo(tma[index]) < 0); index++) {
        }
        int insert = index;
        if (insert == sizeLogical) {
            tma[sizeLogical] = m;
            sizeLogical++;
        } else {
            for (int i = sizeLogical - 1; i >= insert; i--) {
                tma[i + 1] = tma[i];
            }
            tma[insert] = m;
            sizeLogical++;
        }
    }

    public void printAllMatches() throws TennisDatabaseRuntimeException {
        if (tma.length == 0) {
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            for (int i = 0; i < sizeLogical; i++) {
                tma[i].print();
            }
        }
    }

    public int[] getPlayerScore(String id) throws TennisDatabaseRuntimeException {
        int[] score = new int[2];
        int wins = 0;
        int losses = 0;
        if (tma.length == 0) {
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            int matchIndex = 0;
            for (int i = 0; i < sizeLogical; i++) {
                if (tma[i].getPlayer1Id().equals(id)) {
                    matchIndex++;
                } else if (tma[i].getPlayer2Id().equals(id)) {
                    matchIndex++;
                }
                TennisMatch[] playerMatches = new TennisMatch[matchIndex];
                matchIndex = 0;
                for (int index = 0; index < sizeLogical; index++) {
                    if (tma[i].getPlayer1Id().equals(id)) {
                        playerMatches[matchIndex] = tma[i];
                        matchIndex++;
                    } else if (tma[i].getPlayer2Id().equals(id)) {
                        playerMatches[matchIndex] = tma[i];
                        matchIndex++;
                    }
                }
                for ( int index = 0; index < playerMatches.length; index++) {
                    if (playerMatches[i].getWinner() == 1) {
                        wins++;
                    } else if (playerMatches[i].getWinner() == -1) {
                        losses++;
                    }
                }
            }
        }
        score[0] = wins;
        score[1] = losses;
        return score;
    }
}