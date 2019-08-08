package codingpatterns.slidingwindow;


/***
 * PS :Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Brute force Solution :
 *  Tracking the max length of substring by Using hashMap and size as the key is the distinct character in the map,
 *  when it's size is greater than K, checking again if any possibility to get another max len > current max length
 *  if not return maxlen else keep checking.
 *
 *
 *
 */

import java.util.HashMap;

public class LongestSubstringKDistinctBrute {

    public static int findLength(String str, int k) {
        // declared right and left to track the substring  max-len.
        int maxLen = 0;
        int left = 0;
        int right = 0;

        // keys are distinct character and values are their frequency in string.
        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // if character is present in map
            if (map.containsKey(currentChar)) {
                right++; // increment the right len
                // increment the frequency of character in map.
                map.put(currentChar, map.get(currentChar) + 1);

            } else if (map.size() == k) {          // if map is contains K distinct characters.

                // TODO Explain in better way
                if (map.get(str.charAt(left))==1) {
                    map.remove(str.charAt(left));
                    map.put(currentChar, 1);
                    right++;
                    left++;
                } else {
                    left = i;
                    right =  i + 1;
                    map.clear();
                    map.put(currentChar, 1);
                }
            } else {
                right++;
                map.put(currentChar, 1);
            }
            maxLen = Math.max(right - left, maxLen);

        }
        return maxLen;

    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinctBrute.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinctBrute.findLength("araaci", 1));

    }



}
