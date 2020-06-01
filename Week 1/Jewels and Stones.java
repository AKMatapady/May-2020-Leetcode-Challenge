class Solution {
    public int numJewelsInStones(String J, String S) {
        
        Map<Character, Integer> mp = new HashMap();
        
        int len = S.length();
        for(int i = 0; i< len; i++)
        {
            int x = mp.getOrDefault(S.charAt(i), 0);
            mp.put(S.charAt(i),x+1);
        }
        int sum = 0;
        len = J.length();
        for(int i = 0; i< len; i++)
        {
            sum += mp.getOrDefault(J.charAt(i),0);
        }
        
        return sum;
    }
}