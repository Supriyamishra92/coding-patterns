package codingpatterns.slidingwindow;

import java.util.Arrays;

/***
 * Problem: Given an array, find the average of all subarrays of size ‘K’ in it.
 * Efficient solution provided
 *
 * The efficient way to solve this problem would be to visualize each subarray as a sliding window of ‘K’ elements.
 * This means that when we move on to the next subarray, we will slide the window by one element.
 * So, to reuse the sum from the previous subarray, we will subtract the element going out of the window
 * and add the element now being included in the sliding window. This will save us from going through the
 * whole subarray to find the sum and, as a result, the algorithm complexity will reduce to O(N).
 */



public class AverageOfSubarrayOfSizeK {

    public static double[] calculateAverages(int K, int[] input) {
        double[] result = new double[input.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < input.length ; windowEnd++) {
            windowSum += input[windowEnd]; // Add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'K'
            if (windowEnd >= K -1) {

                result[windowStart] = windowSum/K; // calculate the average
                windowSum -= input[windowStart]; // subtract the element going out
                windowStart++; // slide the window forward
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.calculateAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));


    }
}
