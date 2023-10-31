package main;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main (String[] args) {
        System.out.println(isAnagram("nagaram", "anagram"));
        System.out.println(isAnagram("rat", "car"));
    }

    /*
    TODO : is there a more efficient way to solve this ?
    TODO : more efficient way to traverse through a string ?
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] characterCounter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            characterCounter[s.charAt(i) - 'a']++;
            characterCounter[t.charAt(i) - 'a']--;
        }

        for (int count : characterCounter) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }
}
