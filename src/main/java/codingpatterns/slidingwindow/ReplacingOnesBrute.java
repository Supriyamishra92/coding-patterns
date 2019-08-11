package codingpatterns.slidingwindow;

import java.util.Stack;

/***
 *
 * PS : Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest subarray having all 1s.
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest subarray of 1s having length 6.
 *
 *
 */
public class ReplacingOnesBrute {

    private static int maximizeOnes(int[] array, int k) {

        //0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int ones = 0;
            int chance = 0;
            for (int j = i; j < array.length ; j++) {
                   if (array[j] == 0 ) {
                       if (chance < k) {
                           chance++;
                           ones++;
                       } else {
                           break;
                       }
                   } else {
                       ones++;
                   }
            }
        max = Math.max(ones, max);
        }
       return max;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnesBrute.maximizeOnes(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnesBrute.maximizeOnes(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }



}
