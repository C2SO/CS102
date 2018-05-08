/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {

    // Defines variables
    TennisPlayer item;
    TennisPlayerNode next;
    TennisPlayerNode prev;
    TennisMatch[] playerMatches = new TennisMatch[1];

    public TennisPlayerNode(TennisPlayer p) { // Constructor
        item = p;
        next = null;
        prev = null;
    }

    public TennisPlayerNode(TennisPlayer p, TennisPlayerNode n) { // Constructor
        item = p;
        next = n;
        prev = null;
    }

    public TennisPlayer getPlayer() { // Returns the player
        return this.item;
    }

    public String getId() { // Return's the player's ID
        return this.item.getId();
    }

    public TennisPlayerNode getPrev() { // Gets previous node
        return this.prev;
    }

    public TennisPlayerNode getNext() { // Gets next node
        return this.next;
    }

    public void setPrev(TennisPlayerNode prevNode) { // Sets previous node
        this.prev = prevNode;
    }

    public void setNext(TennisPlayerNode nextNode) { // Sets next node
        this.next = nextNode;
    }

    public void insertMatch(TennisMatch m) { // Inserts match for player node ( Broken )
        if (playerMatches.length == 1)
            playerMatches[0] = m;
        else {
            for (int index = 0; index < playerMatches.length; index++) {
                if (m.compareTo(playerMatches[index]) == 0) {
                    throw new TennisDatabaseRuntimeException("Duplicate Match");
                }
            }
            TennisMatch[] tmn = new TennisMatch[playerMatches.length + 1];
            int temp = 0;
            for (int index = 0; (m.compareTo(playerMatches[index]) == -1)
                    && index < playerMatches.length; index++) {
                tmn[index] = playerMatches[index];
                temp = index;
            }
            tmn[temp] = m;
            for (int index = temp; index < playerMatches.length; index++) {
                tmn[index] = playerMatches[index];
            }
            playerMatches = tmn;
        }
    }

    public int compareTo(String input) { // Compares current ID to input ID
        String tempInput = this.item.getId();
        if (tempInput == input) {
            return 1;
        } else {
            return -1;
        }
    }

    public void printMatches() {
        for (int index = 0; index < playerMatches.length; index++) {
            System.out.println(playerMatches[index].toString());
        }
    }
}