package codingpatterns.slidingwindow;

import java.util.HashMap;

/***
 *  PS : Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Input: String="aabacbcbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 *
 *
 *
 *
 */
public class NoRepeatSubstringBrute {

    private static int longestUniqueSubstring(String str) {

        if (str.length() == 0 ) {
            throw new IllegalArgumentException();
        }

        HashMap<Character,Integer> map=new HashMap();
        int left = 0,max=0;
        for(int i=0;i<str.length();i++){

            char currentChar = str.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                map.clear();
                map.put(currentChar,1);
            }

            max=Math.max(map.size(),max);


        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstringBrute.longestUniqueSubstring("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstringBrute.longestUniqueSubstring("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstringBrute.longestUniqueSubstring("abccde"));

    }
}
