package codingpatterns.slidingwindow;

import java.util.HashMap;

/***
 * PS:  Given an array of characters where each character represents a fruit tree, you are given two
 *  baskets and your goal is to put maximum number of fruits in each basket.
 *  The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop
 * when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 *
 *
 *
 */
public class MaxFruitCountOf2Types {

    private static int maximizeFruits(char[] trees) {

        if (trees == null || trees.length == 0 || trees.length < 2) {
            throw new IllegalArgumentException();
        }

        int maxFruits = 0;
        int windowStart = 0;

        HashMap<Character,Integer> fruitsContainer = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < trees.length ; windowEnd++) {

            char currentFruit = trees[windowEnd];
            fruitsContainer.put(currentFruit, fruitsContainer.getOrDefault(currentFruit, 0)+1);

            while (fruitsContainer.size() > 2) {

                fruitsContainer.put(trees[windowStart], fruitsContainer.get(trees[windowStart])-1);

                if (fruitsContainer.get(trees[windowStart])==0) {
                    fruitsContainer.remove(trees[windowStart]);

                }
                windowStart++;

            }

            maxFruits = Math.max(maxFruits, windowEnd -windowStart +1);
        }
        return maxFruits;

    }
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.maximizeFruits(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.maximizeFruits(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
