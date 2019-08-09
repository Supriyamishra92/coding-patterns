package codingpatterns.slidingwindow;

import java.util.HashMap;

public class NoRepeatSubstring {

    private static int calculateLongestSubstring(String str) {

        int windowStart = 0;
        int maxLen = 0;
        HashMap<Character, Integer> stringContainer = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'

            if (stringContainer.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                // windowStart will shift to the index of the character where it is present for the next time.

                windowStart = Math.max(windowStart, stringContainer.get(rightChar) + 1);

            }
            stringContainer.put(str.charAt(windowEnd),windowEnd);
            maxLen = Math.max(maxLen, windowEnd -windowStart+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.calculateLongestSubstring("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.calculateLongestSubstring("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.calculateLongestSubstring("abccde"));
    }
}
