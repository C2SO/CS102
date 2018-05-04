package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {
    TennisPlayer item;
    TennisPlayerNode next;
    TennisPlayerNode prev;
    TennisMatch[] playerMatches = new TennisMatch[1];
    
    public TennisPlayerNode(TennisPlayer p) {
        item = p;
        next = null;
    }

    public TennisPlayerNode(TennisPlayer p, TennisPlayerNode n) {
        item = p;
        next = n;
    }

    public TennisPlayer getPlayer() {
        return this.item;
    }

    public TennisPlayerNode getPrev() {
        return next;
    }

    public TennisPlayerNode getNext() {
        return next;
    }

    public void setPrev(TennisPlayerNode p) {
    }

    public void setNext(TennisPlayerNode n) {
    }

    public void insertMatch(TennisMatch m) {
    }

    public void printMatches() {
    }
}