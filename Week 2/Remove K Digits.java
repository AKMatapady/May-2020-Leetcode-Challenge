class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k)
            return "0";
        
        StringBuilder sb = new StringBuilder(num);
        int j = 0;
        for(int i = 0 ; i < sb.length()-1; i++)
        {
            if(sb.charAt(i) > sb.charAt(i+1))
            {
                sb.delete(i, i+1);
                i-=2;
                if(i < -1)
                    i = -1;
                j++;
            }
            if(j == k)
                break;
        }
        int len = sb.length();
        
        while(j < k)
        {
            sb.delete(len-1, len);
            j++;
            len = sb.length();
        }
        
        for(int i = 0; i < len-1; i++)
        {
            if(sb.charAt(0) == '0')
                sb.delete(0,1);
            else
                break;
            //len = sb.length();    shouldn't decrement length as I is increasing and we don't use i to delete.
        }
        return sb.toString();
    }
}