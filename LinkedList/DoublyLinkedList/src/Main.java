public class Main {
    public static void main(String[] args) {
        int i;
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtIndex(1, 9);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtHead(8);
        i = myLinkedList.get(1);
        i = myLinkedList.get(0);
        i = myLinkedList.get(2);
    }
}

class MyLinkedList {
    int val;
    MyLinkedList prev, next;

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
        if (this.next != null) {
            this.next.prev = newHead;
        }
        newHead.next = this.next;
        newHead.prev = this;
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
        MyLinkedList newTail = new MyLinkedList(val);
        m.next = newTail;
        newTail.prev = m;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < -1) {
            return;
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
        insertNode.prev = m;
        m.next = insertNode;
        if (insertNode.next != null) {
            insertNode.next.prev = insertNode;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
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
            m.next.prev = m;
            m.next = m.next.next;
        }
    }
}

