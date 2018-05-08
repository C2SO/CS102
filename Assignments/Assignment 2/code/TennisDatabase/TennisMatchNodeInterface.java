/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public interface TennisMatchNodeInterface {
    // Accessors (getters).
    public TennisMatch getMatch();
    public TennisMatchNode getPrev();
    public TennisMatchNode getNext();

    // Modifiers (setters).
    public void setPrev( TennisMatchNode p );
    public void setNext( TennisMatchNode n );
}
