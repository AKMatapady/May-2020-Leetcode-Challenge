class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        int len = nums.length, sum  = 0, ml = 0;
        HashMap<Integer, Integer> mp = new HashMap();
        mp.put(0, -1);
        
        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 1)
                sum++;
            else
                sum--;
            if(mp.containsKey(sum))
            {
                ml = Math.max(ml, i-mp.get(sum));
            }
            else
                mp.put(sum, i);
        }
        
        
        return ml;
    }
}