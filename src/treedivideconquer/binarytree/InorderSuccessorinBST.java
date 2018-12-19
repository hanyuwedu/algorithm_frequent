package treedivideconquer.binarytree;

import util.TreeNode;

public class InorderSuccessorinBST {
    /**
     * 12/5
     * Divide and conquer
     *
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val) {
            TreeNode next = inorderSuccessor(root.left, p);
            if (next != null) {
                return next;
            } else {
                return root;
            }
        } else if (root.val < p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            return inorderSuccessor(root.right, p);
        }
    }


    /**
     * 12/5
     * two period search
     *
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor_two_phase_search(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }

        if (p.right != null) {
            TreeNode next = p.right;
            while (next.left != null) {
                next = next.left;
            }

            return next;
        }

        TreeNode target = root, parent = null;
        while (target != null && target != p) {
            if (target.val > p.val) {
                parent = target;
                target = target.left;
            } else {
                target = target.right;
            }
        }

        if (target == p) {
            return parent;
        } else {
            return null;
        }
    }
}
