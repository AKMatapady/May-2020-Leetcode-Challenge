class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        //given coordinates has a minimum length of 2
        double slope = ((double)(coordinates[1][1] - coordinates[0][1]))/((double)(coordinates[1][0] - coordinates[0][0]));
        int len = coordinates.length;
        for(int i = 2; i<len; i++)
        {
            double slope2 = ((double)(coordinates[i][1] - coordinates[0][1]))/((double)(coordinates[i][0] - coordinates[0][0]));
            if(slope2 != slope)
                return false;
        }
        return true;
    }
}