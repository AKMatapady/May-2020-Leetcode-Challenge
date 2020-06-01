class Solution {
    public int findJudge(int N, int[][] trust) {
        
        Map<Integer, Set<Integer>> trustedby = new HashMap();
        Map<Integer, Set<Integer>> trusts = new HashMap();
        
        int len = trust.length;
        
        for(int i = 0; i < len; i++)
        {
            Set<Integer> s1 = trustedby.getOrDefault(trust[i][1], new HashSet<Integer>());
            Set<Integer> s2 = trusts.getOrDefault(trust[i][0], new HashSet<Integer>());
            s1.add(trust[i][0]);
            s2.add(trust[i][1]);
            trustedby.put(trust[i][1], s1);
            trusts.put(trust[i][0], s2);
        }
        
        int count = 0, val = -1;
        
        for(int i = 1; i <= N; i++)
        {
            Set<Integer> s1 = trustedby.getOrDefault(i, new HashSet<Integer>());
            if(s1.size() == (N-1))
            {
                Set<Integer> s2 = trusts.getOrDefault(i, new HashSet<Integer>());
                if(s2.size() == 0)                    
                {
                    count++;
                    val = i;
                }
            }
            if(count > 1)
                return -1;
        }
        return val;
    }
}