package treedivideconquer.binarytree;

import util.TreeNode;

public class ConvertBSTtoGreaterTree {
    /**
     * 12/5
     *
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        sum(root, 0);
        return root;
    }

    private int sum(TreeNode root, int parentAdds) {
        if (root == null) {
            return 0;
        }

        int rightSum = sum(root.right, parentAdds);
        int leftSum = sum(root.left, parentAdds + root.val + rightSum);

        int currentSum = rightSum + leftSum + root.val;
        root.val += rightSum + parentAdds;
        return currentSum;
    }


    /**
     * 12/5
     * sum - left node
     *
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST_sustract(TreeNode root) {
        if (root == null) {
            return null;
        }

        int sum = getSum(root);
        convert(root, sum);

        return root;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getSum(root.left) + getSum(root.right) + root.val;
    }

    private int convert(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int leftSum = convert(root.left, sum);
        int rightSum = convert(root.right, sum - root.val - leftSum);

        int current = leftSum + rightSum + root.val;
        root.val = sum - leftSum;

        return current;
    }
}
