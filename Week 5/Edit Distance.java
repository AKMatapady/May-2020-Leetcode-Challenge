class Solution {
    
    int[][] dp;
    
    public int recur(String w1, String w2)
    {
        int len1 = w1.length(), len2 = w2.length();
        if(len1 == 0)
            return len2;
        if(len2 == 0)
            return len1;
        if(dp[len1][len2] > -1)
            return dp[len1][len2];
        int a = 0, b = 0, c = 0;
        if(w1.charAt(len1-1) == w2.charAt(len2-1))
            a = recur(w1.substring(0,len1-1), w2.substring(0, len2-1));
        else
            a = 1 + recur(w1.substring(0,len1-1), w2.substring(0, len2-1));
        b = 1 + recur(w1.substring(0, len1-1), w2);
        c = 1 + recur(w1, w2.substring(0, len2-1));
        dp[len1][len2] = Math.min(a, Math.min(b, c));
        return dp[len1][len2];
    }
    
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length(), len2 = word2.length();
        if(len1 == 0)
            return len2;
        if(len2 == 0)
            return len1;
        
        dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = 0;
        for(int i = 0; i <= len1; i++)
        {
            dp[i][0] = i;          
        }
        for(int i = 0; i <= len2; i++)
        {
            dp[0][i] = i;            
        }
        
        return recur(word1, word2);
    }
}