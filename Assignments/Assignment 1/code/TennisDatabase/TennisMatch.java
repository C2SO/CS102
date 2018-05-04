package TennisDatabase;

public class TennisMatch implements TennisMatchInterface {

    String idPlayer1;
    String idPlayer2;
    int day;
    int month;
    int year;
    String tournament;
    String score;

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
        String id = this.idPlayer1;
        return id;
    }

    public String getPlayer2Id() {
        String id = this.idPlayer2;
        return id;
    }

    public int getDateYear() {
        int yearGet = this.year;
        return yearGet;
    }

    public int getDateMonth() {
        int monthGet = this.month;
        return monthGet;
    }

    public int getDateDay() {
        int dayGet = this.day;
        return dayGet;
    }

    public String getTournament() {
        String tournamentGet = this.tournament;
        return tournamentGet;
    }

    public String getScore() {
        String scoreGet = this.score;
        return scoreGet;
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