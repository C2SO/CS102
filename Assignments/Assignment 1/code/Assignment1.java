import TennisDatabase.TennisMatchesContainer;

public class Assignment1 {
    
    public static void main(String[] args) {
        TennisMatchesContainer tmc = new TennisMatchesContainer();
        int[] res = tmc.addMatches(10);
        res = tmc.addMatches(20);
        res = tmc.addMatches(30);
        res = tmc.addMatches(40);
        res = tmc.addMatches(50);
    }
    
}