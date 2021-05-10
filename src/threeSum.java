import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int end;
        int start;
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return sol;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] < 0) {
                    start += 1;
                } else if (nums[start] + nums[end] + nums[i] > 0) {
                    end -= 1;
                } else if (nums[start] + nums[end] + nums[i] == 0) {
                    sol.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start += 1;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end -= 1;
                    }
                    start += 1;
                    end -= 1;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return sol;
    }
}
