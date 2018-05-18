/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    private int sizeLogical;
    private int sizePhysical;
    private TennisPlayerNode head;
    private int numPlayers;

    public void TennisPlayerContainer() {
        this.sizePhysical = 2;
        this.sizeLogical = 0;
        this.head = null;
        this.numPlayers = 0;
    }

    public String getPlayerName(String id) {
        String firstName = this.getTennisPlayerNode(id).getPlayer().getFirstName();
        String lastName = this.getTennisPlayerNode(id).getPlayer().getLastName();
        String result;
        result = firstName + " " + lastName;
        return result;
    }

    public void insertPlayer(TennisPlayer p) throws TennisDatabaseRuntimeException {
        TennisPlayerNode newNode = new TennisPlayerNode(p);
        if (this.numPlayers == 0) {
            this.head = newNode;
            this.head.setPrev(this.head);
            this.head.setNext(this.head);
            this.numPlayers++;
        } else {
            TennisPlayerNode currNode = this.head;
            int i = 0;
            int index = 0;
            while ((index < this.numPlayers) && (p.compareTo(currNode.getPlayer()) != 0)) {
                currNode = currNode.getNext();
                index++;
            }
            if (index < numPlayers) {
                if (currNode.getPlayer().getDummy() == true) {
                    deletePlayer(currNode.getId());
                    insertPlayer(p);
                }
                else {
                    System.out.println("Duplicate Player ID. Please Use a New Player ID."); 
                }
            }
            if (index == this.numPlayers) {
                currNode = this.head;
                while ((i < this.numPlayers) && (p.compareTo(currNode.getPlayer()) > 0)) {
                    currNode = currNode.getNext();
                    i++;
                }
                if (i == 0) {
                    this.head = newNode;
                }
                newNode.setNext(currNode);
                newNode.setPrev(currNode.getPrev());
                currNode.getPrev().setNext(newNode);
                currNode.setPrev(newNode);
                this.numPlayers++;
            }
        }
    }

    public void deletePlayer(String deletePlayerId) throws TennisDatabaseRuntimeException {
        if (deletePlayerId == null) {
            throw new NullPointerException("Id = null");
        }
        TennisPlayer p = this.getTennisPlayerNode(deletePlayerId).getPlayer();
        TennisPlayerNode currNode = this.head;
        TennisPlayerNode prevNode = currNode.getPrev();
        TennisPlayerNode nextNode = currNode.getNext();
        int i = 0;
        while ((i < this.numPlayers) && (p.compareTo(currNode.getPlayer()) != 0)) {
            prevNode = currNode;
            currNode = nextNode;
            nextNode = currNode.getNext();
            i++;
        }
        if (i == 0) {
            this.head = nextNode;
        }
        currNode = null;
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        numPlayers--;
    }

    public TennisPlayerNode getTennisPlayerNode(String id) {
        TennisPlayerNode currNode = head;
        int i = 0;
        for (i = 0; (i < numPlayers) && (currNode.getPlayer().getId().compareTo(id) <= 0); i++) {
            if (currNode.getPlayer().getId().equals(id)) {
                return currNode;
            } else {
                currNode = currNode.getNext();
            }
        }
        TennisPlayer temp = new TennisPlayer(id, null, null, 0, null, true);
        insertPlayer(temp);
        return getTennisPlayerNode(id);
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
        TennisPlayerNode currNode = this.head;
        for (int i = 0; (i < this.numPlayers) && (currNode.getPlayer().getId().compareTo(id1) <= 0); i++) {
            if (currNode.getPlayer().getId().equals(id1)) {
                currNode.insertMatch(m);
            } else {
                currNode = currNode.getNext();
            }
        }
        currNode = this.head;
        for (int i = 0; (i < this.numPlayers) && (currNode.getPlayer().getId().compareTo(id2) <= 0); i++) {
            if (currNode.getPlayer().getId().equals(id2)) {
                currNode.insertMatch(m);
            } else {
                currNode = currNode.getNext();
            }
        }
    }

    public void printAllPlayers(TennisMatchesContainer tmc) throws TennisDatabaseRuntimeException {
        System.out.println();
        TennisPlayerNode currNode = head;
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(currNode.getPlayer() + ", " + tmc.getPlayerScoreList(currNode.getPlayer().getId()));
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