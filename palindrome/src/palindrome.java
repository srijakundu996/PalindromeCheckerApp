import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class that uses a strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isPalindrome(text);
    }
}

// Main app
public class palindrome {

    public static void main(String[] args) {

        String text = "madam";

        // Choose strategy dynamically
        PalindromeCheckerContext checker = new PalindromeCheckerContext(new StackStrategy());
        System.out.println("Using StackStrategy: " + text + " -> " +
                (checker.check(text) ? "Palindrome" : "Not Palindrome"));

        checker.setStrategy(new DequeStrategy());
        System.out.println("Using DequeStrategy: " + text + " -> " +
                (checker.check(text) ? "Palindrome" : "Not Palindrome"));
    }
}