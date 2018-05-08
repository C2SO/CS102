/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import java.util.*;
import java.io.*;

public class TennisMatchNode implements TennisMatchNodeInterface {

    // Defines variables used in class
    TennisMatchNode prev;
    TennisMatchNode next;
    TennisMatch match;

    public TennisMatchNode(TennisMatch match){
        this.match = match;
        this.next = null;
        this.prev = null;
    }
    public TennisMatchNode(TennisMatch match, TennisMatchNode n){
        this.match = match;
        this.next = n;
        this.prev = null;
    }

    public TennisMatch getMatch() { // Returns the match
        return this.match;
    }

    public TennisMatchNode getPrev() { // Returns previous match
        return this.prev;
    }

    public TennisMatchNode getNext() { // Returns the next match
        return this.next;
    }

    public void setPrev(TennisMatchNode p) { // Sets the previous match
        this.prev = p;
    }

    public void setNext(TennisMatchNode n) { // Sets the next match
        this.prev = n;
    }
}