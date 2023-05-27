package linkedList;

//A class providing functionality of a singly linkedList
public class LinkedList <T>{

    //Inner class that represents node in linkedList
    private class Node<T>{
        private T data;
        private Node<T> next;

        //constructor to create new node
        private Node() {
            data = null;
            next = null;
        }
    }
    private int size;
    private Node<T> head;

    //constructor to initialize linkedList
    public LinkedList() {
        size = 0;
        head = null;
    }
    public void addFirst(T data) {
        insert(0,data);
    }
    public void addLast(T data) {
        insert(size-1,data);
    }
    public void add(T data) {
        addLast(data);
    }
    //inserts a node at specific index
    public void addWithoutError(T data) {
        insert(size, data);
    }
    public void insert(int index, T data) {
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if(index == 0) {
            newNode.next = head;
            head = newNode;
            size ++;
            return;
        }
        Node<T> temp = head;
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    public void remove(int index) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> temp = head;
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        Node<T> temp2 = temp.next;
        temp.next = temp2.next;
        size--;
    }
    public void removeFirst() {
        remove(0);
    }
    public void removeLast() {
        remove(size-1);
    }
    public void remove() {
        removeLast();
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        return temp.data;
    }
    public T getFirst() {
        return get(0);
    }
    public T getLast() {
        return get(size-1);
    }

    //updates element at specified index
    public void set(int index, T data) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        temp.data = data;
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public boolean contains(T data) {
        Node<T> temp = head;
        for(int i=0; i<size; i++) {
            if(temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public String toString() {
        String str = "[";
        if(head == null)
            return str + "]";
        Node<T> temp = head;
        while(temp.next != null) {
            str = str + temp.data + ", ";
            temp = temp.next;
        }
        str = str + temp.data + "]";
        return str;
    }

    public void reverse(){
        //Initializing three nodes
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;

        //Traversing LinkedList and updating nodes to reverse order
        while (currentNode != null){
            //Store next node as current node
            nextNode = currentNode.next;
            //Reverse link so current node points to previous node
            currentNode.next = previousNode;
            //move references to next nodes for next iteration
            previousNode = currentNode;
            currentNode = nextNode;

        }
    // update head reference to new first node/head
    head = previousNode;
    }
}//end class
