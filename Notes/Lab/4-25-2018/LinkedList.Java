public class LinkedList {
    private Node head;
    private int numNodes; // Optional
    // ...
}

class Node {
    Object data;
    Node next;
}

// Task: Remove Last Node of the Linked List

public void removeAtLast() {
    if (head == null) { return; } // No Nodes
    else if (head.next == null) { // One Node
        head = null;
        numNodes--;
    } else {
        Node prev = null;
        Node cur = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        numNodes--;
    }
}

public void removeAtLast2() {
    if( numNodes == 0) { return; }
    else if (numNodes == 1 ) {
        head == null;
        numNodes--;
    } else {
        Node curr = head;
        for(int currIdx = 1; currIdx < numNodes-1; currIndex++) {
            curr = curr.next;
        }
        curr.next = null;
        numNodes--;
    }
}