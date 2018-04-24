// E represents the data type(ONLY OBJECT TYPES) the client will specify
public class MyGenericClass<E> { // Example usage: new MyGenericClass<String>("",1).
    private E data;
    private int num;
    public MyGenericClass ( E initD, int initN ) { data = initD; num = initN; }
    public void setData ( E newD ) { Data = newD; }
    public E getData() { return data; }
    public int getNum() { return num; }
}