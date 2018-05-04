package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {
    TennisPlayer item;
    TennisPlayerNode next;
    TennisPlayerNode prev;
    TennisMatch[] playerMatches = new TennisMatch[1];

    public TennisPlayerNode(TennisPlayer p) {
        item = p;
        next = null;
        prev = null;
    }

    public TennisPlayerNode(TennisPlayer p, TennisPlayerNode n) {
        item = p;
        next = n;
        prev = null;
    }

    public TennisPlayer getPlayer() {
        return this.item;
    }

    public String getId() {
        String id = this.item.getId();
        return id;
    }

    public TennisPlayerNode getPrev() {
        return this.prev;
    }

    public TennisPlayerNode getNext() {
        return this.next;
    }

    public void setPrev(TennisPlayerNode prevNode) {
        this.prev = prevNode;
    }

    public void setNext(TennisPlayerNode nextNode) {
        this.next = nextNode;
    }

    public void insertMatch(TennisMatch m) {
        if (playerMatches.length == 1)
            playerMatches[0] = m;
        else {
            for (int index = 0; index < playerMatches.length; index++) {
                if (m.compareTo(playerMatches[index]) == 0)
                    throw new TennisDatabaseRuntimeException("Duplicate Match");
            }
            TennisMatch[] tennisMatchArray = new TennisMatch[playerMatches.length + 1];
            int temp = 0;
            if (m.compareTo(playerMatches[0]) >= 0) {
                tennisMatchArray[0] = m;
                for (int index = 0; index < playerMatches.length; index++) {
                    tennisMatchArray[index + 1] = playerMatches[index];
                }
            } else {
                for (int index3 = 0; (m.compareTo(playerMatches[index3]) == -1)
                        && index3 < playerMatches.length; index3++) {
                    // make new and old arrays match up untill the new item is the newest
                    tennisMatchArray[index3] = playerMatches[index3];
                    temp = index3;
                }
                tennisMatchArray[temp] = m;
                for (int index3 = temp; index3 < playerMatches.length; index3++) {
                    // Finish filling in new array from old after 'm'
                    tennisMatchArray[index3] = playerMatches[index3];
                }
            }
            playerMatches = tennisMatchArray;
        }
    }

    public int compareTo(String input) {
        String tempInput = this.item.getId();
        if (tempInput == input) {
            return 1;
        } else {
            return -1;
        }
    }

    public void printMatches() {
        for (int index = 0; index < playerMatches.length; index++) {
            System.out.println(playerMatches[index].toString());
        }
    }
}