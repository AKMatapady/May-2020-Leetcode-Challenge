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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null || root.val == x || root.val == y)
            return false;
        
        int d = -1;
        int curr = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            if(temp == null)
            {
                curr++;
                q.add(null);
                continue;
            }
            if(d != -1 && d<curr)
                break;
            if(temp.left != null && temp.right != null)
            {
                if((temp.left.val == x && temp.right.val == y) || (temp.left.val == y && temp.right.val == x))
                    return false;
            }
            if(temp.left != null && (temp.left.val == x || temp.left.val == y))
            {
                if(d==-1)
                {
                    d=curr;
                }
                else
                {
                    if(d == curr)
                        return true;
                }
            }
            if(temp.right != null && (temp.right.val == x || temp.right.val == y))
            {
                if(d==-1)
                {
                    d=curr;
                }
                else
                {
                    if(d == curr)
                        return true;
                }
            }
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
            
        }
        
        return false;
    }
}