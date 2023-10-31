package main;

public class FirstBadVersion {

    public static boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            /**
             * left + (right - left)/2 is better than (right + left)/2 because
             * (right + left) can cause integer overflow if it's > 2147483647
             */
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // search zone becomes [left, mid] (inclusive)
            } else {
                left = mid + 1; // search zone becomes [mid + 1, right] (inclusive)
            }
        }
        return left;
    }
}
