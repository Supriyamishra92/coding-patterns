package codingpatterns.treebfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 *Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right, then right
 * to left for the next level and keep alternating in the same manner for the following levels.
 *
 *
 * Approach Algo:
 * Declare the result List.
 * take a current node,
 * call recursive on that node while add that node in current list
 * if Left to right is true then add else add reverse direction.
 *
 */
public class ZigzagTraversal {

    private static List<List<Integer>> zigzagTraverse(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) {
            return finalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean forwardDirection = true;
        while (!queue.isEmpty()) {

            int level = queue.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < level ; i++) {
                TreeNode currentNode = queue.poll();
                if (forwardDirection) {
                    currentLevel.add(currentNode.value);
                } else {
                    currentLevel.add(0,currentNode.value);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
            finalList.add(currentLevel);
            forwardDirection = !forwardDirection;

        }
        return finalList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.zigzagTraverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
