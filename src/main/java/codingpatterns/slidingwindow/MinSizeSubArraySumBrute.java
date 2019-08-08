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
public class MinSizeSubArraySumBrute {

    public static int calculateSubArraySize(int S, int[] array) {

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {

            int sum = 0;
            int len = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                len++;
                if (sum >= S) {
                    minLen = Math.min(minLen, len);
                    break;
                }
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySumBrute.calculateSubArraySize(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
    }
}
