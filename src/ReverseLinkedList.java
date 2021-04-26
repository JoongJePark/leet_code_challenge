public class ReverseLinkedList {
    //Definition for singly-linked list.
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

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode sol = null;
            while (head != null) {
                ListNode nextHead = head.next;
                head.next = sol;
                sol = head;
                //sol.val = head.next.val;
                head = nextHead;
            }
            return sol;

            // ListNode newHead = null;
            // while (head != null) {
            //     ListNode next = head.next;
            //     head.next = newHead;
            //     newHead = head;
            //     head = next;
            // }
            // return newHead;
        }
    }
}
