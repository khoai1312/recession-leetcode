package main;


import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("({}"));
        System.out.println(isValid(""));
        System.out.println(isValid(null));
        System.out.println(isValid("()[]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if ("({[".indexOf(currentChar) != -1) {
                tempStack.push(currentChar);
            } else {
                if (!tempStack.empty()) {
                    if ((currentChar == ')' && tempStack.peek() != '(') ||
                            (currentChar == '}' && tempStack.peek() != '{') ||
                            (currentChar == ']' && tempStack.peek() != '[')) {
                        return false;
                    } else {
                        tempStack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        return tempStack.empty();
    }
}
