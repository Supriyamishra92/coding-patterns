package codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Stack;

/***
 * PS: Given a string with lowercase letters only, if you are allowed to replace no
 * more than ‘k’ letters with any letter, find the length of the longest substring
 * having the same letters after replacement.
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 *
 *
 */
public class CharacterReplacementBrute {

    public static int maximizeSubstring(String string, int k) {
        int maxLen = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length() ; i++) {
            char current = string.charAt(i);
            if (!stack.isEmpty()) {
                char value = stack.peek();
                if (current == value) {
                    stack.add(current);
                } else {
                    while (k<=2) {
                        stack.add(current);
                        k++;
                    }
                    maxLen = Math.max(stack.size(), maxLen);
                }
            } else {
                stack.add(current);
            }
        }
    return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacementBrute.maximizeSubstring("aabccbb", 2));
        System.out.println(CharacterReplacementBrute.maximizeSubstring("abbcb", 1));
        System.out.println(CharacterReplacementBrute.maximizeSubstring("abccde", 1));
    }

}
