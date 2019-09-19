public class S25_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode;
        if (l1.val < l2.val) {
            newNode = l1;
            newNode.next = mergeTwoLists(l1.next, l2);
        } else {
            newNode = l2;
            newNode.next = mergeTwoLists(l1, l2.next);
        }
        return newNode;
    }
}
