package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    TennisPlayerNode head;
    int numPlayers;

    public void TennisPlayerContainer() {
        head = null;
        numPlayers = 0;
    }

    public void insertPlayer(TennisPlayer p) throws TennisDatabaseRuntimeException {
        TennisPlayerNode newNode = new TennisPlayerNode(p);
        if (numPlayers == 0) {
            head = newNode;
            head.setPrev(head);
            head.setNext(head);
            numPlayers++;
        } else {
           TennisPlayerNode currNode = head;
           int indexCurrNode = 0;
           while ((indexCurrNode < numPlayers) && (p.compareTo(currNode.getPlayer()) < 0)) {
              currNode = currNode.getNext();
              indexCurrNode++;
           }
           if (p.compareTo(currNode.getPlayer()) != 0) {
              newNode.setNext(currNode.getNext());
              newNode.setPrev(currNode);
              currNode.setNext(newNode);
              newNode.getNext().setPrev(newNode);
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

    public TennisPlayer checkPlayer(String id) {
        if (id == null) {
            throw new NullPointerException("Id = null");
        }
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
        String id1 = m.getPlayer1Id();
        String id2 = m.getPlayer2Id();
        TennisPlayerNode currNode = head;
        for (int i = 0; i <= numPlayers + 1; i++) {
            if (currNode.getPlayer().getId().equals(id1)) {
                currNode.insertMatch(m);
            }
            currNode = currNode.getNext();
        }
        currNode = head;
        for (int i = 0; i <= numPlayers + 1; i++) {
            if (currNode.getPlayer().getId().equals(id2)) {
                currNode.insertMatch(m);
            }
            currNode = currNode.getNext();
        }
    }

    public void printAllPlayers() throws TennisDatabaseRuntimeException {
        System.out.println();
        TennisPlayerNode currNode = head;
        TennisMatchesContainer tmc = new TennisMatchesContainer(); 
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(currNode.getPlayer() + ", " + tmc.getPlayerScore(currNode.getPlayer().getId())[0] + " - " + tmc.getPlayerScore(currNode.getPlayer().getId())[1]);
            currNode = currNode.getNext();
        }
        System.out.println();
    }

    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
        TennisPlayerNode currNode = head;
        boolean print = false;
        for (int i = 0; i < numPlayers; i++) {
            String testId = currNode.getPlayer().getId();
            if (testId.equals(playerId)) {
                currNode.printMatches();
                print = true;
            }
            currNode = currNode.getNext();
        }
        if (!print) {
            System.out.println("Cannot find player");
        }
    }
}