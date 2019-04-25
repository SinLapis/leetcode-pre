public class Main {

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    ListNode reverse(ListNode head, ListNode origin) {
        if (origin.next == null) {
            return head;
        } else {
            ListNode originNext = origin.next;
            origin.next = originNext.next;
            originNext.next = head;
            head = originNext;
            return reverse(head, origin);
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, head);
    }
}
