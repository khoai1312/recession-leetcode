package main;

public class ValidPalindrome {
    public static void main (String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("Race a car"));
    }

    public static boolean isPalindrome(String s) {
        String lowercaseStr = s.toLowerCase();
        String nonAlphanumericStr = lowercaseStr.replaceAll("[^A-Za-z0-9]", "");
        System.out.println("non-alphanumeric string : " + nonAlphanumericStr);

        int start = 0;
        int end = nonAlphanumericStr.length() - 1;

        while (start < nonAlphanumericStr.length() && end > 0) {
            if (nonAlphanumericStr.charAt(start) != nonAlphanumericStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

}
