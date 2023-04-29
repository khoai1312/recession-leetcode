package main;

import java.util.*;


public class MaximumSizeSubarraySumEqualK {

    public int maxSubArrayLen(int[] nums, int k) {
        // key of this problem is to keep track of running sum at each index
        int runningSum = 0;
        int longestSubarraySize = 0;
        Map<Integer, Integer> runningSumMapper = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            // check if all the numbers seen so far add up to k
            if (runningSum == k) {
                longestSubarraySize = i + 1;
            }
            // if any subarray seen so far sums to k
            // update the length of longest subarray
            if (runningSumMapper.containsKey(runningSum - k)) {
                int eligibleSubarray = i - runningSumMapper.get(runningSum - k);
                longestSubarraySize = Math.max(longestSubarraySize, eligibleSubarray);
            }

            // only add the current running sum to map
            // if it's not in the map yet
            if (!runningSumMapper.containsKey(runningSum)) {
                runningSumMapper.put(runningSum, i);
            }
        }
        return longestSubarraySize;
    }
}
