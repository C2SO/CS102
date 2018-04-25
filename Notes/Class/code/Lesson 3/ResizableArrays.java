float [] newArray = new float[newCapacity]; // Create a new array using the new capacity
// Copy the content of the original array to the new array
for ( int i = 0; i < myArray.length; i++ ) { newArray[i] = myArray[i]; }
myArray = newArray; // Change the reference from the original array to the new array