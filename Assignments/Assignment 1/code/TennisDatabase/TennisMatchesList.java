package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesList implements TennisMatchesListInterface {

    private TennisMatchNode head;
    private int numMatches;

    public TennisMatchesList() {
        head = null;
        numMatches = 0;
    }

    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        TennisMatchNode prevNode = null;
        TennisMatchNode currNode = head;
        while ((currNode != null) && (m.compareTo(currNode.getMatch()) < 0)) {

        }
    }

    public void printMatches() {
    }
}
