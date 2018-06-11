/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {

    // Defines variables
    TennisPlayer item;
    TennisPlayerNode right;
    TennisPlayerNode left;
    TennisMatch[] playerMatches = new TennisMatch[1];

    public TennisPlayerNode(TennisPlayer p) { // Constructor
        item = p;
        right = null;
        left = null;
    }

    public TennisPlayerNode(TennisPlayer p, TennisPlayerNode r, TennisPlayerNode l) { // Constructor
        item = p;
        right = r;
        left = l;
    }

    public TennisPlayer getPlayer() { // Returns the player
        return this.item;
    }

    public String getId() { // Return's the player's ID
        return this.item.getId();
    }

    public TennisPlayerNode getLeft() { // Gets left node
        return this.left;
    }

    public TennisPlayerNode getRight() { // Gets right node
        return this.right;
    }

    public void setLeft(TennisPlayerNode leftNode) { // Sets left node
        this.left = leftNode;
    }

    public void setRight(TennisPlayerNode rightNode) { // Sets right node
        this.right = nextNode;
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