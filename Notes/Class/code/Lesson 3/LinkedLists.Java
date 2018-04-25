// curr is the first node on the list
curr = curr.next; // Shifts to the next node
// Displays all data
for(Node curr = head; cur != null; curr = curr.next) { System.out.println(curr.item); }

public class DeletingNode {
    // Bypassing Node N
    prev.next = curr.nect;
    // Unlink Node N
    curr.next = null;
    // Update curr
    curr = prev.next;
    //Deleting the 1st node (special case)
    head = head.next;
}

public class AddingNode {
    // Instantiate a new node
    Node newNode = new Node(item);
    // Set the new node next field
    newNode.next = curr;
    // Update the prev next field
    prev.next = newNode;

    // Adding a new node at the head
    // Instantiate a new Node
    Node newNode = new Node(1);
    // Add a new node in front
    newNode.next = head;
    // Link head to new node
    head = newNode;
}

// Navigating a sorted linked list to insert a new value
// Note: Java uses "short-circut evaluation" to evaluate logical expressions
for ( prev = null, curr = head;
    ( curr != null) && ( newValue.compareTo( curr.item) > 0);
    prev = curr, curr = curr.next) {...}