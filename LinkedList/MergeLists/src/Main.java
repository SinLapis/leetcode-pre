public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        Solution s = new Solution();
        ListNode r = s.mergeTwoLists(n1, n4);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode base, basePoint, insertPoint;
        if (l1.val > l2.val) {
            base = l2;
            basePoint = l2;
            insertPoint = l1;
        } else {
            base = l1;
            basePoint = l1;
            insertPoint = l2;
        }
        while (insertPoint != null) {
            if (basePoint.next == null) {
                basePoint.next = insertPoint;
                break;
            }
            if (insertPoint.val > basePoint.next.val) {
                basePoint = basePoint.next;
                continue;
            }
            ListNode temp = insertPoint;
            insertPoint = insertPoint.next;
            temp.next = basePoint.next;
            basePoint.next = temp;
        }
        return base;
    }
}
