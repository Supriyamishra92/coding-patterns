package codingpatterns.treebfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/****
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 *
 * We can use a Queue to efficiently traverse in BFS fashion. Here are the steps of our algorithm:
 *
 * Start by pushing the root node to the queue.
 * Keep iterating until the queue is empty.
 * In each iteration, first count the elements in the queue (let’s call it levelSize). We will have these many nodes in the current level.
 * Next, remove levelSize nodes from the queue and push their value in an array to represent the current level.
 * After removing each node from the queue, insert both of its children into the queue.
 * If the queue is not empty, repeat from step 3 for the next level.
 *
 * TC & SC : O(N)
 */


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        this.value = data;

    }
}
public class LevelOrderTraversal {

    private static List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.println("Level No:" + levelSize);
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                currentLevel.add(currentNode.value);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);

    }


}
