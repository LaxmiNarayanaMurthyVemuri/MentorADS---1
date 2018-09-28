class ListNode{
    public ListNode next;
    public int data;

    // Creates an empty node.
    public ListNode(){
        next = null;
        data = Integer.MIN_VALUE;
    }

    // Creates a node storing the specified data.
    public ListNode (int data){
        next = null;
        this.data = data;
    }

    // Returns the node that follows this one.
    public ListNode getNext(){
        return next;
    }

    // Sets the node that follows this one.
    public void setNext (ListNode node){
        next = node;
    }

    // Returns the data stored in this node.
    public int getData(){
        return data;
    }

    // Sets the data stored in this node.
    public void setdata (int elem){
        data = elem;
    }
    
    // Sets the data stored in this node.
    public String toString (){
        return Integer.toString(data);
    }   
}

class LinkedList {

    // This is the only field of the class.  It holds the head of the list 
    ListNode head;

    // This class has a default constructor: 
    public LinkedList() {
        length = 0;
    }

    // Length of the linked list
    private int length = 0;

    // Insert a node at the beginning of the list 
    public void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length ++;
    }

    // Insert a node at the end of the list 
    public void insertAtEnd(ListNode node) {
        if (head == null) 
            head = node;
        else {
            ListNode p, q;
            for(p = head; (q = p.getNext()) != null; p = q);
                p.setNext(node);
        }
        length ++;
    }
    

    // Remove and return the node at the head of the list 
    public ListNode removeFromBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }
    
    // Remove and return the node at the end of the list 
    public ListNode removeFromEnd() {
        if (head == null) 
            return null;
        ListNode p = head, q = null, next = head.getNext();
        if (next == null) {
            head = null;
            // reduce the length of the list
            length-=1;
            return p;
        }
        while((next = p.getNext()) != null) { 
            q = p; 
            p = next;
        }
        q.setNext(null);
        // reduce the length of the list
        length-=1;
        return p;
    }
    
    // Remove the value at a given position.
    // If the position is less than 0, remove the value at position 0.
    // If the position is greater than 0, remove the value at the last position.
    public void remove(int position) {
        // fix position
        if (position < 0) {
            position = 0;
        }
        
        if (position >= length) {
            position = length-1;
        }
        
        // if nothing in the list, do nothing
        if (head == null)
            return;
        
        // if removing the head element...
        if (position == 0) {
            head = head.getNext();
        }
        // else advance to the correct position and remove
        else {
            ListNode temp = head;
            for (int i=1; i<position; i+=1) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        // reduce the length of the list
        length -= 1;
    }
    
    // Return a string representation of this collection, in the form ["str1","str2",...].
    public String toString() {
        String result = "[";
        if (head == null) {
            return result+"]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while (temp != null) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
    
    // Return the current length of the list.
    public int length() {
        return length;
    }
    
    // Find the position of the first value that is equal to a given value.
    // The equals method us used to determine equality.
    public int getPosition(int data) {
        // go looking for the data
        ListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                // return the position if found
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        // else return -1
        return Integer.MIN_VALUE;
    }
    
    // Size of the list.
    public boolean isEmpty(){
        return length==0;
    }
    
}

public class LinkedListClient {
    public static void main(String[] args) {
        
    }
}