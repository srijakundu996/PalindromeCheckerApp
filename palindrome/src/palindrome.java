import java.util.Stack;

public class palindrome {
    public static void main(String[] args) {



            // Hardcoded string
            String text = "madam";

            // Create Stack
            Stack<Character> stack = new Stack<Character>();

            // Push characters into stack
            for (int i = 0; i < text.length(); i++) {
                stack.push(text.charAt(i));
            }

            boolean isPalindrome = true;

            // Pop and compare characters
            for (int i = 0; i < text.length(); i++) {
                char poppedChar = stack.pop();
                if (text.charAt(i) != poppedChar) {
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

