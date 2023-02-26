package main;

import java.util.Queue;
import java.util.LinkedList;

public class HitCounter {
        private final Queue<Integer> hitCounter;

        public HitCounter() {
            hitCounter = new LinkedList<>();
        }

        public void hit(int timestamp) {
            hitCounter.add(timestamp);
        }

        /*
        @param timestamp - the current timestamp in second
        @return the number of hits in the past 5 minutes
        */

        public int getHits(int timestamp) {
            while (!this.hitCounter.isEmpty()) {
                // view the head of the queue
                int head = this.hitCounter.peek();
                if (timestamp - head >= 300) {
                    // remove the head of the queue if it came before the past 300 seconds
                    this.hitCounter.remove();
                } else {
                    break;
                }
            }
            return this.hitCounter.size();
        }


}
