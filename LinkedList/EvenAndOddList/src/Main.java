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
        long startTime = System.currentTimeMillis();   //获取开始时间
        s.oddEvenList(n1);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head, odd = head.next, sentry = head.next;
        while (odd != null && odd.next != null) {
            even.next = odd.next;
            odd.next = even.next.next;
            even.next.next = sentry;
            even = even.next;
            odd = odd.next;
        }
        return head;
    }
}
