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
public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {

    }

    public void smallestNode(ListNode[] lists) {
        int sol = lists[0].val;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if(sol > lists[i].val){
                sol = lists[i].val;
                index = i;
            }
        }
        lists[index].
    }
}
