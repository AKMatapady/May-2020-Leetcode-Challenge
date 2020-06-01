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
    int count = 0;
    int ele = -1;
    int k = 0;
    
    public void recur(TreeNode root)
    {
        if(root.left != null)
            recur(root.left);
        count++;
        if(count == k)
        {
            ele = root.val;
            return;
        }
        if(root.right != null)
            recur(root.right);        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        recur(root);
        return ele;
    }
}