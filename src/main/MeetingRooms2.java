package main;

import java.util.Arrays;

public class MeetingRooms2 {
    public static void main (String[] args) {
        int[][] intervals = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startTimePointer = 1;
        int endTimePointer = 0;

        int numberOfRooms = 1;

        while (startTimePointer < intervals.length) {
            if (startTimes[startTimePointer] >= endTimes[endTimePointer]) {
                endTimePointer++;
            } else {
                numberOfRooms++;
            }
            startTimePointer++;
        }

        return numberOfRooms;

    }
}
