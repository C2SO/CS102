package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {

   public TennisPlayer getPlayer() {}
   
   public TennisPlayerNode getPrev() {}
   
   public TennisPlayerNode getNext() {}
   
   public void setPrev( TennisPlayerNode p ) {}

   public void setNext( TennisPlayerNode n ) {}

   public void insertMatch( TennisMatch m ) {}

   public void printMatches() {}
}