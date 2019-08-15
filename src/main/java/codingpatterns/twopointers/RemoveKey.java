package codingpatterns.twopointers;

/***
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 */
public class RemoveKey {

    private static int removeKey(int[] array, int key) {
        int shift = 0;
        for (int i = 0; i <array.length ; i++) {

            if (array[i] != key) {
                array[shift] = array[i];
                shift++;
            }
        }
        return shift;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveKey.removeKey(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveKey.removeKey(arr, 2));
    }
}
