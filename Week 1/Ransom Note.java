class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote == null || ransomNote.length() == 0)
            return true;
        if(magazine == null || magazine.length() == 0)
            return false;
        
        if(magazine.length() < ransomNote.length())
            return false;
        
        Map<Character, Integer> mp = new HashMap();
        int len1 = magazine.length();
        
        for(int i = 0; i < len1; i++)
        {
            int x = mp.getOrDefault(magazine.charAt(i), 0);
            mp.put(magazine.charAt(i), x+1);
        }
        
        len1 = ransomNote.length();
        for(int i = 0; i < len1; i++)
        {
            int x = mp.getOrDefault(ransomNote.charAt(i), 0);
            x--;
            if(x < 0)
                return false;
            mp.put(ransomNote.charAt(i), x);
        }
        return true;
    }
}