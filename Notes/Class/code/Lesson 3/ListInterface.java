package List;
import java.lang.Object;

import Listl.ListIndexOutOfBoundsException;

// Interface broviding the specifications for the ADT list operations
public interface ListInterface {
    public boolean isEmpty(); // Determine whether a list is empty
    public int size(); // Determines the length of a list
    public void removeAll(); // Deleted all the items from the list
    // Adds an item to the list at position index
    public void add( int index, Object item ) throws ListIndexOutOfBoundsException;
    // Retrieves a list item by position
    public Object get ( int index ) throws ListIndexOutOfBoundsException;
    // Deletes an item from the list at a given position
    public void remove ( int index ) throws ListIndexOutOfBoundsException;
}