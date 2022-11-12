package main;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main (String[] args) {
        System.out.println(isValidAnagram("nagaram", "anagram"));
        System.out.println(isValidAnagram("rat", "car"));
    }

    /*
    TODO : is there a more efficient way to solve this ?
    TODO : more efficient way to traverse through a string ?
     */
    public static boolean isValidAnagram (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countCharacters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (countCharacters.containsKey(currentChar)) {
                countCharacters.put(currentChar, countCharacters.get(currentChar) + 1);
            } else {
                countCharacters.put(currentChar, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (countCharacters.containsKey(currentChar)) {
                countCharacters.put(currentChar, countCharacters.get(currentChar) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : countCharacters.entrySet()) {
            int count = entry.getValue();
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
