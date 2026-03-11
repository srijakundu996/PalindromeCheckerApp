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

    public static void main(String[] args) {

        // Hardcoded string
        String text = "madam";

        // Convert string to linked list
        Node head = null;
        Node tail = null;
        for (int i = 0; i < text.length(); i++) {
            Node newNode = new Node(text.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of the linked list
        Node secondHalfHead = reverseLinkedList(slow);

        // Compare first half and reversed second half
        Node firstHalfPointer = head;
        Node secondHalfPointer = secondHalfHead;

        boolean isPalindrome = true;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.data != secondHalfPointer.data) {
                isPalindrome = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        // Print result
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }
}
