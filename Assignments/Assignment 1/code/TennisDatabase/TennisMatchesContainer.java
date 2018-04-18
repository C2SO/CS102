
/*
Nicholas Rahbany
CS 102
*/

package TennisDatabase;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {

    private int[] matchesArray;
    private int i;
    private int size;
    public int newSize;

    // Desc:
    // Input:
    // Output:
    public TennisMatchesContainer() {
        matchesArray = new int[1];
        i = 0;
        size = 1;
        newSize = size;
    }

    // Desc: insert "val" in the first available (leftmost) position in matchesarray
    // Input: Match Data
    // Output: Array of Matches
    public int[] addMatches(int val) {
        if (i == size || i > size) { // If the array is full
            newSize += size; // Add one to "newSize"
            int[] newArray = new int[newSize]; // Make array "newArray"
            for (int i = 0; i < size; i++) { // For all values in "matchesArray"
                newArray[i] = matchesArray[i]; // Copy and paste data from "matchesArray" to "newArray"
            }
            matchesArray = newArray; // set "matchesArray" to reference "newArray"
            size = newSize; // Update the "size" value
        }
        matchesArray[i] = val; // insert "val" at "i"
        i++; // increment "i"
        return matchesArray; // Return array
    }

}