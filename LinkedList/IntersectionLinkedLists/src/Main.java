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
    int getLength(ListNode ln) {
        int length = 0;
        while (ln != null) {
            length++;
            ln = ln.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int max, min;
        ListNode longHead, shortHead;
        if (lengthA > lengthB) {
            max = lengthA;
            min = lengthB;
            longHead = headA;
            shortHead = headB;
        } else {
            max = lengthB;
            min = lengthA;
            longHead = headB;
            shortHead = headA;
        }
        int i = max - 1;
        for (; i >= min; i--) {
            longHead = longHead.next;
        }
        for (; i >= 0; i--) {
            if (shortHead == longHead) {
                return longHead;
            } else {
                shortHead = shortHead.next;
                longHead = longHead.next;
            }
        }
        return null;
    }
}
