class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class palindrome  {

    // Method to reverse a linked list
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: crossed pointers or single character
        if (start >= end) {
            return true;
        }

        // Check current characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        // Hardcoded string
        String text = "madam";

        // Call recursive palindrome checker
        boolean result = isPalindrome(text, 0, text.length() - 1);

        // Print result
        if (result) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }
}
