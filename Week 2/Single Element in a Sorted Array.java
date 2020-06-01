class Solution {
    
    public int singleNonDuplicate(int[] nums) {
        if(nums ==null || nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int len = nums.length;
        int start = 0, end = len-1;
        while(start < end)
        {
            int mid = (start + end)/2;
            if(mid == 0)
            {
                return nums[0];                    
            }
            else if(mid == len-1)
            {
                return nums[len-1];
            }
            else if(nums[mid] == nums[mid+1])
            {
                if((mid-start) % 2 == 0)
                {
                    start = mid+2;
                }
                else
                {
                    end = mid-1;
                }
            }
            else if(nums[mid] == nums[mid-1])
            {
                if((mid-start) % 2 == 0)
                {
                    end = mid-2;
                }
                else
                {
                    start = mid+1;
                }
            }
            else
            {
                return nums[mid];
            }
        }
        return nums[start];
    }
}