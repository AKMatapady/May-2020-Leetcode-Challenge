import java.util.*;
import java.lang.*;

class Solution {
    class points
    {
        int x;
        int y;
        points(int a, int b)
        {
            x = a;
            y = b;
        }
    }
    public int[][] kClosest(int[][] p, int K) {
        if(p == null || p.length <= K)
            return p;
        int len = p.length;
        
        int[][] ans = new int[K][2];
        
        PriorityQueue<points> pq = new PriorityQueue<points>(new Comparator<points>(){
           @Override
            public int compare(points a, points b)
            {
                if((Math.pow(a.x, 2) + Math.pow(a.y, 2)) > (Math.pow(b.x, 2) + Math.pow(b.y, 2)))
                    return 1;
                if((Math.pow(a.x, 2) + Math.pow(a.y, 2)) < (Math.pow(b.x, 2) + Math.pow(b.y, 2)))
                    return -1;
                return 0;
            }
        });
        
        for(int i = 0; i < len; i++)
        {
            points temp = new points(p[i][0], p[i][1]);
            pq.add(temp);
        }
        for(int i = 0; i < K; i++)
        {
            points a = pq.poll();
            ans[i][0] = a.x;
            ans[i][1] = a.y;
        }
        return ans;
    }
}