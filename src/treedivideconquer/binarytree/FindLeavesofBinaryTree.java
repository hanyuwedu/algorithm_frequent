package treedivideconquer.binarytree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesofBinaryTree {
    /**
     * 12/3
     *
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> leaves = new ArrayList<>();
        Map<Integer, List<Integer>> levels = new HashMap<>();
        getLevel(root, levels);

        for (int i = 1; levels.containsKey(i); i++) {
            leaves.add(levels.get(i));
        }

        return leaves;
    }

    private int getLevel(TreeNode root, Map<Integer, List<Integer>> levels) {
        if (root == null) {
            return 0;
        }

        int currentLevel = Math.max(getLevel(root.left, levels), getLevel(root.right, levels)) + 1;

        if (!levels.containsKey(currentLevel)) {
            levels.put(currentLevel, new ArrayList<>());
        }
        levels.get(currentLevel).add(root.val);

        return currentLevel;
    }
}
