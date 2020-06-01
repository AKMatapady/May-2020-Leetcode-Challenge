class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0)
            return false;
        if(num == 1 || num == 0)
            return true;
        int start = 1, end = num/2;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(num % mid == 0 && num/mid == mid)
                return true;
            if(mid > num/mid)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        
        return false;
    }
}