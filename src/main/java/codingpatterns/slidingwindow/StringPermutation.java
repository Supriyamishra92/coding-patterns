package codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/***
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters it will have n!n! permutations.
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 */
public class StringPermutation {

    private static boolean check(String string, String pattern) {
        int windowStart = 0;
        int matched =0;
        Map<Character, Integer> frequency = new HashMap<>();
        String[] windowPattern = new String[pattern.length()];
        for (char c: pattern.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) +1);
        }
        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowStart);

            if (frequency.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                frequency.put(rightChar, frequency.get(rightChar) -1);
            }
            if (frequency.get(rightChar) == 0) { // character is completely matched
                matched++;
            }

            if (matched == frequency.size()) {
                return true;
            }

            if (windowEnd < pattern.length() -1) { // shrink the window by one character
                char leftChar = string.charAt(windowStart++);
                if (frequency.containsKey(leftChar)) {
                    if (frequency.get(leftChar) == 0) {
                        matched--;
                        // before putting the character back, decrement the matched count
                        // put the character back for matching
                    }
                    frequency.put(leftChar, frequency.get(leftChar) +1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.check("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.check("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.check("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.check("aaacb", "abc"));
    }
}
