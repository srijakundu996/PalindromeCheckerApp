import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Loop-based strategy
class LoopStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        int n = text.length();
        for (int i = 0; i < n / 2; i++) {
            if (text.charAt(i) != text.charAt(n - i - 1)) return false;
        }
        return true;
    }
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);
        for (char c : text.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) deque.addLast(c);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

// Context class
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

// Main App
public class palindrome {

    public static void main(String[] args) {

        String text = "A man a plan a canal Panama".replaceAll("\\s+", "").toLowerCase();

        // Loop Strategy
        PalindromeCheckerContext checker = new PalindromeCheckerContext(new LoopStrategy());
        long start = System.nanoTime();
        checker.check(text);
        long end = System.nanoTime();
        System.out.println("LoopStrategy Time: " + (end - start) + " ns");

        // Stack Strategy
        checker.setStrategy(new StackStrategy());
        start = System.nanoTime();
        checker.check(text);
        end = System.nanoTime();
        System.out.println("StackStrategy Time: " + (end - start) + " ns");

        // Deque Strategy
        checker.setStrategy(new DequeStrategy());
        start = System.nanoTime();
        checker.check(text);
        end = System.nanoTime();
        System.out.println("DequeStrategy Time: " + (end - start) + " ns");
    }
}