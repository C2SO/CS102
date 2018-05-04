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

    public TennisMatch(String idPlayer1, String idPlayer2, int date, String tournament, String score) {

    }

    public TennisMatch(String idPlayer1, String idPlayer2, int day, int month, int year, String tournament, String score) {

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