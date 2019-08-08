package codingpatterns.slidingwindow;

/***
 * PS: Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * TC : O(N)
 * SC : O(1)
 */
public class MinSizeSubArraySum {



    public static int calculateMinLen(int S, int[] array) {
        int minLen = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < array.length ; windowEnd++) {
            windowSum += array[windowEnd];

            while (windowSum >= S) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.calculateMinLen(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.calculateMinLen(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
    }
}
