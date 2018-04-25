package TennisDatabase;

public class TennisMatch implements TennisMatchInterface {

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