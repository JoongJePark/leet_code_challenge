import java.lang.reflect.Array;
import java.util.*;

class RandomizedSet {
    /**
     * Initialize your data structure here.
     */
    Map<Integer,Integer> hm;
    ArrayList<Integer> al;
    Random random;

    public RandomizedSet() {
        hm = new HashMap<>();
        al = new ArrayList<Integer>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hm.containsKey(val)){
            return false;
        } else {
            hm.put(val, al.size());
            al.add(al.size(), val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (hm.containsKey(val)){
            int value = hm.get(val);
            hm.remove(val);
            for (int i = value+1; i<al.size(); i++){
                hm.put(al.get(i),i-1);
            }
            al.remove(value);
            hm.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return al.get(random.nextInt(al.size()));
    }
}
