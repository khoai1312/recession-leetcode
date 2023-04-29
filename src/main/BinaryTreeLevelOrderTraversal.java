package main;

import java.util.*;


public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.remove();
                currentLevelNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            output.add(currentLevelNodes);
        }
        return output;
    }
}
