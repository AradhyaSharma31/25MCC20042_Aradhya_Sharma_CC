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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, targetSum, new ArrayList<>(), res);

        return res;
    }

    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> inner, List<List<Integer>> outer) {
        if (root == null) {
            return;
        }

        inner.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            outer.add(new ArrayList<>(inner));
        }

        dfs(root.left, sum, targetSum, inner, outer);
        dfs(root.right, sum, targetSum, inner, outer);

        inner.remove(inner.size() - 1);
    } 
}