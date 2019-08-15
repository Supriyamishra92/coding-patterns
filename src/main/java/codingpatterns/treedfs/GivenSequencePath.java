package codingpatterns.treedfs;

/***
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 *
 * Approach :
 * We can follow DFS approach and additionally, track the element of the given
 * sequence that we should match with the current node.
 * Also, we can return false as soon as we find a mismatch between the sequence and the node value.
 *
 * TC AND SC : O(N).
 */

public class GivenSequencePath {

    private static boolean findPath(TreeNode root, int[] sequence) {

        if (root == null) {
            return sequence.length == 0;
        }
        return findPathRecursive(root,sequence, 0 );

    }
    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence , int sequenceIndex) {

        if (currentNode == null) {
            return false;
        }
        /***
         * if sequence index is bigger than length and data is not matching it
         * is not possible to have sequence.
         * if index is == length and data not matched it will be false as value is different and it was the last index where we
         * can look.
         *
         */

        if (sequenceIndex >= sequence.length || currentNode.data != sequence[sequenceIndex]) {
            return false;
        }
        /***
         * The base case, when it is matching end index with the node of the tree and it's same which makes true for all.
         */
        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1) {
            return true;
        }
        return findPathRecursive(currentNode.left, sequence, sequenceIndex +1) || findPathRecursive(currentNode.right, sequence, sequenceIndex+1);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + GivenSequencePath.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + GivenSequencePath.findPath(root, new int[] { 1, 1, 6 }));
    }
}
