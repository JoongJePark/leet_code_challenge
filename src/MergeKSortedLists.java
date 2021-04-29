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

        ListNode startNode = new ListNode();
        smallestNode(startNode, lists);
        return startNode;
    }

    public void smallestNode(ListNode listNode, ListNode[] lists) {
        int sol = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null && sol > lists[i].val){
                sol = lists[i].val;
                index = i;
            }
        }
        if(lists[index].next != null){
            lists[index] = lists[index].next;
        }
        listNode.val = sol;
        listNode.next = new ListNode();
        smallestNode(listNode.next, lists);
    }
}
