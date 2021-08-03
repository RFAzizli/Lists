package Lists.ArrayList;
import Lists.*;
import java.util.NoSuchElementException;
class ArrayList implements List{
    private Object[] items;
    int length;
    /*
        ArrayList(int size) - initializes an empty ArrayList with the given size
     */
    public ArrayList(int size){
        if(size<0){
            throw new IllegalArgumentException();
        }
        this.items= new Object[size];
        this.length=0;
    }
    /*
        ArrayList(Object[] initItems) - initializes an ArrayList object containing the items from initItems
     */
    public ArrayList(Object[] initItems){
        if(initItems==null){
            throw new IllegalArgumentException();
        }
        this.items=new Object[initItems.length];
        this.length=0;
        for(Object o:initItems){
            this.addItem(o);
        }
    }
    /*
        addItem(Object o) - adds an Object o to the end of the array
     */
    private boolean addItem(Object o){
        if(this.isFull()){
            return false;
        }
        this.items[this.length]=o;
        this.length++;
        return true;
    }
    /*
        length() - returns the length of the array
     */
    public int length(){
        return this.length;
    }
    /*
        isEmpty() - checks if the bag is empty
     */
    public boolean isEmpty(){
        return this.length==0;
    }
    /*
        isFull() - returns true if the array is full
     */
    public boolean isFull(){
        return length==this.items.length;
    }
    /*
        get(int pos) - wrapper method for getItem()
     */
    public Object get(int pos){
        return this.getItem(pos);
    }
    /*
        getItem(int pos) - returns an item at position pos
     */
    private Object getItem(int pos){
        if(pos<0 || pos>this.items.length){
            throw new IndexOutOfBoundsException();
        }
        if(pos>this.length){
            throw new NoSuchElementException();
        }
        return this.items[pos];
    }
    /*
        add(Object o) - wrapper method for addItem()
     */
    public boolean add(Object o){
        return this.addItem(o);
    }
    /*
        add(Object o, int pos) - adds a new item o at position pos in the array. Shifts items if required
     */
    public boolean add(Object o, int pos){
        if(pos<0 || pos>this.items.length){
            throw new IndexOutOfBoundsException();
        }
        if(o==null){
            throw new IllegalArgumentException();
        }
        if(isFull()){
            return false;
        }
        if(pos==this.length){
            return this.addItem(o);
        }
        if(pos>this.length){
            this.items[pos]=o;
            this.length++;
            return true;
        }
        for(int i=this.length;i>pos-1;i--){
            this.items[i+1]=this.items[i];
        }
        this.items[pos]=o;
        this.length++;
        return true;
    }
    /*
        resize(int newSize) - resizes the array.
     */
    public boolean resize(int newSize){
        if(newSize<0){
            throw new IllegalArgumentException();
        }
        if(newSize<this.length){
            return false;
        }
        Object[] newArray=new Object[newSize];
        for(int i=0;i<this.items.length;i++){
            newArray[i]=this.get(i);
        }
        this.items=newArray;
        return true;
    }
    /*
        remove(int pos) - wrapper method for removeItem()
     */
    public Object remove(int pos){
        if(this.length==0){
            throw new NoSuchElementException();
        }
        return this.removeItem(pos);
    }
    /*
        removed() - wrapper method for removeItem(), returns the last object of the ArrayList
     */
    public Object remove(){
        if(this.length==0){
            throw new NoSuchElementException();
        }
        return this.removeItem(this.length);
    }
    /*
      removeItem(int pos) -removes an item from the ArrayList at position pos and returns it
     */
    private Object removeItem(int pos){
        if(pos<0 || pos>this.items.length){
            throw new IndexOutOfBoundsException();
        }
        if(pos>this.length){
            throw new NoSuchElementException();
        }
        Object removed=this.get(pos);
        this.items[pos]=null;
        if(pos<this.length){
            for(int i=pos;i<this.length-1;i++){
                this.items[i]=this.items[i+1];
            }
        }
        this.items[this.length]=null;
        this.length--;
        return removed;
    }
    /*
        toString()- overridden method from Object class that returns a string that represents ArrayList object.
    */
    public String toString(){
        String result="{";
        for(int i=0;i<this.length;i++){
            result+=items[i];
            if(i==length-1){
                break;
            }
            result+=", ";
        }
        result+="}";
        return result;
    }
}

