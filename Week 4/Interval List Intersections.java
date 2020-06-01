class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        if(A == null || B == null || A.length < 1 || B.length < 1)
            return new int[0][0];
        
        int len1 = A.length, len2 = B.length;
        int i = 0, j = 0;
        List<int[]> lst = new ArrayList();
        
        while(i < len1 && j < len2)
        {
            int a1 = A[i][0];
            int b1 = B[j][0];
            int a2 = A[i][1];
            int b2 = B[j][1];
            if(b1 > a2)
            {
                i++;
            }
            else if(a1 > b2)
            {
                j++;
            }
            else
            {
                int[] temp = new int[2];
                if(a1 <= b2 && b1 <= a1)
                {
                    temp[0] = a1;
                    temp[1] = Math.min(a2, b2);
                    //j++;
                }
                else
                {
                    temp[0] = b1;
                    temp[1] = Math.min(b2, a2);
                    //i++;
                }
                
                if(a2 >= b2)
                {
                    j++;
                }
                else
                {
                    i++;
                }
                
                lst.add(temp);
            }
        }
        int len = lst.size();
        int[][] res = new int[len][2];
        for( i = 0; i < len; i++)
        {
            res[i][0] = lst.get(i)[0];
            res[i][1] = lst.get(i)[1];
        }
        return res;
    }
}