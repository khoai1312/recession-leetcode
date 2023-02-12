package main;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static void main (String[] args) {

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals1)); // expect : False

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals2)); // expect : True

    }


    public static boolean canAttendMeetings(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // sort the 2D arrays by meeting start time
        // check if the start time >= previous end time --> can attend
        sort2dArrayByIndex(intervals, 0);

        int previousEndTime = intervals[0][1];
        boolean canAttend = true;

        for (int i = 1; i < intervals.length; i++) {
            int currentStartTime = intervals[i][0];
            if (currentStartTime < previousEndTime) {
                canAttend = false;
            }
            previousEndTime = intervals[i][1];
        }

        return canAttend;

    }

    public static void sort2dArrayByIndex(int[][] arrayToSort, int index) {
        Arrays.sort(arrayToSort, Comparator.comparingInt(obj -> obj[index]));
        /*
        Another option is anonymous class :

        Arrays.sort (arrayToSort, new Comparator<int[]>() {
            @Override
            public int compare (int[] obj1, int[] obj2) {
                return obj1[index] - obj2[index];
            }
        }
        );
         */
    }
}
