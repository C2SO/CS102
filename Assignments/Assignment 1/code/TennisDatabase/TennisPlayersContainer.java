package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    TennisPlayerNode head;
    int numPlayers;

    public void TennisPlayerContainer() {
        head = null;
        numPlayers = 0;
    }

    public void insertPlayer(TennisPlayer p) throws TennisDatabaseRuntimeException {
        TennisPlayer playerSame = getPlayer(p.getId());
        if (playerSame != null) {
            throw new TennisDatabaseRuntimeException(
                    "Ooohhhhhhhhhhhhhh ya almost got me there. Give me a player that isn't in the database.");
        }
        TennisPlayerNode newNode = new TennisPlayerNode(p);
        if (numPlayers == 0) {
            head = newNode;
            newNode.setPrev(newNode);
            newNode.setNext(newNode);
            numPlayers++;
        } else {
            TennisPlayerNode prevNode = head.getPrev();
            TennisPlayerNode currNode = head;
            int indexCurrNode = 0;
            while ((indexCurrNode < numPlayers) && (currNode != null) && (p.compareTo(currNode.getPlayer()) > 0)) {
                prevNode = currNode;
                currNode = currNode.getNext();
                indexCurrNode++;
            }
            if (indexCurrNode == 0) {
                head = newNode;
                newNode.setPrev(newNode);
                newNode.setNext(newNode);
                prevNode.setNext(newNode);
                currNode.setPrev(newNode);
                numPlayers++;
            } else {
                newNode.setPrev(prevNode);
                newNode.setNext(currNode);
                prevNode.setNext(newNode);
                currNode.setPrev(newNode);
                numPlayers++;
            }
        }
    }

    public TennisPlayerNode getTennisPlayerNode(String id) {
        TennisPlayerNode currNode = head;
        for (int i = 0; (i < numPlayers) && (currNode.getPlayer().getId().compareTo(id) <= 0); i++) {
            if (currNode.getPlayer().getId().equals(id)) {
                return currNode;
            } else {
                currNode = currNode.getNext();
            }
        }
        return null;
    }

    public TennisPlayer getPlayer(String id) {
        TennisPlayerNode currNode = head;
        for (int i = 0; (i < numPlayers) && (currNode.getPlayer().getId().compareTo(id) <= 0); i++) {
           if (currNode.getPlayer().getId().equals(id)) {
              return currNode.getPlayer();
           } else {
              currNode = currNode.getNext();
           }
        }
        return null;
    }

    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
    }

    public void printAllPlayers() throws TennisDatabaseRuntimeException {
    }

    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
    }
}