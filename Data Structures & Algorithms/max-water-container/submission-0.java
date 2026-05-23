class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length - 1;
        int i = 0, j = n;
        int max_water = 0;

        while(i < j) {
            int distance = j - i;
            max_water = Math.max(distance * Math.min(heights[i], heights[j]), max_water);
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_water;
    }
}
