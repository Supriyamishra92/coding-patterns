package codingpatterns.slidingwindow;
/***
 * PS : Given an array of numbers and a positive number ‘K’, find the maximum sum of any contiguous subarray of size ‘K’.
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * TC : O(N*K)
 */
public class MaxSumSubArrayOfSizeK {


    public static int calculateMaxSum(int K, int[] array) {
        int windowSum = 0;
        int maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'K'
            if (windowEnd >= K - 1) {

                maxSum = Math.max(windowSum, maxSum);
                windowSum -= array[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {


        int result = MaxSumSubArrayOfSizeK.calculateMaxSum(3, new int[] {2,1,5,6,-3,9});
        System.out.println("Max sum of sub arrays : " + result);

    }


}
