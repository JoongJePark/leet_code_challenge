import java.util.Arrays;
import java.util.Collections;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] sortNums = new String[n];
        for(int i=0; i<n; i++){
            sortNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sortNums, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for (String s : sortNums){
            sb.append(s);
        }
        String sol = sb.toString();
//      String sol= "";
//        for(int i=0; i<n; i++){
//            sol += sortNums[i];
//        }
        if(sol.charAt(0)=='0'){
            return "0";
        }
        return sol;
    }
}
