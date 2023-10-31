package main;

public class RansomNote {
    public static boolean canConstruct (String magazine, String ransomNote) {
        char[] ransomNoteChars = ransomNote.toCharArray();
        int[] magazineCharMap = new int[26];
        for (char c : ransomNoteChars) {
            System.out.println("current character in ransom: " + c);
            int srcIndex = magazine.indexOf(c, magazineCharMap[c - 'a']);
            System.out.println("magazineCharMap[c - 'a'] is " + magazineCharMap[c - 'a']);
            System.out.println("srcIndex is " + srcIndex);
            if (srcIndex == -1) {
                return false;
            }
            magazineCharMap[c - 'a'] = srcIndex + 1;
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(canConstruct("aab", "aa"));
    }
}
