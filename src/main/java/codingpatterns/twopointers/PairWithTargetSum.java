package codingpatterns.twopointers;

/***
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 */
public class PairWithTargetSum {

    private static int[] findPair(int[] array, int targetSum) {
        int left = 0;
        int right = array.length -1;

        while (left <right) {
            // comparing two value in array can cause indexOverFlow so to avoid it we can use the targetDiff
            int targetDiff = targetSum - array[left];

            if (targetDiff == array[right]) {
                return  new int[] {left,right};
            }
            if (targetDiff > array[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};

    }

    public static void main(String[] args) {

        int[] result = PairWithTargetSum.findPair(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.findPair(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
