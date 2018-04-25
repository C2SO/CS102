package List; // Indicate that this class is part of the package
class Node { 
    Object item; // Object data
    Node next; // Reference to the next node
    ...
}

class Node2 {
    Object item;
    Node next;
    Node2 ( Object o ) { item = o; nect = null; } // Constructor 1
    Node2 ( Object o, Node2 n ) { item = o; next = n; } // Constructor 2
}

//Example Usage
Node n = new Node2( new Integer(6));
Node first = new Node2(new Integer(9), n);