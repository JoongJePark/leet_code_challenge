public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return new String();
        }
        String sol = strs[0];
        for (int i=1; i<strs.length; i++){
            for(int j=0; j< Math.min(sol.length(), strs[i].length()); j++){
                if(sol.charAt(j)==strs[i].charAt(j)){

                }
            }
        }
        return sol;
    }
}
