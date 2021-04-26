import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n + m == 0) {
            return 0;
        }
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            queue1.add(nums1[i]);
        }
        for (int i = 0; i < m; i++) {
            queue2.add(nums2[i]);
        }
        int dummy;
        if ((n + m) % 2 == 0) {
            while (stack.size() <= (m + n) / 2) {
                if (queue2.isEmpty() || (!queue1.isEmpty() && queue1.peek() <= queue2.peek())) {
                    dummy = queue1.poll();
                    stack.add(dummy);
                } else if (queue1.isEmpty() || queue1.peek() >= queue2.peek()) {
                    dummy = queue2.poll();
                    stack.add(dummy);
                }
            }
            return (double) (stack.pop() + stack.pop()) / 2;
        } else {
            while (stack.size() <= (n + m) / 2) {
                if (queue2.isEmpty() || (!queue1.isEmpty() && queue1.peek() <= queue2.peek())) {
                    dummy = queue1.poll();
                    System.out.println(dummy);
                    stack.add(dummy);
                } else if (queue1.isEmpty() || (queue1.peek() >= queue2.peek())) {
                    dummy = queue2.poll();
                    stack.add(dummy);
                }
            }
            return (double) stack.pop();
        }
    }
}
