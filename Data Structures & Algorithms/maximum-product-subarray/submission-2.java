class Solution {
    public int maxProduct(int[] nums) {
        int curr_min = nums[0], curr_max = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tmp = nums[i] * curr_max;

            curr_max = Math.max(Math.max(tmp, nums[i] * curr_min), nums[i]);
            curr_min = Math.min(Math.min(tmp, nums[i] * curr_min), nums[i]);
            result = Math.max(result, curr_max);
        }
        return result;
    }
}
