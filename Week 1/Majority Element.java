class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> mp = new HashMap();
        
        int len = nums.length;
        if(len < 1)
            return Integer.MIN_VALUE;
        int count = 0;
        int num = Integer.MIN_VALUE;
        
        for(int i = 0; i< len; i++)
        {
            int x = mp.getOrDefault(nums[i], 0);
            x++;
            if(x > (len/2))
            {
                count = x;
                num = nums[i];
                break;
            }
            mp.put(nums[i],x);
        }
        return num;
    }
}