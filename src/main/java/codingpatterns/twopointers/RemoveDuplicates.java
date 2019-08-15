package codingpatterns.twopointers;

/***
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates
 * in-place return the new length of the array.
 *
 *
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the
 * duplicates will be [2, 3, 6, 9].
 */
public class RemoveDuplicates {

    private static int remove(int[] array) {
        int count = 1;
        for (int i = 0; i < array.length - 1 ; i++) {
            if (array[i] != array[i+1]) {
                count++;
            }
        }
        return count;
    }

    private static int twoPointerRemove(int[] array) {
        int nextUniqueNumber = 1;
        for (int i = 1 ; i <array.length ; i++) {
            if (array[nextUniqueNumber -1] != array[i]) {
                array[nextUniqueNumber] = array[i];
                nextUniqueNumber++;
            }

        }
        return nextUniqueNumber;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(" Brute force Method "+RemoveDuplicates.remove(arr));
        System.out.println(" Two Pointer Method "+RemoveDuplicates.twoPointerRemove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(" Brute force Method "+RemoveDuplicates.remove(arr));
        System.out.println(" Two Pointer Method "+RemoveDuplicates.twoPointerRemove(arr));



        arr = new int[] { 2, 2, 2, -2 };
        System.out.println(" Brute force Method "+RemoveDuplicates.remove(arr));
        System.out.println(" Two Pointer Method "+RemoveDuplicates.twoPointerRemove(arr));



    }

}
