public class LinkedList {
    private Node head;
    private int numNodes; // Optional
    // ...

}

class Node {
    Object data;
    Node next;
}

// Tourini Code

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

// Code made today

public void removeBeginning() {
  if (numNodes == 0) {return;}
  else {
    head = head.next;
    numNodes--;
  }
}

public void removeInMiddle() {
  Node curr = head;
  int position; // Given by user
  if (numNodes == 0) {return;}
  else if (numNodes == 1) {
    head = null;
    numNodes--;
  } else {
    for(i = 0; i <= position; i++) {
      curr = curr.next;
    }
    prev.nxt = curr.next;
    curr.next = null;
    curr = prev.next;
    numNodes--;
  }
}

public void addAtBeginning() {
  Node newNode = new Node(item);
  Node curr = head;
  if(head == null) {
    head = newNode;
    numNodes++;
  } else {
    newNode.next = head;
    head = newNode;
    numNodes++;
  }
}

public void addAtEnd() {
  Node newNode = new Node(item);
  Node curr = head;
  if(head == null) {
    head = newNode;
    numNodes++;
  } else if (numNodes = 1) {
    head.next = newNode;
    numNodes++;
  } else {
    do {
      curr = curr.next;
    } while (curr.next != null)
    curr.next = newNode;
    numNodes++;
  }
}

public void addInPosition() {
  Node newNode = new Node(item);
  Node curr = head;
  int pos; // Will be given by user
  if (numNodes == 0) {
    head = newNode;
    numNodes++
  } else {
    for (1 = 0; i < pos; i++) {
      do {
        curr = curr.nect;
      } while (curr.next != null)
    }
    newNode.next = curr;
    prev.next = newNode;
}

public void addInMiddle() {
  Node newNode = new Node(item);
  int position;
  for(prev = null, curr = head; position.compareTo(curr.item) > 0 ){
    prev = curr;
    curr = curr.next;
 if(position.compareTo(curr.item) = 0)
    newNode.next = curr;
    prev.next = newNode; //is this right
  }
  public Node findingMiddle(){
    Node firstPointer = head;
    Node secondPointer = head;
    if(head != null)
      while(firstPointer != null && firstPointer.next != null){
        firstPointer = firstPointer.next.next;
        secondPointer = secondPointer.next;}
    return secondPointer;
}
