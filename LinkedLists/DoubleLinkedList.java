package Lists.LinkedLists;
import Lists.*;
import java.util.NoSuchElementException;
class DoubleLinkedList implements List{
    private class Node{
        private Object item;
        private Node prev;
        private Node next;
        private Node(Object i,Node p, Node n){
            this.item=i;
            this.prev=p;
            this.next=n;
        }
    }
    private Node head;
    private Node last;
    private int length;
    /*
        DoubleLinkedList(Object[] items) - public constructor that initializes initial variables
     */
    public DoubleLinkedList(Object[] initItems){
        if(initItems==null){
            throw new IllegalArgumentException();
        }
        this.head=new Node(null,null,null); // Dummy Head Node
        this.last=this.head;
        this.length=0;
        for(Object o:initItems){
            this.addItem(o);
        }
    }
    /*
        addItem(Object o) - adds an item o at the end of the list
     */
    private boolean addItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        Node newNode=new Node(o,null,null);
        if(this.head.next==null){
            this.head.next=newNode;
            newNode.prev=this.head;
        }else{
            this.last.next=newNode;
            newNode.prev=this.last;
        }
        this.last=newNode;
        this.length++;
        return true;
    }
    /*
        add(Object o) - wrapper method for addItem()
     */
    public boolean add(Object o){
        return this.addItem(o);
    }
    /*
        add(Object o, int pos) - adds a new Node with item o at position pos
     */
    public boolean add(Object o,int pos){
        if(o==null){
            throw new IllegalArgumentException();
        }
        if(pos<0 || pos>this.length){
            throw new IndexOutOfBoundsException();
        }
        if(this.last==this.head){
            return this.addItem(o);
        }
        Node prevNode=this.getNode(pos-1);
        Node nextNode=prevNode.next;
        prevNode.next=new Node(o,prevNode,nextNode);
        this.length++;
        return true;
    }
    /*
        remove(int pos) - wrapper method for removeItem()
     */
    public Object remove(int pos){
        return this.removeItem(pos);
    }
    /*
        removeItem(int pos) - removes an item at position pos from the list, then returns it
     */
    private Object removeItem(int pos){
        if(pos<0 || pos>=this.length){
            throw new IndexOutOfBoundsException();
        }
        Node current=this.getNode(pos);
        current.prev.next=current.next;
        current.next.prev=current.prev;
        this.length--;
        return current.item;
    }
    /*
        get(int pos) - wrapper method for getItem()
     */
    public Object get(int pos){
        return this.getItem(pos);
    }
    /*
        getItem(int pos) - private method that returns an item of the Node at position pos
     */
    private Object getItem(int pos){
        if(pos<0 || pos>=this.length){
            throw new IndexOutOfBoundsException();
        }
        Node current=this.getNode(pos);
        return current.item;
    }
    /*
        length()- returns the length of the list
     */
    public int length(){
        return this.length;
    }
    /*
        getNode(int pos) - private method that returns Node at position pos
     */
    private Node getNode(int pos){
        if(pos<0 || pos>=this.length){
            throw new IndexOutOfBoundsException();
        }
        if(pos>(this.length/2-1)){
            pos=this.length-1-pos;
            return this.getNodeFromRight(pos);
        }else{
            return this.getNodeFromLeft(pos);
        }
    }
    /*
        getNodeFromRight(int pos)- returns the Node traversing from the last
     */
    private Node getNodeFromRight(int pos){
        Node current=this.last;
        while(pos>0){
            pos--;
            current=current.prev;
        }
        return current;
    }
    /*
        getNodeFromLeft(int pos) - returns the node traversing from the right
     */
    private Node getNodeFromLeft(int pos){
        int index=-1;
        Node current=this.head;
        while(pos>index){
            current=current.next;
            index++;
        }
        return current;
    }
    /*
        isEmpty() - checks if the bag is empty
     */
    public boolean isEmpty(){
        return this.length==0;
    }
    /*
        isFull()- checks if the list is Full.
     */
    public boolean isFull(){
        return false;
    }
    /*
        toString()- overridden method from Object class that returns a string that represents DoubleLinkedList object.
    */
    public String toString(){
        String result="{";
        Node start=this.head;
        while(start.next!=null){
            start=start.next;
            result+=(start.item).toString();
            if(start.next==null){
                result+="}";
                break;
            }
            result+=", ";
        }
        return result;
    }
    /*
        iterator()- returns an iterator for the list
     */
    public ListIterator iterator(){
        return new DLListIterator();
    }
    /* Private inner class for an iterator over SingleLinkedList*/
    private class DLListIterator implements ListIterator {
        private Node nextNode;
        public DLListIterator(){
            this.nextNode=head.next;
        }
        public boolean hasNext(){
            return (nextNode!=null);
        }
        public Object next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            Object item = this.nextNode.item;
            this.nextNode = this.nextNode.next;
            return item;
        }
    }
}

