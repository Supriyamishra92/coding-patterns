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
public class MaxFruitCountOf2TypesBrute {



    public static int maximizeFruits(char[] fruitsTree) {
        int maxFruits = 0;
        int leftShift = 0;
        int rightShift = 0;

        HashMap<Character, Integer> fruitsCount = new HashMap<>();

        for (int i = 0; i < fruitsTree.length; i++) {

            char currentTree = fruitsTree[i];

            if (fruitsCount.containsKey(currentTree)) {
                rightShift++;
                fruitsCount.put(currentTree, fruitsCount.getOrDefault(currentTree, 0) + 1);
            } else if (fruitsCount.size() == 2) {
                if (fruitsCount.get(fruitsTree[leftShift]) == 1) {
                    fruitsCount.remove(fruitsTree[leftShift]);
                    fruitsCount.put(currentTree, 1);
                    leftShift++;
                    rightShift++;
                } else {
                    leftShift = i;
                    rightShift = i +1;
                    fruitsCount.clear();
                    fruitsCount.put(currentTree, 1);
                }
            } else {
                rightShift++;
                fruitsCount.put(currentTree, 1);
            }
            maxFruits = Math.max(rightShift - leftShift, maxFruits);


        }



        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2TypesBrute.maximizeFruits(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2TypesBrute.maximizeFruits(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

}
