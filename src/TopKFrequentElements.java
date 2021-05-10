import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int input = map.get(nums[i]) + 1;
                map.put(nums[i], input);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[] sol = new int[k];
        for (Integer i : map.keySet()) {
            priorityQueue.add(i);
        }
        if(priorityQueue.isEmpty()){
            return null;
        }
        for (int i=0; i<k; i++){
            sol[i] = priorityQueue.poll();
        }
        return sol;
    }
}
