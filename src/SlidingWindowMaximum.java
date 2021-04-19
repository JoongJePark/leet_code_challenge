import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] sol = new int[n - k + 1];
        int localBest;
        int localWorst;
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        localBest = Collections.max(queue);
        localWorst = Collections.min(queue);
        sol[0] = localBest;
        for (int i = k; i < n; i++) {
            if (localBest == queue.peek() && localWorst == queue.peek()) {
                queue.remove();
                localBest = (queue.isEmpty()) ? Integer.MIN_VALUE : Collections.max(queue);
                localWorst = (queue.isEmpty()) ? Integer.MAX_VALUE : Collections.min(queue);
                if (localBest <= nums[i]) {
                    localBest = nums[i];
                }
                if (localWorst >= nums[i]) {
                    localWorst = nums[i];
                }
                if (localWorst <= nums[i]) {
                    queue.offer(nums[i]);
                }
            } else if (localBest == queue.peek()) {
                queue.remove();
                localBest = (queue.isEmpty()) ? Integer.MIN_VALUE : Collections.max(queue);
                if (localBest <= nums[i]) {
                    localBest = nums[i];
                }
                if (localWorst >= nums[i]) {
                    localWorst = nums[i];
                }
                if (localWorst <= nums[i]) {
                    queue.offer(nums[i]);
                }
            } else if (localWorst == queue.peek()) {
                queue.remove();
                localWorst = (queue.isEmpty()) ? Integer.MAX_VALUE : Collections.min(queue);
                if (localBest <= nums[i]) {
                    localBest = nums[i];
                }
                if (localWorst >= nums[i]) {
                    localWorst = nums[i];
                }
                if (localWorst <= nums[i]) {
                    queue.offer(nums[i]);
                }
            } else {
                queue.remove();
                if (localBest <= nums[i]) {
                    localBest = nums[i];
                }
                if (localWorst >= nums[i]) {
                    localWorst = nums[i];
                }
                if (localWorst <= nums[i]) {
                    queue.offer(nums[i]);
                }
            }
            sol[i - k + 1] = localBest;
        }
        return sol;
    }
}
