package codingpatterns.slidingwindow;

import java.util.HashMap;

/***
 * PS :Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * TS : O(N+N) which is asymptotically equivalent to O(N)
 * SC : O(K) as we will be storing a maximum of ‘K+1’ characters in the HashMap.
 *
 *
 */
public class LongestSubstringKDistinct {


    public static int findLength(String str, int k) {

        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }
        int windowStart = 0;
        int maxLen = 0;

        HashMap<Character, Integer> charFrequecy = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);
            charFrequecy.put(rightChar, charFrequecy.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequecy.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequecy.put(leftChar, charFrequecy.get(leftChar) -1);
                if (charFrequecy.get(leftChar) == 0) {
                    charFrequecy.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLen = Math.max(maxLen, windowEnd- windowStart + 1); // remember the maximum length so far
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));

    }
}