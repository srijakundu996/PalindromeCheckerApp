import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class palindrome {
    public static void main(String[] args) {



        String text = "madam";

        // Create Stack and Queue
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();

        // Enqueue characters and Push into stack
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        // Compare dequeue from queue and pop from stack
        for (int i = 0; i < text.length(); i++) {
            char fromQueue = queue.remove(); // FIFO
            char fromStack = stack.pop();    // LIFO

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }

    }
}

