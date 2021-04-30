import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        System.out.println(pq);
        if (pq.isEmpty()) {
            return null;
        }
        ListNode startNode = new ListNode(pq.poll());
        while (!pq.isEmpty()) {
            ListNode nextNode = new ListNode(pq.poll());
            startNode.next = nextNode;
            nextNode= startNode;


//            ListNode nextHead = head.next;
//            head.next = sol;
//            sol = head;
//            //sol.val = head.next.val;
//            head = nextHead;
        }
        return startNode;
    }
}
