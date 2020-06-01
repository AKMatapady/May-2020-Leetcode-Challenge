import java.lang.*;
class Solution {
    public int findComplement(int num) {
        
        if( num == 0)
            return 1;
        
        int pos = 0, ans = 0;
        
        while(num > 0)
        {
            if(num % 2 == 0)
                ans += Math.pow(2, pos);
            pos++;
            num /= 2;
        }
        return ans;
    }
}