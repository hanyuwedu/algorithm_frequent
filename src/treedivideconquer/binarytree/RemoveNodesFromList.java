package treedivideconquer.binarytree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 1/7/2019
 * Divide and conquer
 */
public class RemoveNodesFromList {
    /**
     * @param root root of the binary tree
     * @param nodesToBeRemoved a list of all nodes to be removed from the tree,
     * @return a list of all treenodes left,
     *          with removed nodes break their EDGES to parent, left and right child
     */
    public List<TreeNode> removeNodesfromList(final TreeNode root, final List<TreeNode> nodesToBeRemoved) {
        List<TreeNode> result = new ArrayList<>();
        divideConquer(root, true, new HashSet<TreeNode>(nodesToBeRemoved), result);

        return result;
    }

    /**
     * @param root root of current subtree
     * @param isRoot whether current node's parent is removed
     * @param nodesToBeRemoved a HASHSET with all nodes to be removed from the tree
     * @param result a list collecting all treenodes left, with removed nodes break their EDGES to parent, left and right child
     * @return root if current root is not to be removed, null vice versa.
     */
    private TreeNode divideConquer(final TreeNode root,
                                   final boolean isRoot,
                                   final HashSet<TreeNode> nodesToBeRemoved,
                                   List<TreeNode> result) {
        if (root == null) {
            return null;
        }

        if (nodesToBeRemoved.contains(root)) {
            root.left = divideConquer(root.left, true, nodesToBeRemoved, result);
            root.right = divideConquer(root.right, true, nodesToBeRemoved, result);
            return null;
        } else {
            if (isRoot) {
                result.add(root);
            }

            root.left = divideConquer(root.left, false, nodesToBeRemoved, result);
            root.right = divideConquer(root.right, false, nodesToBeRemoved, result);
            return root;
        }
    }

    
    

    public static void main(String[] args) {
        scenario0();
        System.out.println("_________________");
        scenario1();
        System.out.println("_________________");
        scenario2();
        System.out.println("_________________");
        scenario3();
        System.out.println("_________________");
        scenario4();
        System.out.println("_________________");
        scenario5();
        System.out.println("_________________");
        scenario6();
        System.out.println("_________________");
        scenario7();
        System.out.println("_________________");
    }

    private static void scenario0() {
        System.out.println(new RemoveNodesFromList()
                .removeNodesfromList(null, Arrays.asList(new TreeNode(1), new TreeNode(2))).isEmpty());
    }

    private static void scenario1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        List<TreeNode> result1 = new RemoveNodesFromList().removeNodesfromList(node1, Arrays.asList(node2));
        for (TreeNode node : result1) {
            node.printTree();
        }
    }

    private static void scenario2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        List<TreeNode> list1 = Arrays.asList(node1);

        List<TreeNode> result1 = new RemoveNodesFromList().removeNodesfromList(node1, list1);

        for (TreeNode node : result1) {
            node.printTree();
            System.out.println();
        }
    }


    private static void scenario3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;


        List<TreeNode> list2 = Arrays.asList(node4);
        List<TreeNode> result2 = new RemoveNodesFromList().removeNodesfromList(node1, list2);


        for (TreeNode node : result2) {
            node.printTree();
            System.out.println();
        }
    }

    private static void scenario4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        List<TreeNode> list3 = Arrays.asList(node1, node2, node3);
        List<TreeNode> result3 = new RemoveNodesFromList().removeNodesfromList(node1, list3);


        for (TreeNode node : result3) {
            node.printTree();
            System.out.println();
        }
    }

    private static void scenario5() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        List<TreeNode> list4 = Arrays.asList(node2, node3);
        List<TreeNode> result4 = new RemoveNodesFromList().removeNodesfromList(node1, list4);

        for (TreeNode node : result4) {
            node.printTree();
            System.out.println();
        }
    }

    private static void scenario6() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        List<TreeNode> list5 = Arrays.asList(node1, node2, node3, node4, node5);
        List<TreeNode> result5 = new RemoveNodesFromList().removeNodesfromList(node1, list5);


        for (TreeNode node : result5) {
            node.printTree();
            System.out.println();
        }
    }

    private static void scenario7() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        List<TreeNode> list6 = Arrays.asList(node1, node2, node3, node4, node5, node6);
        List<TreeNode> result6 = new RemoveNodesFromList().removeNodesfromList(node1, list6);


        for (TreeNode node : result6) {
            node.printTree();
            System.out.println();
        }
    }
}
