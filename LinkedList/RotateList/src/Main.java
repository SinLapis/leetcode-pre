public class Main {
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        k = len - k % len;
        p.next = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
            p = p.next;
        }
        p.next = null;
        return head;
    }
}
