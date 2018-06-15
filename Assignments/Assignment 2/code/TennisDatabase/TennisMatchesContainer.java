/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import java.util.LinkedList;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {

    // Defines all variables used in class
    private LinkedList<TennisMatch> tml;

    public TennisMatchesContainer() { // Cunstructor for TennisMatchesContainer
        tml = new LinkedList<TennisMatch>();
    }

    public void insertMatch(TennisMatch m) { // Inserts match into a resizable array
        if (tml.size() == 0) {
            tml.add(m);
        } else {
            boolean added = false;
            int i = 0;
            TennisMatch temp;
            while (!added && i < tml.size()) {
                temp = tml.get(i);
                if (temp.compareTo(m) > 0) {
                    tml.add(i - 1, m);
                    added = true;
                }
                i++;
            }
            if (added == false) {
                tml.add(i, m);
            }
        }
    }

    public void printAllMatches(TennisPlayersContainer tpc) throws TennisDatabaseRuntimeException {
        System.out.println();
        System.out.println("Tennis Matches on Record: ");
        if (tml.size() == 0) {
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            for (int i = 0; i < tml.size(); i++) {
                tml.get(i).print(tpc);
            }
        }
        System.out.println();
    }

    public String getPlayerScoreList(String id) throws TennisDatabaseRuntimeException {
        String winLoss = "";
        int totalWins = 0;
        int totalLoss = 0;
        if (tml.size() == 0) {
            throw new TennisDatabaseRuntimeException("There are no tennis matches for that player\n");
        } else {
            int matchCount = 0;
            for (int i = 0; i < tml.size(); i++) {
                if (tml.get(i).getPlayer1Id().equals(id))
                    matchCount++;
                if (tml.get(i).getPlayer2Id().equals(id))
                    matchCount++;
            }
            TennisMatch[] pMatches = new TennisMatch[matchCount];// make array of size equal to the number of matches a
                                                                 // player has
            matchCount = 0;// reset match count
            for (int i = 0; i < tml.size(); i++) {
                if (tml.get(i).getPlayer1Id().equals(id)) {
                    pMatches[matchCount] = tml.get(i);
                    if (getScore(pMatches[matchCount].getScore(), id, pMatches[matchCount]) == 1) {
                        totalWins++;
                    } else {
                        totalLoss++;
                    }
                    matchCount++;
                }
                if (tml.get(i).getPlayer2Id().equals(id)) {
                    pMatches[matchCount] = tml.get(i);
                    if (getScore(pMatches[matchCount].getScore(), id, pMatches[matchCount]) == 1) {
                        totalWins++;
                    } else {
                        totalLoss++;
                    }
                    matchCount++;
                }
            }
            winLoss = "" + totalWins + " - " + totalLoss;
        }
        return winLoss;
    }

    public int getScore(String score, String id, TennisMatch pMatches) throws TennisDatabaseRuntimeException {
        int scoreWin = 0;
        int scoreLoss = 0;
        if (pMatches.getPlayer1Id().equalsIgnoreCase(id)) {
            if (score.length() == 3) {
                String player1 = score.substring(0, 1);
                String player2 = score.substring(score.indexOf('-') + 1, score.length());
                if (Integer.parseInt(player1) > Integer.parseInt(player2)) {
                    scoreWin++;
                } else {
                    scoreLoss++;
                }
            } else {
                String player1 = score.substring(0, 1);
                String player2 = score.substring(score.indexOf('-') + 1, score.indexOf('-') + 2);
                if (Integer.parseInt(player1) > Integer.parseInt(player2)) {
                    scoreWin++;
                    if (score.substring(score.indexOf(',') + 1).length() == 3) {
                        getScore(score.substring(score.indexOf(',') + 1), id, pMatches);
                    } else {
                        getScore(score.substring(score.indexOf(',') + 1, score.length()), id, pMatches);
                    }
                } else {
                    scoreLoss++;
                    if (score.substring(score.indexOf(',') + 1).length() == 3) {
                        getScore(score.substring(score.indexOf(',') + 1), id, pMatches);
                    } else {
                        getScore(score.substring(score.indexOf(',') + 1, score.length()), id, pMatches);
                    }
                }
            }
        } else {
            if (score.length() == 3) {
                String player1 = score.substring(0, 1);
                String player2 = score.substring(score.indexOf('-') + 1, score.length());
                if (Integer.parseInt(player1) < Integer.parseInt(player2)) {
                    scoreWin++;
                } else {
                    scoreLoss++;
                }
            } else {
                String player1 = score.substring(0, 1);
                String player2 = score.substring(score.indexOf('-') + 1, score.indexOf('-') + 2);
                if (Integer.parseInt(player1) < Integer.parseInt(player2)) {
                    scoreWin++;
                    if (score.substring(score.indexOf(',') + 1).length() == 3) {
                        getScore(score.substring(score.indexOf(',') + 1), id, pMatches);
                    } else {
                        getScore(score.substring(score.indexOf(',') + 1, score.length()), id, pMatches);
                    }
                } else {
                    scoreLoss++;
                    if (score.substring(score.indexOf(',') + 1).length() == 3) {
                        getScore(score.substring(score.indexOf(',') + 1), id, pMatches);
                    } else {
                        getScore(score.substring(score.indexOf(',') + 1, score.length()), id, pMatches);
                    }
                }
            }
        }
        if (scoreWin > scoreLoss) {
            return 1;
        } else {
            return -1;
        }
    }

    public void printMatchesOfPlayer(String Id, TennisPlayersContainer tpc) throws TennisDatabaseRuntimeException {
        if (tml.size() == 0) { // if no matches
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            for (int i = 0; i < tml.size(); i++) { // for all matches

                if (tml.get(i).getPlayer1Id().equals(Id))
                    tml.get(i).print(tpc);// print if player id1 is id
                if (tml.get(i).getPlayer2Id().equals(Id))
                    tml.get(i).print(tpc);// print if player id2 is id
            }
        }
    }
}