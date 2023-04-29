package main;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;

        if (head == null) {
            return null;
        }
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }
}
