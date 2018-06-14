/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {

    private String playerId; // Search key (unique) for the BST of tennis players.
    private TennisPlayer player;
    private TennisPlayerNode leftChild;
    private TennisPlayerNode rightChild;

    // Constructor.
    public TennisPlayerNode(TennisPlayer player) {
        this.playerId = player.getId();
        this.player = player;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TennisPlayer getPlayer() {
        return this.player;
    }

    public void setNode(TennisPlayerNode setNode) {
        this.playerId = setNode.playerId;
        this.player = setNode.player;
        this.leftChild = setNode.leftChild;
        this.rightChild = setNode.rightChild;
    }

    public void setPlayer(TennisPlayer playerIn) {
        this.player = playerIn;
    }

    public TennisPlayerNode getLeftChild() {
        return this.leftChild;
    }

    public TennisPlayerNode getRightChild() {
        return this.rightChild;
    }

    // ...
    public void setLeftChild(TennisPlayerNode node) {
        this.leftChild = node;
    }

    public void setRightChild(TennisPlayerNode node) {
        this.rightChild = node;
    }

    public String getId() { // Return's the player's ID
        return this.playerId;
    }

    public int compareTo(String input) {
        return 0;
    }

    public void printMatches() {
    }
}