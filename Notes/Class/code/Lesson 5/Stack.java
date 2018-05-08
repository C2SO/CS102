// Introduction ot the ADT Stack

// Pseudocode - Read the line, correcting mistakes along the way
// abcc<-ddde<-<-<-ef<-fg = abcdefg
while( not end of line ) {
    Read a new charachter ch;
    if ( ch is not a '<-' ) { Add ch to the ADT; }
    else if ( the ADT is not empty ) { Remove from the ADT the item added most recently; }
    else { Ignore the '<='; }
}

// Pseudocode - Write the line in reversed order
while( the ADT is not empty ) {
    ch = Retrieve from the ADT the item that was added most recently;
    Display ch;
    Remove from the ADT the item added most recently;
}

// List of operations
1. Create an empty Stack
2. Determine whether a Stack is empty
3. Add a new item to the Stack
4. Remove all the items from the Stack
5. Remove all the items from the Stack
6. Retrieve from Stack the item that was added most recently

// Principal Operations
1. Push - adds an item to the top (last-in)
2. Pop - Removes an item from the top (first-out)

// Queue Principal Operations
1. enqueue - Adds an item to the rear (first-in)
2. dequeue - Removes an item from the front (first-out)

// Pseudocode detailing the ADT stack operations using conventional names
void createStack(); // Creates an empty stack
boolean isEmpty(); // Determines whether a stack is empty
void popALl(); // Removes all items from the stack
void push( StackItemType i ) throws StackException; // Adds i to the top of the stack
StackItemType pop() throws StackException; // Retrieves and removes top of the stack
StackItemType peek() throws StackException; // Retrieves the top of the stack

// Example: Checking for balanced braces - Pseudocode
aStack.createStack();
boolean balancedSoFar = true;
int i = 0;
while( balancedSoFar && ( i < aString.length() ) ) {
    StackItemType ch = characher at position i in aString;
    i++;
    if( ch == '{') { aStack.push( ch ); } // Push an open brace onto the stack
    else if ( ch == '}' ) { // Check if ch is a close brace
        if ( !aStack.isEmpty() ) {
            StackItemType openBrach = aStack.pop(); // Pop a matching open brace from stack
        } else {
            balancedSoFar = false; // No matching open brace in the stack
        } // Ignoring all characters other than braces
    }
}
if( balancedSoFar && aStack.isEmpty() ) { aString has balanced braces; }
else { aString foes not have balanced braces; }

// Stack Interface
public interface StackInterface {
    public boolean isEmpty(); // Determines whether the stack is empty
    public void popAll(); // Removes all the items from the stack

    // Adds an item to the top of the stack
    // Throws StackException when newItem cannot be placed on the Stack
    public void push( Object newItem ) throws StackException;

    // Removes the top of a stack. Throws StackException if the stack is empty
    public Object pop() throws StackException;

    // Retrieves the top of the stack. Throws StackException if the stack is empty
    public Object peek() throws StackException;
}

// Stack Exception

import java.lang.RuntimeException;
import java.lang.String;
public class StackException extends RuntimeException { 
    public StackException( String s ) { super (s); }
}

// Array-based Stack

public class StackArrayBased implements StackInterface {
    final int MAX_STACK = 50; // Max size
    private Object items[];
    private int top;

    // Default constructor
    public StackArrayBased() {
        items = new Object[ MAX_STACK ];
        top = -1;
    }

    public boolean isEmpty() { return top < 0; }

    //Note: isFull is not part of the StackInterface.
    public boolean isFull() { return top == (MAX_STACK - 1); }

    public void push( Object newItem ) throws StackException {
        if ( !isFull() ) { items [++top] = newItem; }
        // Note: even if both x++ and ++x increments x by 1,
        //      x++ returns x before the increment, and ++x returns x after the increment
        else { throw new StackException( "StackException on push: stack full!" ); }
    }

    public void popAll() { items = newObject[ MAX_STACK ]; top = -1; }

    public Object pop() throws StackException {
        if( !isEmpty() ) { return items[ top-- ]; }
        else { throw new StackException( "StacKException on pop: stack empty!" ); }
    }

    public Object peek() throws StackException {
        if( !isEmpty() ) { return items[ top ]; }
        else { throw new StackException( "StackException on peek: stack empty!" ); }
    }
}

// Reference-Based Stack page 25