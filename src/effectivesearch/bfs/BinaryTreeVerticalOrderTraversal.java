package effectivesearch.bfs;

import util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {
    /**
     * 12/8
     * BFS for levels, DFS for verticals
     *
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<TreeNode, Integer> levels = getLevels(root);
        Map<Integer, List<TreeNode>> verticals = getVerticals(root);

        List<List<Integer>> order = new ArrayList<>();
        List<Integer> verticalList = new ArrayList<>(verticals.keySet());
        Collections.sort(verticalList);

        for (int vertical : verticalList) {
            List<TreeNode> current = new ArrayList<>(verticals.get(vertical));

            Collections.sort(current, (a, b) -> {
                if (levels.get(a) != levels.get(b)) {
                    return levels.get(a) - levels.get(b);
                } else {
                    return verticals.get(vertical).indexOf(a) - verticals.get(vertical).indexOf(b);
                }
            });

//            List<Integer> temp = new ArrayList<>();
//            for (TreeNode node : current) {
//                temp.add(node.val);
//            }
//            order.add(temp);

            order.add(current.stream().mapToInt(a -> a.val).boxed().collect(Collectors.toList()));
        }

        return order;
    }



    private Map<TreeNode,Integer> getLevels(TreeNode root) {
        Map<TreeNode, Integer> levels = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int l = 1; l <= len; l++) {
                TreeNode current = queue.remove();
                levels.put(current, level);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }

        return levels;
    }

    private Map<Integer,List<TreeNode>> getVerticals(TreeNode root) {
        Map<Integer, List<TreeNode>> verticals = new HashMap<>();
        dfs(verticals, root, 0);
        return verticals;
    }

    private void dfs(Map<Integer,List<TreeNode>> verticals, TreeNode root, int vertical) {
        if (root == null) {
            return;
        }

        if (!verticals.containsKey(vertical)) {
            verticals.put(vertical, new ArrayList<>());
        }
        verticals.get(vertical).add(root);

        dfs(verticals, root.left, vertical - 1);
        dfs(verticals, root.right, vertical + 1);
    }


}
