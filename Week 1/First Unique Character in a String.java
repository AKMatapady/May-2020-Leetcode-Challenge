class Solution {
    public int firstUniqChar(String s) {        
        
        if(s == null || s.length() == 0)
            return -1;
        if(s.length() == 1)
            return 0;
        
        int  len = s.length();
        Map<Character, Integer> mp = new HashMap();
        
        for(int i = 0; i < len; i++)
        {
            int x = mp.getOrDefault(s.charAt(i), 0);
            mp.put(s.charAt(i), x+1);
        }
        
        for(int i = 0; i< len; i++)
        {
            int x = mp.getOrDefault(s.charAt(i), 0);
            if(x == 1)
                return i;
        }
        
        return -1;        
    }
}