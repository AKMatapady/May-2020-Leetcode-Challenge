/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int[] pre;
    
    public TreeNode bst(int start, int end)
    {
        if(start > end)
            return null;
        TreeNode head = new TreeNode(pre[start]);
        int  i = start+1;
        for(; i <= end; i++)
        {
            if(pre[i] > pre[start])
                break;
        }
        head.left = bst(start+1,i-1);
        head.right = bst(i,end);
        return head; 
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if(len < 1)
            return null;
        TreeNode head = new TreeNode(preorder[0]);
        if(len == 1)
            return head;
        pre = preorder;
        int i = 1;
        for(; i < len; i++)
        {
            if(pre[i] > pre[0])
                break;
        }
        head.left = bst(1,i-1);
        head.right = bst(i,len-1);
        return head;        
    }
}