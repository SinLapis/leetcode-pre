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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 获取长度
        ListNode point = head;
        int len = 0;
        while (point != null) {
            point = point.next;
            len++;
        }
        int half = len / 2;
        if (len >= 4) {
            // 反转前半
            point = head;
            for (int i = 1; i < half; i++) {
                ListNode originNext = point.next;
                point.next = originNext.next;
                originNext.next = head;
                head = originNext;
            }
        }
        int distance = half;
        if (len % 2 == 1) {
            distance++;
        }
        ListNode left = head, right = head;
        for (int i = 0; i < len; i++) {
            if (i >= distance) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
            }
            right = right.next;
        }
        return true;
    }
}
