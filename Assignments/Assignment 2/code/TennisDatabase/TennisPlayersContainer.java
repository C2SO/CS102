/*
Nicholas Rahbany
CS102
*/

package TennisDatabase;

import java.io.*;
import java.util.*;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    private TennisPlayerNode root;
    public int numPlayers;

    // Constructor (default).
    public TennisPlayersContainer() {
        this.root = null;
        this.numPlayers = 0;
    }

    public void insertPlayer(TennisPlayer player) {
        this.root = insertPlayerRec(this.root, player);
    }

    public void exportPlayers(PrintStream write) {
        exportPlayersRec(this.root, write);
    }

    public void exportPlayersRec(TennisPlayerNode currNode, PrintStream write) {
        if (currNode != null) {
            TennisPlayer currPlayer = currNode.getPlayer();
            write.println("PLAYER/" + currPlayer.getId() + "/" + currPlayer.getFirstName() + "/" + currPlayer.getLastName() + "/"
                    + currPlayer.getBirthYear() + "/" + currPlayer.getCountry());
            exportPlayersRec(currNode.getLeftChild(), write);
            exportPlayersRec(currNode.getRightChild(), write);
        }
    }

    private TennisPlayerNode insertPlayerRec(TennisPlayerNode currRoot, TennisPlayer player) {
        if (currRoot == null) {
            return new TennisPlayerNode(player);
        } else if (currRoot.getPlayer().getId().compareTo(player.getId()) == 0) {
            if (currRoot.getPlayer().getDummy() == true) {
                currRoot.setPlayer(player);
                return currRoot;
            } else {
                throw new TennisDatabaseRuntimeException("Duplicate...");
            }
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

    public void deletePlayer(String id) {
        TennisPlayerNode playerDelete = getTennisPlayerNode(id);
        this.root.setNode(deleteNode(playerDelete));
    }

    public TennisPlayerNode deleteNode(TennisPlayerNode treeNode) {
        if (treeNode.getLeftChild() == null) {
            if (treeNode.getRightChild() == null) {
                return null;
            } else {
                return treeNode.getRightChild();
            }
        } else if (treeNode.getRightChild() == null) {
            return treeNode.getLeftChild();
        } else {
            TennisPlayerNode replacementItem = findLeftMost(treeNode.getRightChild());
            TennisPlayerNode replacementRightChild = deleteLeftMost(treeNode.getRightChild());
            treeNode.setPlayer(replacementItem.getPlayer());
            treeNode.setRightChild(replacementRightChild);
            return treeNode;
        }
    }

    private TennisPlayerNode findLeftMost(TennisPlayerNode treeNode) {
        if (treeNode.getLeftChild() == null) {
            return treeNode;
        } else {
            return findLeftMost(treeNode.getLeftChild());
        }
    }

    private TennisPlayerNode deleteLeftMost(TennisPlayerNode treeNode) {
        if (treeNode.getLeftChild() == null) {
            return treeNode.getRightChild();
        } else {
            TennisPlayerNode replacementLeftChild = deleteLeftMost(treeNode.getLeftChild());
            treeNode.setLeftChild(replacementLeftChild);
            return treeNode;
        }
    }

    public TennisPlayerNode getTennisPlayerNode(String id) {
        return getTennisPlayerNodeRec(id, this.root);
    }

    public TennisPlayerNode getTennisPlayerNodeRec(String id, TennisPlayerNode currRoot) {
        TennisPlayerNode currNode = currRoot;
        if (currNode == null) {
            TennisPlayer temp = new TennisPlayer(id, null, null, null, null, true);
            insertPlayer(temp);
            return getTennisPlayerNode(id);
        }
        if (currNode.getPlayer().getId().equals(id)) {
            return currNode;
        } else {
            if (currNode.getPlayer().getId().compareTo(id) > 0) {
                return getTennisPlayerNodeRec(id, currNode.getLeftChild());
            } else {
                return getTennisPlayerNodeRec(id, currNode.getRightChild());
            }
        }

    }

    public TennisPlayer checkPlayer(String id) {
        return root.getPlayer();
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
}