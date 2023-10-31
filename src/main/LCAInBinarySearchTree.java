package main;

public class LCAInBinarySearchTree {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode (int value) {
            this.value = value;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.value;
        int qValue = q.value;
        // start from root node of the tree
        TreeNode currentNode = root;
        while (currentNode != null) {
            int currentValue = currentNode.value;
            if (pValue < currentValue && qValue < currentValue) {
                // if both q & q are less than current node
                currentNode = currentNode.left;
            } else if (pValue > currentValue && qValue > currentValue) {
                // if both q & q are greater than current node
                currentNode = currentNode.right;
            } else {
                // we have found the split point
                return currentNode;
            }
        }
        return null;
    }
}
