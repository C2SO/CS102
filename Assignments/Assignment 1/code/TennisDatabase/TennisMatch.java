package TennisDatabase;

public class TennisMatch implements TennisMatchInterface {

    public TennisMatch(String idPlayer1, String idPlayer2, int date, String tournament, String score) {

    }

    public String getPlayer1Id() {

    }

    public String getPlayer2Id() {

    }

    public int getDateYear() {

    }

    public int getDateMonth() {

    }

    public int getDateDay() {

    }

    public String getTournament() {

    }

    public String getScore() {

    }

    public int getWinner() {

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