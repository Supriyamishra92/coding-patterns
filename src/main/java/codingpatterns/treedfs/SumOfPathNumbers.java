package codingpatterns.treedfs;

/***
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf
 * path will represent a number. Find the total sum of all the numbers represented by all paths.
 *
 * store the sum at each node and call left and right node with calculated sum so far till reach the leaf of the tree.
 */
public class SumOfPathNumbers {

    private static int pathNumberSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return calculateSum(root, 0);

    }

    private static int calculateSum(TreeNode currentNode, int pathSum) {

        if (currentNode == null) {
            return 0;
        }
        // calculate the path number of the current node
        pathSum = pathSum * 10 + currentNode.data;

        //  Base case : if the current node is a leaf, return the current path sum.
        if (currentNode.right == null && currentNode.left == null) {
            return pathSum;
        }
        // traverse the left and the right sub-tree
        return calculateSum(currentNode.left,pathSum) + calculateSum(currentNode.right , pathSum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.pathNumberSum(root));
    }
}
