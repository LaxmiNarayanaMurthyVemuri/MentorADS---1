import java.util.Scanner;


class Stack<Item> {
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        Item item = null;
        if (!isEmpty())
            item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (!isEmpty())
            return first.item;
        return null;
    }

}

class BalancedParanthesis {

	String expression;
	BalancedParanthesis(String ex) {
		this.expression = ex;
	}

	
	public boolean isBalanced() {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topValue = stack.pop();
                if (!((ch == ')' && topValue == '(')
                    || (ch == ']' && topValue == '[')
                    || (ch == '}' && topValue == '{'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}



public class Solution {
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.nextLine();
        	BalancedParanthesis solution = new BalancedParanthesis(expression);
            System.out.println( (solution.isBalanced()) ? "YES" : "NO" );
        }
    }
}
