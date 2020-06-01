class Solution {
    int len1, len2;
    int[] a, b;
    int[][] dp;
    
    public int recur(int i, int j)
    {
        if(i >= len1 || j >= len2)
            return 0;
        
        if(dp[i][j] > -1)
            return dp[i][j];
        
        int p = Math.max( ((a[i]==b[j])? 1:0)+recur(i+1, j+1), Math.max(recur(i+1, j), recur(i, j+1)));
        
        dp[i][j] = p;
        return p;
    }
    
    public int maxUncrossedLines(int[] A, int[] B) {
        if(A == null || B == null || A.length < 1 || B.length < 1)
            return 0;
        a = A; b = B;
        len1 = A.length; len2 = B.length;
        dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++)
            Arrays.fill(dp[i], -1);
        dp[len1][len2] = 0;
        dp[len1][len2-1] = 0;
        dp[len1-1][len2] = 0;
        
        return recur(0, 0);
        
    }
}