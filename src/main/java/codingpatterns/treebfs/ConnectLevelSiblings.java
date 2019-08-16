package codingpatterns.treebfs;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;
    TreeNodes next;
    TreeNodes(int x) {
        val = x;
        left = right = next = null;
    }
    public void printLevelOrder() {
        TreeNodes nextNode = this;
        while (nextNode != null ) {
            TreeNodes current = nextNode;
            nextNode = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextNode == null) {
                    if (current.left != null) {
                        nextNode = current.left;
                    }
                    else if (current.right != null) {
                        nextNode = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class ConnectLevelSiblings {

    public static void connect(TreeNodes root) {
        if (root == null) {
            return;
        }
        Queue<TreeNodes> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNodes prev = null;
            int size = queue.size();

            for (int i = 0; i < size ; i++) {
                TreeNodes current = queue.poll();
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        TreeNodes root = new TreeNodes(12);
        root.left = new TreeNodes(7);
        root.right = new TreeNodes(1);
        root.left.left = new TreeNodes(9);
        root.right.left = new TreeNodes(10);
        root.right.right = new TreeNodes(5);
        ConnectLevelSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
