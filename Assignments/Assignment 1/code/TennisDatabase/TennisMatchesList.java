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
            prevNode = currNode;
            currNode = currNode.getNext();
        }
        TennisMatchNode newNode = new TennisMatchNode(m);
        if(currNode == head) {
            newNode.setNext(head);
            head = newNode;
        }
        else {
            newNode.setNext(currNode);
            prevNode.setNext(newNode);
        }
        numMatches++;
    }

    public void printMatches() {
    }
}
