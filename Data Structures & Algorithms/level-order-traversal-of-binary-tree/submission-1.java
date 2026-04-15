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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if(root == null) return result;

    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         Queue<TreeNode> tmpQueue = new LinkedList<>();
    //         ArrayList<Integer> list = new ArrayList<Integer>();
    //         while(!queue.isEmpty()) {
    //             TreeNode node = queue.poll();
    //             if(node == null) continue;
    //             list.add(node.val);
    //             if(node.left != null) tmpQueue.offer(node.left);
    //             if(node.right != null) tmpQueue.offer(node.right);
    //         }
    //         result.add(list);
    //         queue.addAll(tmpQueue);
    //     }
    //     return result;
    // }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int depth) {
        if(root == null) return;

        if(result.size() == depth) {
            result.add(new ArrayList<Integer>());
        }

        result.get(depth).add(root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
