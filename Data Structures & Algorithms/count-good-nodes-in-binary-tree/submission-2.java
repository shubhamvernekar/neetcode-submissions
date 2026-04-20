/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    public int count(TreeNode node, int max_in_path) {
        if(node == null) return 0;
        int counter = 0;
        if(node.val >= max_in_path) counter++;
        max_in_path = Math.max(max_in_path, node.val);

        counter += count(node.left, max_in_path);
        counter += count(node.right, max_in_path);
        return counter;
    }
}
