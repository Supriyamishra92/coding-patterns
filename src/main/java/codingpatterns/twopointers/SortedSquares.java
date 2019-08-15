package codingpatterns.twopointers;

/***
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 *
 */
public class SortedSquares {
    private static int[] sortedSquare(int[] array) {
        int len = array.length - 1;
        int[] squares = new int[len+1];
        int left = 0;
        int right = len -1;
        int maxIndex = len;
        while (left <= right) {
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right]* array[right];

            if (leftSquare > rightSquare) {
                squares[len--] = leftSquare;
                left++;
            } else {
                squares[len--] = rightSquare;
                right--;
            }

        }
        return squares;

    }

    public static void main(String[] args) {

        int[] result = SortedSquares.sortedSquare(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedSquares.sortedSquare(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
