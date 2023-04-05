package main;

import java.util.Map;
import java.util.HashMap;


public class SubarraysSumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int outputCount = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumCounter = new HashMap<>();

        for (int num : nums) {
            currentSum += num;
            if (currentSum == k) {
                outputCount++;
            }
            int difference = currentSum - k;
            if (sumCounter.containsKey(difference)) {
                int numberOfSubarraysToChop = sumCounter.get(difference);
                outputCount += numberOfSubarraysToChop;
            }
            sumCounter.put(currentSum, sumCounter.getOrDefault(currentSum, 0) + 1);

        }
        return outputCount;

    }
}
