package codingpatterns.treedfs;


import java.util.TreeSet;

/***
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 *1 2 3 4 5 6 7
 *  S: 10 Output: true
 *  Explaination: The path with sum '10' is possible
 *
 *  TC and SC = O(N)
 */

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.data = value;
    }

}
public class BinaryTreePathSum {

    private static boolean hasPath(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.data == sum && root.left == null && root.right == null) {
            return true;
        } else {
            // recursively call to traverse the left and right sub-tree
            // return true if any of the two recursive call return true
            return  hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 16));
    }
}
