package main;

public class RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;

        ListNode previousNode = pseudoHead;

        while (head != null) {
            if (head.val == val) {
                previousNode.next = head.next;
            } else {
                previousNode = head;
            }
            head = head.next;
        }
        return pseudoHead.next;

    }
}
