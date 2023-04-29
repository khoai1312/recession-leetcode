package main;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatChars {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> mapCharToIndex = new HashMap<>();
        int output = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (mapCharToIndex.containsKey(currentChar)) {
                start = Math.max(mapCharToIndex.get(currentChar) + 1, start);
            }
            output = Math.max(output, end - start + 1);
            mapCharToIndex.put(currentChar, end);

        }
        return output;
    }
}
