public class palindrome {

    public static void main(String[] args) {

        String text = "racecar";

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Check palindrome
        boolean result = checker.checkPalindrome(text);

        // Print result
        if (result) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }
}

// PalindromeChecker class encapsulates palindrome logic
class PalindromeChecker {

    // Method to check palindrome using loop
    public boolean checkPalindrome(String str) {
        String reversed = "";

        // Build reversed string
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        // Compare original and reversed string
        return str.equals(reversed);
    }
}

