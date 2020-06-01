import java.util.*;

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
    
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() < p.length())
            return new ArrayList<Integer>();
        
        List<Integer> lst = new ArrayList();
        int len1 = p.length();
        int len2 = s.length();
        int[] pa = new int[26];
        int[] ca = new int[26];
        for(int i = 0; i < len1; i++)
        {
            pa[p.charAt(i) - 'a']++;
            ca[s.charAt(i) - 'a']++;
        }
        
        if(com(pa, ca))
            lst.add(0);            
        
        for(int i = 1; i <= len2-len1; i++)
        {
            ca[s.charAt(i-1) - 'a']--;
            ca[s.charAt(i+len1-1) - 'a']++;
            if(com(pa, ca))
                lst.add(i);
        }
        return lst;
    }
}