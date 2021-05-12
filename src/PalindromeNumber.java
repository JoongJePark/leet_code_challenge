import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int count = 0;
        int y = x;
        while (y / 10 >= 1) {
            y = y / 10;
            count += 1;
        }
        int[] arr = new int[count+1];
        for (int i = 0; i < count+1; i++) {
            arr[i] = x % 10;
            x = x / 10;
        }
        for (int i = 0; i < count+1; i++) {
            if (arr[i] != arr[count - i]) {
                return false;
            }
        }
        return true;
    }
}
