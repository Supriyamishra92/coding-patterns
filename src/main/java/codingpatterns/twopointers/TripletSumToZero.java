package codingpatterns.twopointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/***
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */

public class TripletSumToZero {



    private static List<List<Integer>> tripletSum(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < array.length -2 ; i++) {
            if (i > 0 && array[i] == array[i - 1]) {  // skip same element to avoid duplicate triplets
                continue;
            }
            searchTriplet(array, -array[i], i + 1, resultList);
        }
        return resultList;
    }

    private static void searchTriplet(int[] array, int targetSum, int left, List<List<Integer>> resultList) {
        int right = array.length -1;
        while (left < right) {
            // comparing the sum of two numbers to the 'targetSum' can cause integer overflow
            // so, we will try to find a target difference instead
            int targetDiff = targetSum - array[left];

            if (targetDiff == array[right]) {
                resultList.add(Arrays.asList( -targetSum, array[left], array[right]));
                left++;
                right--;
                while (left < right && array[left] == array[left -1]) {
                    left++; // skip same element to avoid duplicate triplets
                }
                while (left < right && array[right] == array[right + 1]) {
                    right--; // skip same element to avoid duplicate triplets
                }
            } else if (targetDiff > array[right]) {
                left++;   // we need a pair with a bigger sum
            } else {
                right--;  // we need a pair with a bigger sum
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(TripletSumToZero.tripletSum(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.tripletSum(new int[] { -5, 2, -1, -2, 3 }));
    }
}

