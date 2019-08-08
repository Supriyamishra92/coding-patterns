package codingpatterns.slidingwindow;
/***
 * PS : Given an array of numbers and a positive number ‘K’, find the maximum sum of any contiguous subarray of size ‘K’.
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * TC : O(N*K)
 */
public class MaxSumSubArrayOfSizeKBrute {

    public static int calculateSum(int K, int[] array) {

        int result = 0;

        int maxSum = 0;
        for (int i = 0; i < array.length - K; i++) {
            int sum = 0;
            for (int j = i; j <i+K; j++) {
                sum += array[j];
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
            result = Math.max(sum, maxSum);
        }
        return result;

    }

    public static void main(String[] args) {
        int result = MaxSumSubArrayOfSizeKBrute.calculateSum(3, new int[] { 2, 1, 5, -3, 9, 5, -5,3,2});
        System.out.println("Max Sum " +result);
    }
}
