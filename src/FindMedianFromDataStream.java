import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        boolean even = true;
        PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<Integer>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (even) {
                if (small.isEmpty() || big.peek() >= num ) {
                    small.add(num);
                } else {
                    small.add(big.poll());
                    big.add(num);
                }
            } else {
                if ( small.peek() <= num) {
                    big.add(num);
                } else {
                    big.add(small.poll());
                    small.add(num);
                }
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (double) (big.peek() + small.peek()) / 2;
            } else {
                return (double) small.peek();
            }
        }
    }
}
