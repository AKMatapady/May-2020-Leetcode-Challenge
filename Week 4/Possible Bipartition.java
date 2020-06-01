class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length < 3 || N < 3)
            return true;
        Set<Integer> st1 = new HashSet();
        Set<Integer> st2;
        Set<Integer> rem = new HashSet();
        Map<Integer, Set<Integer>> mp = new HashMap();
        int len = dislikes.length;
        
        if(len > (((N+1)/2)*(N/2)))
            return false;
        
        for(int i = 0; i < len; i++)
        {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            Set<Integer> s1 = mp.getOrDefault(x, new HashSet<Integer>());
            s1.add(y);
            mp.put(x, s1);
            Set<Integer> s2 = mp.getOrDefault(y, new HashSet<Integer>());
            s2.add(x);
            mp.put(y, s2);
        }
        if(mp.size() < 2)
            return true;
        
        st1.add(1);
        st2 = mp.getOrDefault(1, new HashSet<Integer>());
        for(int i = 2; i <= N; i++)
        {
            Set<Integer> s1 = mp.getOrDefault(i, new HashSet<Integer>());
            for(int a : s1)
            {
                if(st1.contains(a))
                {
                    if(st1.contains(i))
                        return false;
                    st2.add(i);
                    break;
                }
                else if(st2.contains(a))
                {
                    if(st2.contains(i))
                        return false;
                    st1.add(i);
                    break;
                }
                else if(st1.contains(i))
                {
                    break;
                }
                else if(st2.contains(i))
                {
                    break;
                }
            }
            
            if(st1.contains(i))
            {
                st2.addAll(s1);
                if(!Collections.disjoint(st1, st2))
                    return false;
            }
            else if(st2.contains(i))
            {
                st1.addAll(s1);
                if(!Collections.disjoint(st2, st1))
                    return false;
            }
            
            if(!st1.contains(i) && !st2.contains(i))
                rem.add(i);
            if(st1.size() + st2.size() > N)
                return false;
        }
        for(int i: rem)
        {
            Set<Integer> s1 = mp.getOrDefault(i, new HashSet<Integer>());
            for(int a : s1)
            {
                if(st1.contains(a))
                {
                    if(st1.contains(i))
                        return false;
                    st2.add(i);
                    break;
                }
                else if(st2.contains(a))
                {
                    if(st2.contains(i))
                        return false;
                    st1.add(i);
                    break;
                }
                else if(st1.contains(i))
                {
                    break;
                }
                else if(st2.contains(i))
                {
                    break;
                }
                else
                {
                    st1.add(i);
                    st2.addAll(s1);
                    break;
                }
            }
            
            if(st1.contains(i))
            {
                st2.addAll(s1);
                if(!Collections.disjoint(st1, st2))
                    return false;
            }
            else if(st2.contains(i))
            {
                st1.addAll(s1);
                if(!Collections.disjoint(st2, st1))
                    return false;
            }
            if(st1.size() + st2.size() > N)
                return false;
        }
        return true;
    }
}