Integer intRef; // Declaration of a reference variable intRef
intRef = new Integer(5); // Instantiate an Integer obj and assign its ref to intRef

Integer p, q; // p and q do not reference any object
p = new Integer(6); // p now references an Integer object of value 6
q = p; // now both p and q reference the same Integer object of value 6

Integer [] scores = new Integer[30]; // An array of 30 references to Integer objects
scores[0] = new Integer(7); // Initialize reference stored into array element 0

void f( Integer fp) {...} // fp is a formal parameter of methof g
Integer aa = new Integer (7); // aa is an actual argument of the following call to f
f(aa); // Note: in this call to f both aa and fp reference the same Integer object (7)
//Note: using the new operator with a formal parameter can produce unexpected results
void f( Integer fp ) { fp = new Inteher(9); ... } // Warning: unexpected results
