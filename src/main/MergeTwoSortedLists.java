package main;

public class MergeTwoSortedLists {
    // TODO : write test cases
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode headToReturn = new ListNode(0);
        ListNode tempNode = headToReturn;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tempNode.next = list2;
                list2 = list2.next;
            } else {
                tempNode.next = list1;
                list1 = list1.next;
            }
            tempNode = tempNode.next;
        }

        if (list1 != null) {
            tempNode.next = list1;
            list1 = list1.next;
        }

        if (list2 != null) {
            tempNode.next = list2;
            list2 = list2.next;
        }
        return headToReturn.next;
    }
}
