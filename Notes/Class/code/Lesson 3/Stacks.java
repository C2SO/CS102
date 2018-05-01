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