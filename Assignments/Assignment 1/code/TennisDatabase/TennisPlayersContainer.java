
/*
Nicholas Rahbany
CS 102
*/

package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {

    private int[] playersArray;
    private int i;
    private int size;
    public int newSize;

    // Desc:
    // Input:
    // Output:
    public TennisPlayersContainer() {
        playersArray = new int[3];
        i = 0;
        size = 1;
        newSize = size;
    }

    // Desc: insert "val" in the first available (leftmost) position in playersarray
    // Input: Match Data
    // Output: Array of Players
    public int[] addPlayers(int val) {
        if (i == size || i > size) { // If the array is full
            newSize += size; // Add one to "newSize"
            int[] newArray = new int[newSize]; // Make array "newArray"
            for (int i = 0; i < size; i++) { // For all values in "playersArray"
                newArray[i] = playersArray[i]; // Copy and paste data from "playersArray" to "newArray"
            }
            playersArray = newArray; // set "playersArray" to reference "newArray"
            size = newSize; // Update the "size" value
        }
        playersArray[i] = val; // insert "val" at "i"
        i++; // increment "i"
        System.out.println(val);
        return playersArray; // Return array
    }

}