package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class HighFive {
    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        System.out.println(highFive(items));
    }

    public static int[][] highFive(int[][] items) {
        sortByColumn(items, 1);
        HashMap<Integer, Integer> studentToScoreMap = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (studentToScoreMap.containsKey(items[i][0])) {
                
            }
        }
        return items;

    }

    public static void sortByColumn (int[][] intArray, int columnIndex) {
        // Sort the array based on the second column
        Arrays.sort(intArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
    }
}
