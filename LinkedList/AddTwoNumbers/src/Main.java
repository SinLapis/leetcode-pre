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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode subPoint = l1;
        int l1Len = 0, l2Len = 0;
        while (subPoint != null) {
            subPoint = subPoint.next;
            l1Len++;
        }
        subPoint = l2;
        while (subPoint != null) {
            subPoint = subPoint.next;
            l2Len++;
        }
        ListNode base, basePoint;
        if (l1Len > l2Len) {
            base = l1;
            basePoint = l1;
            subPoint = l2;
        } else {
            base = l2;
            basePoint = l2;
            subPoint = l1;
        }
        boolean carry = false;
        while (basePoint != null) {
            if (subPoint != null) {
                basePoint.val += subPoint.val;
                subPoint = subPoint.next;
            }
            if (carry) {
                carry = false;
                basePoint.val++;
            }
            if (basePoint.val >= 10) {
                basePoint.val -= 10;
                carry = true;
            }
            basePoint = basePoint.next;
        }
        if (carry) {
            subPoint = base;
            while (subPoint.next != null) {
                subPoint = subPoint.next;
            }
            subPoint.next = new ListNode(1);
        }
        return base;
    }
}
