package main;

public class MaximumProductArray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max_so_far = nums[0];
        int min_so_far = nums[0]; // to handle negative numbers
        int output = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            // can't update max_so_far here because max_so_far is still being used to calculate min_so_far below
            // use a temporary variable to store max store far, and update after calculating min_so_far
            int tempMax = Math.max(currentNum, Math.max(currentNum * max_so_far, currentNum * min_so_far));
            min_so_far = Math.min(currentNum, Math.min(currentNum * max_so_far, currentNum * min_so_far));

            max_so_far = tempMax;
            output = Math.max(output, max_so_far);
        }
        return output;
    }
}
