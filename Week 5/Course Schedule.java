class Solution {
    
    boolean[] visited;
    Map<Integer, Set<Integer>> mp = new HashMap();
    Map<Integer, Node> m2 = new HashMap();
    
    class Node
    {
        int val;
        boolean start;
        boolean end;
        public Node(int n)
        {
            val = n;
            start = false;
            end = false;
        }
    }
    
    public boolean DFS(int n)
    {
        Node a = m2.getOrDefault(n, new Node(n));
        a.start = true;
        m2.put(n, a);
        Set<Integer> s1 = mp.getOrDefault(n, new HashSet<Integer>());
        for(int x: s1)
        {
            if(!visited[x])
            {
                visited[x] = true;
                if(!DFS(x)) return false;
            }
            else
            {
                Node pre = m2.getOrDefault(x, new Node(x));
                if(pre.start && !pre.end)
                    return false;
            }
        }
        a.end = true;
        m2.put(n, a);
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        visited = new boolean[numCourses];
        
        for( int i =0; i < prerequisites.length; i++)
        {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            Set<Integer> s1 = mp.getOrDefault(x, new HashSet<Integer>());
            s1.add(y);
            mp.put(x, s1);
        }
        
        for( int i =0; i < numCourses; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                if(!DFS(i)) return false;
            }
        }
        return true;
    }
}