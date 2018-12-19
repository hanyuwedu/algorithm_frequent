package treedivideconquer.binarytree;

import util.TreeNode;

public class BinaryTreeUpsideDown {
    /**
     * 12/5
     * divide and conquer
     *
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode originalLeft = root.left;
        TreeNode newRoot = upsideDownBinaryTree(root.left);

        if (originalLeft == null) {
            return root;
        } else {
            originalLeft.left = root.right;
            originalLeft.right = root;
            root.right = null;
            root.left = null;
            return newRoot;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2), node3 = new TreeNode(3), node4 = new TreeNode(4), node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node = new BinaryTreeUpsideDown().upsideDownBinaryTree(node1);
        System.out.println(node.val);
    }
}
