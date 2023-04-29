package main;

import java.util.*;


public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        // convert deadends Array to a Set so it's easier to check
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.add("0000");
        queue.add(null);

        seen.add("0000");
        seen.add(null);

        int stepCounter = 0;
        while (!queue.isEmpty()) {
            String currentNum = queue.remove();
            if (currentNum == null) {
                stepCounter++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            }
            // if current number is the target, return no of steps
            else if (currentNum.equals(target)) {
                return stepCounter;
            }
            else if (!dead.contains(currentNum)) {
                for (String neighbor : getNeighbors(currentNum)) {
                    if (!seen.contains(neighbor)) {
                        queue.add(neighbor);
                        seen.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> getNeighbors (String num) {
        List<String> neighbors = new ArrayList<>();

        // for each position in the lock i = 0, 1, 2, 3
        for (int i = 0; i < 4; i++) {
            // for each of the turns j = -1, 1 (turn backwards or forwards)
            for (int j = -1; j <= 1; j += 2) {
                // determine the value of the position after it's been turned
                int intValue = num.charAt(i) - '0';
                int valueAfterTurn = ((intValue + j) + 10) % 10;
                String lockStrValue = num.substring(0, i) + valueAfterTurn + num.substring(i + 1);
                neighbors.add(lockStrValue);
            }
        }
        return neighbors;
    }
}
