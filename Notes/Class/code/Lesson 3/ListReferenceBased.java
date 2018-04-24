package List;

// Reference-based implementation of ADT list
public class ListReferenceBased implements ListInterface {
    private Node head; // Reference to linked list of items;
    private int numItems; // Number of items in the list

    // Desc: Locates a specified node in a linked list ( private, internal method )
    // Input: index is the positino of the desored node ( 0 <= index < numItems )
    //      Node: index is supposed to be valid (validity check performed elsewhere)
    // Output: returns a reference to the desired node
    private Node find( int index) {
        Node curr = head;
        for( int skip = 0; skip < index; skip++) { curr = curr.next; }
        return curr;
    }
}