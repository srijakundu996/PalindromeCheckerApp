public class palindrome {

    // Method to reverse a linked list
    public static void main(String[] args) {

        // Hardcoded string with mixed case and spaces
        String text = "A man a plan a canal Panama";

        // Normalize string: remove spaces and convert to lowercase
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        // Reverse the normalized string
        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed += normalized.charAt(i);
        }

        // Compare original normalized with reversed
        if (normalized.equals(reversed)) {
            System.out.println("\"" + text + "\" is a Palindrome (ignoring spaces and case)");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome (ignoring spaces and case)");
        }
        }
    }

