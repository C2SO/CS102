public class Notes {
    // "a" is called a "reference variable" because it stores a reference
    String a = new String("abc");

    // "b" is called a "standard variable" because it stores a value
    int b = 123;

    // "s" will point to the reference variable "a" while i will be the standard variable "b"
    f(a, b); // Yes, i know this has an error.

    public static void f(string s, int i) {
        i = 987;
        print(s);
    }

    // If "f()" is true, "g()" is not called
    if(f() || g() ) {} // Yes, I know there is an error here to. It is just for references

    // Checks for a null reference error
    if ( ( obj!=null) && (obj.isEmpty() ) ) {
        
    }

    // Static makes a variable be the same thruought the whole program. It is referenced, not recreated
    class MyClass {
        public int b = 0;
        public int c = 0;
    }
    MyClass obj1 = new MyClass();
    MyClass obj2 = new MyClass();
    obj1.b++; // b = 1
    obj1.c++; // c = 1
    obj2.b++; // b = 1
    obj2.c++; // c = 2

    // Another difference between static and not static
    class MyClass2 {
        public void f() {}
    }
    MyClass2 obj1 = new MyClass2();
    obj1.f();

    class MyClass3 {
        public static void f() {}
    }
    MyClass3.f();
}