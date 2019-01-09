package util;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return "" + val;
    }

    public void printTree() {
        this.printTree(this, 0);
    }

    private void printTree(TreeNode root, int indent) {
        if (root == null) {
            return;
        }

        this.printTree(root.left, indent + 1);

        for (int i = 1; i <= indent; i++) {
            System.out.print("  ");
        }
        System.out.println(root);

        this.printTree(root.right, indent + 1);
    }
}
