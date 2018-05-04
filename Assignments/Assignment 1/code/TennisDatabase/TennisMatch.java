package TennisDatabase;

public class TennisMatch implements TennisMatchInterface {

    int idPlayer1;
    int idPlayer2;
    int date;
    int day;
    int month;
    int year;
    String tournament;
    String score;

    public TennisMatch(String idPlayer1In, String idPlayer2In, int dateIn, String tournamentIn, String scoreIn) {
        this.idPlayer1 = idPlayer1In;
        this.idPlayer2 = idPlayer2In;
        // Date parse
        // this.day = 
        // this.month = 
        // this.year = 
        this.tournament = tournamentIn;
        this.score = scoreIn;
    }

    public TennisMatch(String idPlayer1In, String idPlayer2In, int dayIn, int monthIn, int yearIn, String tournamentIn, String scoreIn) {
        this.idPlayer1 = idPlayer1In;
        this.idPlayer2 = idPlayer2In;
        this.day = dayIn;
        this.month = monthIn;
        this.year = yearIn;
        this.tournament = tournamentIn;
        this.score = scoreIn;
    }

    public String getPlayer1Id() {
        return "";
    }

    public String getPlayer2Id() {
        return "";
    }

    public int getDateYear() {
        return 0;
    }

    public int getDateMonth() {
        return 0;
    }

    public int getDateDay() {
        return 0;
    }

    public String getTournament() {
        return "";
    }

    public String getScore() {
        return "";
    }

    public int getWinner() {
        return 0;
    }

    public int compareTo(TennisMatch tm) {
        if (this.year > tm.getDateYear()) {
            return 1;
        } else if (this.year < tm.getDateYear()) {
            return -1;
        } else {
            if (this.month > tm.getDateMonth()) {
                return 1;
            } else if (this.month < tm.getDateMonth()) {
                return -1;
            } else {
                if (this.day > tm.getDateDay()) {
                    return 1;
                } else if (this.day < tm.getDateDay()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public void print() {
    }
}