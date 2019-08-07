package codingpatterns.slidingwindow;


import java.util.Arrays;

/***
 * PS: Given an array, find the average of all subarrays of size ‘K’ in it.
 *  A brute force solution would be for this problem to calculate
 *  sum of every K elements and divide by K to find the average.
 *  Time Complexity : O(N∗K)
 *   ** How We can improve this ? **
 */

public class AverageOfSubArrayOfSizeKBrute {

    public static double[] calculateAverages(int K, int[] input ) {

        double[] result = new double[input.length -K + 1];
        for (int i = 0; i <= input.length - K; i++) {
            double sum = 0;
            // find the sum of next 'K' elements.

            for (int j = i; j < i+K; j++) {
                sum += input[j];
            }
            result[i] = sum/K; // calculate average
        }
        return result;
    }

    public static void main(String[] args) {

        double[] result = AverageOfSubArrayOfSizeKBrute.calculateAverages(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2});

        System.out.println(" Averages of the Subarray : " + Arrays.toString(result));


    }
}
