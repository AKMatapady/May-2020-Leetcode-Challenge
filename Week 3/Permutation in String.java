class Solution {
    
    public boolean com(int[] a, int[] b)
    {
        for(int i = 0; i < 26; i++)
        {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length())
            return false;
        
        int[] p = new int[26];
        int[] w = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        
        for(int i = 0; i< len1; i++)
        {
            p[s1.charAt(i) - 'a']++;
            w[s2.charAt(i) - 'a']++;
        }
        if(com(p, w))
            return true;
        for(int i = 1; i <= len2-len1;i++)
        {
            w[s2.charAt(i-1) - 'a']--;
            w[s2.charAt(i+len1-1) - 'a']++;
            if(com(p, w))
                return true;
        }
        
        return false;
    }
}