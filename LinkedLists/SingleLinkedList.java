package Lists.LinkedLists;
import Lists.*;
import java.util.NoSuchElementException;

public class SingleLinkedList implements List {
    /*
        Private Node class, used to define elements of the Linked List and connect them.
     */
    private class Node{
        private Object item;
        private Node next;
        private Node(Object i,Node n){
            this.item=i;
            this.next=n;
        }
    }
    private Node head;
    private Node last;
    private int length;

    /*
        LinkedList(Object[] items)- initializes the list and adds the items from
        initItems array to the LinkedList.
     */
    public SingleLinkedList(Object[] initItems){
        if(initItems==null){
            throw new IllegalArgumentException();
        }
        this.head=new Node(null,null); // Dummy head Node
        this.last=this.head;
        this.length=0;
        for(Object o:initItems){
            this.addItem(o);
        }
    }
    /*
        addItem(Object o)- creates a new Node with item o,
        then adds it the new Node to the end.
     */
    private boolean addItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        Node newNode=new Node(o,null);
        if(this.head.next==null){
            this.head.next=newNode;
        }else{
            this.last.next=newNode;
        }
        this.last=newNode;
        this.length++;
        return true;
    }
    /*
        add(Object o) - wrapper method for addItem().
     */
    public boolean add(Object o){
        return this.addItem(o);
    }

    /*
        add(Object o,int pos) - creates a new Node with item o,
        then puts the new Node to position pos, if needed shifts everything.
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
        Node required=this.getNode(pos-1);
        Node next=required.next;
        required.next=new Node(o,next);
        this.length++;
        return true;
    }

    /*
        remove(int pos)- wrapper method for removeItem();
     */
    public Object remove(int pos){
        return this.removeItem(pos);
    }
    /*
        removeItem(int pos) - removes an item at position pos,
        then shifts the list if needed.
     */
    private Object removeItem(int pos){
        if(pos<0 || pos>=this.length){
            throw new IndexOutOfBoundsException();
        }
        Node prevNode=this.getNode(pos-1);
        Node current=prevNode.next;
        Node nextNode=current.next;
        if(pos==this.length-1){
            this.last=prevNode;
        }
        prevNode.next=nextNode;
        this.length--;
        return current.item;
    }
    /*
        get(int pos)- wrapper method for getItem().
     */
    public Object get(int pos){
        return this.getItem(pos);
    }
    /*
        getItem()- returns an item that is placed at position pos.
     */
    private Object getItem(int pos){
        if(pos<0 || pos>=this.length){
            throw new IndexOutOfBoundsException();
        }
        Node current=this.getNode(pos);
        return current.item;
    }
    /*
        length()- returns length of the list.
     */
    public int length(){
        return this.length;
    }
    /*
        getNode() - returns the Node that is at position pos.
     */
    private Node getNode(int pos){
        Node current=this.head;
        int index=-1;
        if(pos==this.length-1){
            return this.last;
        }
        while(index<pos){
            index++;
            current=current.next;
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
        toString()- overriden method from Object class that returns a string that represents SingleLinkedList object.
    */
    public String toString(){
        String result="{";
        Node start=this.head;
        while(start.next!=null){
            start=start.next;
            result+=start.item;
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
        return new SLListIterator();
    }
    /* Private inner class for an iterator over SingleLinkedList*/
    private class SLListIterator implements ListIterator {
        private Node nextNode;
        public SLListIterator(){
            this.nextNode=head.next;
        }
        public boolean hasNext(){
            return (nextNode!=null);
        }
        public Object next(){
            if(nextNode==null){
                throw new NoSuchElementException();
            }
            Object item=this.nextNode.item;
            this.nextNode=this.nextNode.next;
            return item;
        }
    }
}

