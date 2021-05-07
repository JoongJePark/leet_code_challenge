import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    List<String> sol = new ArrayList<String>();
    void recur(String input, String digits, int index) {
        if(index == digits.length()){
            sol.add(input);
            return;
        }
        if(digits.charAt(index) == '2'){
            recur(input+"a", digits, index+1);
            recur(input+"b", digits, index+1);
            recur(input+"c", digits, index+1);
        } else if(digits.charAt(index) == '3'){
            recur(input+"d", digits, index+1);
            recur(input+"e", digits, index+1);
            recur(input+"f", digits, index+1);
        } else if(digits.charAt(index) == '4'){
            recur(input+"g", digits, index+1);
            recur(input+"h", digits, index+1);
            recur(input+"i", digits, index+1);
        } else if(digits.charAt(index) == '5'){
            recur(input+"j", digits, index+1);
            recur(input+"k", digits, index+1);
            recur(input+"l", digits, index+1);
        } else if(digits.charAt(index) == '6'){
            recur(input+"m", digits, index+1);
            recur(input+"n", digits, index+1);
            recur(input+"o", digits, index+1);
        } else if(digits.charAt(index) == '7'){
            recur(input+"p", digits, index+1);
            recur(input+"q", digits, index+1);
            recur(input+"r", digits, index+1);
            recur(input+"s", digits, index+1);
        } else if(digits.charAt(index) == '8'){
            recur(input+"t", digits, index+1);
            recur(input+"u", digits, index+1);
            recur(input+"v", digits, index+1);
        } else if(digits.charAt(index) == '9'){
            recur(input+"w", digits, index+1);
            recur(input+"x", digits, index+1);
            recur(input+"y", digits, index+1);
            recur(input+"z", digits, index+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return sol;
        }
        recur("", digits ,0);
        return sol;
    }
}
