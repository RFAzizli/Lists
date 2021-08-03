package Lists;

public interface List {
    /* get()- returns an item at position i*/
    Object get(int pos);
    /* add(Object item)- adds an item at the end of the list */
    boolean add(Object item);
    /* add(Object item)- adds an item at position pos and shifts the other elements */
    boolean add(Object item,int pos);
    /* remove()- removes an Object at position pos, at the end returns the removed element*/
    Object remove(int pos);
    /* returns the length of the list */
    int length();
    /* returns true if the list is full */
    boolean isFull();
    /* returns true if the list is empty */
    boolean isEmpty();
}
