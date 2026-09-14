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
    int res = 0;

    public int maxSumBST(TreeNode root) {
        Pair dfs = dfs(root);
        return res;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int max = 0, min = 0, sum = 0;
        if (left.max < root.val && right.min > root.val) {
            max = Math.max(right.max, root.val);
            min = Math.min(left.min, root.val);
            sum = left.sum + right.sum + root.val;
            res = Math.max(res, sum);
        } else {
            max = Integer.MAX_VALUE;
            min = Integer.MIN_VALUE;
            sum = 0;
        }

        return new Pair(sum, max, min);
    }

    record Pair(int sum, int max, int min){}
}