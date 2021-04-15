import java.util.List;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode recursive(ListNode l1, ListNode l2, ListNode l3) {
        if (l1.next.next != null) {
            if (l1.val + l2.val >= 10) {
                l3.val += l1.val + l2.val - 10;
                l3.next = new ListNode(1, new ListNode());
                recursive(l1.next, l2.next, l3.next);
            } else {
                l3.val += l1.val + l2.val;
                l3.next = new ListNode(0, new ListNode());
                recursive(l1.next, l2.next, l3.next);
            }
        } else if (l1.next.next == null) {
            if (l1.val + l2.val >= 10) {
                l3.val += l1.val + l2.val - 10;
                l3.next = new ListNode(1);
                recursive(l1.next, l2.next, l3.next);
            } else {
                l3.val += l1.val + l2.val;
                recursive(l1.next, l2.next, l3.next);
            }
        } else if (l1.next == null) {
            if (l1.val + l2.val >= 10) {
                l3.val += l1.val + l2.val - 10;
                l3.next = new ListNode(1);
            } else {
                l3.val += l1.val + l2.val;
            }
        }
        return l3;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        } else if (l1.next == null) {
            ListNode l3 = new ListNode();
            if (l1.val + l2.val >= 10) {
                l3.val = l1.val + l2.val - 10;
                l3.next = new ListNode(1);
            } else {
                l3.val = l1.val + l2.val;
            }
        }
        return recursive(l1, l2, new ListNode());
    }
}
