//Read the line, correcting mistakes along the war (pseudocode)
while (not end of line) {
    Read a new character ch;
    if( ch is not a '<-') { Add cd to the ADT; }
    else if( the ADT is not empty ) { remove from the ADT the item added most recently; }
    else { Ignore the '<-'; }
}

//Write the line in reversed order
while ( the ADT is not empty) {
    ch = Retrieve from the ADT the item that was added most recently;
    Display ch;
    Remove from the ADT the item added most recently;
}

// StackItemType is the type of the items stored in the stack (pseudocode)
void createStack(); // Creates an empty stack
boolean isEmpty(); // Determines whether a stack is empty
void popAll(); // Removes all items from the stack
void push(StackItemType i) throws StackException; // Adds i to the top of the stack
StackItemType pop() throws StackException; // Retrieves and removes top of the stack
StackItemType peek() throws StackException; // Retrieves the top of the stack

// Checking for Balanced Braces (pseudocode of the algorithm)
aStack.createStack();
boolean balancedSoFar = true;
int i = 0;
while ( balancedSoFar && ( i < aString.length() ) ) {
    StackItemType ch = character at position i in aString;
    i++;
    if ( ch == '{' ) { aStack.push(ch); } // Push an open brace onto the stack
    else if( ch == '}' ) { // Check if ch is a close brace
        if( !aStack.isEmpty() ) {
            StackItemType openBrace = aStack.pop(); // pop a matching open brace from stack
        } else { balancedSoFar = false; } } // No matching open brace in the stack
        // Ignoring all characters other than braces
    }
}
if (balancedSoFar && aStack.isEmpty() ) { aString has balanced braces; }
else { aString does not have balanced braces; }

// Recognizing strings in a language (pseudocode)

// aString is the input string to be checked as a part of the L language
aStack.createStack(); int i = 0; StackItemType ch = character at position i in aString;
while (ch != '$' ) { // Push characters before $ (characters in w), onto the stack
    aStack.push(ch);
    i++;
    ch = character at position in in aString;
}
i++; // Skip the $
boolean inLanguage = true; // Assume aString is in language L
while (inLanguage && (i < aString.length() ) ) { // Match the reverse of w
    ch = character at position i in aString;
    try {
        StackItemType stackTop = aStack.pop();
        if (stackTop == ch) {i++;} // Charaters match
        else { inLanguage = false; } } // characters do not match
    catch (StackException e) { inLanguage = false; } }
}
if (inLanguage && aStack.isEmpty() ) { aString is in language L; }
else { aString is not in language L; }


// Implementation of the stack

//Interface providing a common specification for different ADT stack implementations
public interface StackInterface {
    public boolean isEmpty(); // Determines whether the stack is empty
    public void popAll(); // Removes all the items from the stack
    
    // Adds an item to the top of the stack
    // Throws StackException when newItem cannot be placed on the stack
    public void push( Object newItem ) throws StackException;

    // Removes the top of a stack. Throws StackException if the stack is empty
    public Object pop() throws StackException;

    // Retrieves the otp of the stack. Throws Stack Exception if the stack is empty
    public Object peek() throws StackException;
}

// StackException

import Java.lang.RuntimeException;
import java.lang.String;
public class StackException extends java.lang.RuntimeException {
    public StackException (String s) {super(s);}
}

// Implementation of an array-based stack

public class StackArrayBased implements StackInterface {
    final int MAX_STACK = 50; // Max size (default)
    private Object item[];
    private int top;

    // Default constructor
    public StackArrayBased() {
        items = new Object [MAX_STACK];
        top = -1;
    }

    public boolean isEmpty() { return top < 0; }

    // Note: isFull is not part of the StackInterface
    public boolean isFull() { return top == ( MAX_STACK - 1); }

    public void push( Object newItem ) throws StackException {
        if (!isFull()) { items[++top] = newItem; }
        // Note: even if both X++ and ++X increment X by 1
        //  x++ returns X before the increment, and ++X returns X after the increment
        else { throw new StackException (" StackException on push: stack full! "); }
    }

    public void popAll() { items = new Object[MAX_Stack]; top = -1; }

    public Object pop() throws StackException {
        if (!isEmpty()) { return items[top--]; }
        else { throw new StackException("StackException on pop: stack empty!"); }
    }

    public Object peek() throws StackException {
        if (!isEmpty() ) { return items[top]; }
        else { throw new StackException("StackException on peek: stack empty!"); }
    }
}

// Implementation of a reference-based stack

public class StackReferenceBased implements StackInterface {
    private Node top; // Reference at top node of the stack, or null

    public StaticReferenceBased() {top = null; }
    public boolean isEmpty() { return top == null; }
    public push ( Object newItem ) { top = new Node( newItem, top); }
    public void popAll() { top = null; }

    public Object pop() throws StackException {
        if (!isEmpty() ) {
            Node temp = top;
            top = top.next;
            return temp.item;
        } else {
            throw new StackException("StackException on pop: stack empty"); 
        }
    }

    public Object peek() throws StackException {
        if (!isEmpty() ) { return top.item; }
        else { throw new StackException("StackException on peek: stack empty!"); }
    }
}

// Implementatino of a list-based stack
// page 28 in pdf