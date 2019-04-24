public class Main {
    public static void main(String[] args) {
        int i;
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        i = myLinkedList.get(-1);
        myLinkedList.deleteAtIndex(1);
        i = myLinkedList.get(-3);
    }
}

class MyLinkedList {

    int val;
    MyLinkedList next;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        val = 0;
    }

    public MyLinkedList(int val) {
        this.val = val;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        MyLinkedList m = this.next;
        for (int i = 0; i < index; i++) {
            if (m != null && m.next != null) {
                m = m.next;
            } else {
                return -1;
            }
        }
        if (m != null) {
            return m.val;
        } else {
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList newHead = new MyLinkedList(val);
        newHead.next = this.next;
        this.next = newHead;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList m = this;
        while (m.next != null) {
            m = m.next;
        }
        m.next = new MyLinkedList(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < -1) {
            return ;
        }
        MyLinkedList m = this;
        for (int i = 0; i < index; i++) {
            if (m.next != null) {
                m = m.next;
            } else {
                return;
            }
        }
        MyLinkedList insertNode = new MyLinkedList(val);
        insertNode.next = m.next;
        m.next = insertNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return ;
        }
        MyLinkedList m = this;
        for (int i = 0; i < index; i++) {
            if (m.next != null) {
                m = m.next;
            } else {
                return;
            }
        }
        if (m.next != null) {
            m.next = m.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */