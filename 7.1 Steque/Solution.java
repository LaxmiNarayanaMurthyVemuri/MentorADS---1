import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * integer value of value.
     */
    private int value;
    /**
     * Node type of friend.
     */
    private Node friend;

    /**
     * Constructs the object.
     * Time complexity for Node() is 1.
     * @param      v     { parameter_description }
     * @param      f     { parameter_description }
     */
    Node(final int v, final Node f) {
        this.value = v;
        this.friend = f;
    }

    /**
     * Sets the friend.
     * Time complexity for setFriend() is 1.
     * @param      f     { parameter_description }
     */
    public void setFriend(final Node f) {
        this.friend = f;
    }

    /**
     * Gets the friend.
     * Time complexity for getFriend() is 1.
     * @return     The friend.
     */
    public Node getFriend() {
        return this.friend;
    }

    /**
     * Gets the value.
     * Time complexity for getValue() is 1.
     * @return     The value.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the value.
     * Time complexity for setValue() is 1.
     *
     * @param      v     { parameter_description }
     */
    public void setValue(final int v) {
        this.value = v;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return value + "";
    }
}

/**
 * Class for steque.
 */
class Steque {
    /**
     * Node type of head, tail.
     */
    private Node head, tail;
    /**
     * size of list.
     */
    private int size;

    /**
     * Constructs the object.
     * Time complexity for Steque() is 1.
     */
    Steque() {
        tail = null;
        head = tail;
        size = 0;
    }

    /**
     * inserts element at the end of the list.
     * Time complexity for enqueue() is 1.
     *
     * @param      value  The value
     */
    public void enqueue(final int value) {
        if (tail != null) {
            Node oldTail = tail;
            tail = new Node(value, null);
            oldTail.setFriend(tail);
        } else if (tail == null
            && head == null) {
            tail = new Node(value, null);
            head = tail;
        }
        size++;
    }

    /**
     * inserts element at the first of list.
     * Time complexity for push() is constant.
     * @param      value  The value
     */
    public void push(final int value) {
        Node old = head;
        head = new Node(value, old);
        if (old == null) {
            tail = head;
        }
        size++;
    }

    /**
     * remove element at the begining of the list.
     * Time complexity for pop() is constant.
     */
    public void pop() {
        if (head != null && tail != null) {
            if (head.getFriend() == null
                && tail.getFriend() == null) {
                tail = null;
                head = tail;
                size--;
            } else if (head != null) {
                head = head.getFriend();
                size--;
            }
        }
    }

    /**
     * Returns a string representation of the object.
     * Time complexity for toString() is n.
     * n is the size of the list.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (size == 0) {
            sb.append("Steque is empty.");
            return sb.toString();
        } else {
            Node temp = head;
            while (temp != null) {
                sb.append(temp + ", ");
                temp = temp.getFriend();
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused default constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            Steque steque = new Steque();
            while (scan.hasNext()) {
                String[] tokens = scan.nextLine().split(" ");
                switch (tokens[0]) {
                    case "push":
                        int element = Integer.parseInt(tokens[1]);
                        steque.push(element);
                        System.out.println(steque);
                    break;

                    case "pop":
                        steque.pop();
                        System.out.println(steque);
                    break;

                    case "enqueue":
                        element = Integer.parseInt(tokens[1]);
                        steque.enqueue(element);
                        System.out.println(steque);
                    break;

                    default:
                        steque = new Steque();
                        System.out.println();
                    break;
                }
            }
            testcases--;
        }
    }
}
