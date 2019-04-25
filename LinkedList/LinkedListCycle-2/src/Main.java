public class Main {
    public static void main(String[] args) {

    }
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
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentry = head;
        while (true) {
            ListNode fast = sentry, slow = sentry;
            do {
                if (slow.next != null) {
                    slow = slow.next;
                } else {
                    return null;
                }
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    return null;
                }
                if (fast == sentry) {
                    return sentry;
                }
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    return null;
                }
                if (fast == sentry) {
                    return sentry;
                }
            } while (fast != slow);
            sentry = sentry.next;
        }
    }
}