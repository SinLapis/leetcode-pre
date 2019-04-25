public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        s.removeNthFromEnd(n1, 2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, back = head;
        int distance = 0;
        while (front != null) {
            if (distance - 1 == n) {
                back = back.next;
            } else {
                distance++;
            }
            front = front.next;
        }
        if (distance == n) {
            return head.next;
        }
        back.next = back.next.next;
        return head;
    }
}
