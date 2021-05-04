import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == index) {
                index += 1;
            }
        }
        return index;
    }
}
