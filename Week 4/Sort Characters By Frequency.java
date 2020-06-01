import java.util.*;
class Solution {
    public String frequencySort(String s) {
        
        int[] alp = new int[256];
        int len = s.length();
        Map<Integer, List<Character>> mp = new HashMap();
        StringBuilder sb = new StringBuilder();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++)
        {
            alp[s.charAt(i)]++;
        }
        
        for(int i = 0; i < 256; i++)
        {            
            if(alp[i] > 0)
            {
                if(alp[i] > max)
                    max = alp[i];
                if(alp[i] < min)
                    min = alp[i];
                List<Character> lst = mp.getOrDefault(alp[i], new ArrayList<Character>());
                lst.add((char)i);
                mp.put(alp[i], lst);
            }            
        }
        
        for(int i = max; i >= min; i--)
        {
            List<Character> lst = mp.getOrDefault(i, new ArrayList<Character>());
            int c = lst.size();
            for(int j = 0; j < c; j++)
            {
                char x = lst.get(j);
                for(int k = 0; k < i; k++)
                {
                    sb.append(Character.toString(x));
                }
            }
        }
        
        return sb.toString();
    }
}