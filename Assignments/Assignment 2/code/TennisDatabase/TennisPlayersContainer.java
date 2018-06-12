/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    private TennisPlayerNode root;

    // Constructor (default).
    public TennisPlayersContainer() {
        this.root = null;
    }

    public void insertPlayer(TennisPlayer player) {
        this.root = insertPlayerRec(this.root, player);
    }

    private TennisPlayerNode insertPlayerRec(TennisPlayerNode currRoot, TennisPlayer player) {
        if (currRoot == null) {
            return new TennisPlayerNode(player);
        } else if (currRoot.getPlayer().getId().compareTo(player.getId()) == 0) {
            throw new TennisDatabaseRuntimeException("Duplicate...");
        } else if (currRoot.getPlayer().getId().compareTo(player.getId()) < 0) {
            // input player greater than current root: go right.
            currRoot.setRightChild(insertPlayerRec(currRoot.getRightChild(), player));
            return currRoot;
        } else {
            // input player less than current root: go left.
            currRoot.setLeftChild(insertPlayerRec(currRoot.getLeftChild(), player));
            return currRoot;
        }
    }

    public String getPlayerName(String id) {
        String firstName = this.getTennisPlayerNode(id).getPlayer().getFirstName();
        String lastName = this.getTennisPlayerNode(id).getPlayer().getLastName();
        String result;
        result = firstName + " " + lastName;
        return result;
    }

    public void deletePlayer(String deletePlayerId) throws TennisDatabaseRuntimeException {
    }

    public TennisPlayerNode getTennisPlayerNode(String id) {
        return root;
    }

    public TennisPlayer checkPlayer(String id) {
        return root.getPlayer();
    }

    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
    }

    public void printAllPlayers(TennisMatchesContainer tmc) throws TennisDatabaseRuntimeException {
        System.out.println();
        printAllPlayersRec(this.root, tmc);
        System.out.println();
    }

    public void printAllPlayersRec(TennisPlayerNode node, TennisMatchesContainer tmc)
            throws TennisDatabaseRuntimeException {
        if (node == null) {
            return;
        } else {
            if (node.getLeftChild() == null) {
                System.out.println(node.getPlayer() + ", " + tmc.getPlayerScoreList(node.getPlayer().getId()));
            } else {
                printAllPlayersRec(node.getLeftChild(), tmc);
                System.out.println(node.getPlayer() + ", " + tmc.getPlayerScoreList(node.getPlayer().getId()));
            }
            printAllPlayersRec(node.getRightChild(), tmc);
        }
    }

    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
    }
}