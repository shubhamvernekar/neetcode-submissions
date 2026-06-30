class Solution {
    public int maxSubArray(int[] nums) {
        int prev_sum = 0;
        int result = nums[0];

        for(int i = 0; i < nums.length; i++) {
            int curr_sum = Math.max(nums[i], prev_sum + nums[i]);
            result = Math.max(result, curr_sum);
            prev_sum = curr_sum;
        }

        return result;
    }
}
