import java.util.*;
import java.lang.*;
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if(A == null || A.length < 1)
            return 0;
        if(A.length == 1)
            return A[0];
        int max_sum = A[0], sum = A[0], len = A.length;
                
        for(int i = 1; i < len; i++)
        {
            if(sum < 0)
                sum = 0;
            sum += A[i];
            if(sum > max_sum)
                max_sum = sum;
        }
        
        if(max_sum < 0)
            return max_sum;
        
        int circ_sum = A[0], circ_max = -A[0];
        A[0] = -A[0];
        for(int i = 1; i < len; i++)
        {
            circ_sum += A[i];
            A[i] = -A[i];
        }
        sum = A[0];
        for(int i = 1; i < len; i++)
        {
            if(sum < 0)
                sum = 0;
            sum += A[i];
            if(sum > circ_max)
                circ_max = sum;
        }
        circ_sum += circ_max;
        
        if(circ_sum > max_sum)
                max_sum = circ_sum;
        
        return max_sum;
    }
}