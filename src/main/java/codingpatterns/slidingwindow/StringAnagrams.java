package codingpatterns.slidingwindow;

import java.util.*;

/***
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 */
public class StringAnagrams {

    public static void main(String[] args) {

        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }

    private static List<Integer> findStringAnagrams(String string, String pattern) {
        int windowStart = 0;
        int matched =0;
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch,0) + 1);
        }
        List<Integer> resultIndices = new ArrayList<>();

        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char right = string.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFreq.containsKey(right)) {
                charFreq.put(right, charFreq.get(right) -1);
                if (charFreq.get(right) == 0) {
                    matched++;
                }
            }
            if (matched == charFreq.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() -1) {
                char left = string.charAt(windowStart++);
                if (charFreq.containsKey(left)) {
                    if (charFreq.get(left) == 0) {
                        matched--;
                    }
                    charFreq.put(left, charFreq.get(left)+1);
                }
            }

        }
        return resultIndices;

    }

}
