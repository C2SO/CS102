/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisMatch implements TennisMatchInterface {

    // Defines all variables used in class
    String idPlayer1;
    String idPlayer2;
    int day;
    int month;
    int year;
    String tournament;
    String score;

    public TennisMatch(String idPlayer1In, String idPlayer2In, int dayIn, int monthIn, int yearIn, String tournamentIn,
            String scoreIn) { // Constructor for TennisMatch
        this.idPlayer1 = idPlayer1In;
        this.idPlayer2 = idPlayer2In;
        this.day = dayIn;
        this.month = monthIn;
        this.year = yearIn;
        this.tournament = tournamentIn;
        this.score = scoreIn;
    }

    public String getPlayer1Id() { // Returns player 1's id of the match
        return this.idPlayer1;
    }

    public String getPlayer2Id() { // Returns player 2's id of the match
        return this.idPlayer2;
    }

    public int getDateYear() { // Returns the year of the match
        return this.year;
    }

    public int getDateMonth() { // Returns the month of the match
        return this.month;
    }

    public int getDateDay() { // Returns the day of the match
        return this.day;
    }

    public String getTournament() { // Returns the name of the tournament(match)
        return this.tournament;
    }

    public String getScore() { // Returns the score of the match
        return this.score;
    }

    public int getWinner() { // Calls the recursive function to get winner
        return recGetWinner(this.getScore());
    }

    public int recGetWinner(String score) { // Recursively gets the winner of the match
        int scoreResult = 0;
        int score1 = 0;
        int score2 = 0;
        if (score.length() == 3) { // If there is only one score set
            score1 = Character.getNumericValue(score.charAt(0)); // Gets the first number
            score2 = Character.getNumericValue(score.charAt(2)); // Gets the second number
            if (score1 > score2) { // If player 1's score is greater
                scoreResult++;
            } else { // If player 2's score is greater
                scoreResult--;
            }
            return scoreResult;
        } else { // If there is more than one score set
            score1 = Character.getNumericValue(score.charAt(0)); // Gets the first number
            score2 = Character.getNumericValue(score.charAt(2)); // Gets the second number
            if (score1 > score2) { // If player 1's score is greater
                scoreResult++;
            } else { // If player 2's score is greater
                scoreResult--;
            }
            scoreResult += recGetWinner(score.substring(4)); // Pass in the rest of the string
        }
        if (scoreResult > 0) { // If player ends up winning
            return 1;
        } else {
            return -1;
        }
    }

    public int compareTo(TennisMatch tm) { // Compares years of matches
        if (this.year > tm.getDateYear()) { // If this year is greater than another year
            return 1;
        } else if (this.year < tm.getDateYear()) { // If this year is less than another year
            return -1;
        } else { // If the years are the same
            if (this.month > tm.getDateMonth()) { // If this month is greater than another month
                return 1;
            } else if (this.month < tm.getDateMonth()) { // If this month is less than another month
                return -1;
            } else { // If the months are the same
                if (this.day > tm.getDateDay()) { // If this day is greater than another day
                    return 1;
                } else if (this.day < tm.getDateDay()) { // If this day is less than another day
                    return -1;
                } else { // If the days are the same
                    return 0;
                }
            }
        }
    }

    public void print() { // Prints out match data
        System.out.println(
                year + "/" + month + "/" + day + ", " + idPlayer1 + "-" + idPlayer2 + ", " + tournament + "," + score);
    }

    public void print(TennisPlayersContainer tpc) { // Prints out match data
        String player1 = tpc.getPlayerName(idPlayer1);
        String player2 = tpc.getPlayerName(idPlayer2);
        System.out.println(
                year + "/" + month + "/" + day + ", " + player1 + " - " + player2 + ", " + tournament + "," + score);
    }

    public String toString() { // Returns a string of the match data
        return (year + "/" + month + "/" + day + ", " + idPlayer1 + "-" + idPlayer2 + ", " + tournament + "," + score);
    }
}