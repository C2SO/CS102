/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesList implements TennisMatchesListInterface {

    // Defines variables used in class
    private TennisMatchNode head;
    private int numMatches;

    public TennisMatchesList() { // TennisMatchesList constructor
        head = null;
        numMatches = 0;
    }

    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException { // Inserts tennis match
        TennisMatchNode prevNode = null;
        TennisMatchNode currNode = head;
        while ((currNode != null) && (m.compareTo(currNode.getMatch()) < 0)) { // While this current node is not null
                                                                               // and the date is before another
            // Shift nodes
            prevNode = currNode;
            currNode = currNode.getNext();
        }
        TennisMatchNode newNode = new TennisMatchNode(m); // Creates a new node
        if (currNode == head) { // If the date of the node in the beginning is either null or is equal to the head
            newNode.setNext(head);
            head = newNode;
        } else { // Places new node in sorted place
            newNode.setNext(currNode);
            prevNode.setNext(newNode);
        }
        numMatches++;
    }

    public void printMatches() { // Prints matches
        if (head == null) { // If there are no matches
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            TennisMatchNode currNode = head;
            while (currNode.next != null) { // While there is another node
                currNode.getMatch().print(); // Print match
                currNode = currNode.next; // Go to the next node
            }
        }
    }
}
