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
// 내 풀이(틀림)
//    ListNode recursive(ListNode l1, ListNode l2, ListNode l3) {
//        if (l1 == null && l2 == null) {
//            return null;
//        } else if (l1.next == null && l2.next == null) {
//            if (l1.val + l2.val >= 10) {
//                l3.val += l1.val + l2.val - 10;
//                l3.next = new ListNode(1);
//            } else {
//                l3.val += l1.val + l2.val;
//            }
//        } else if (l1.next.next == null && l2.next.next == null) {
//            if (l3.val + l1.val + l2.val >= 10) {
//                l3.val += l1.val + l2.val - 10;
//                l3.next = new ListNode(1);
//                recursive(l1.next, l2.next, l3.next);
//            } else {
//                l3.val += l1.val + l2.val;
//                recursive(l1.next, l2.next, l3.next);
//            }
//        } else {
//            if (l3.val + l1.val + l2.val >= 10) {
//                l3.val += l1.val + l2.val - 10;
//                l3.next = new ListNode(1, new ListNode());
//                recursive(l1.next, l2.next, l3.next);
//            } else {
//                l3.val += l1.val + l2.val;
//                l3.next = new ListNode(0, new ListNode());
//                recursive(l1.next, l2.next, l3.next);
//            }
//        }
//        return l3;
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
