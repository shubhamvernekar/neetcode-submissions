class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];

        for(int i = 0, j = nums.length-1; i < nums.length && j >= 0; i++, j--) {
            if(i == 0) a[i] = nums[i];
            else a[i] = a[i-1] * nums[i];

            if(j == nums.length-1) b[j] = nums[j];
            else b[j] = b[j+1] * nums[j];
        }

        int result[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) result[i] = b[i+1];
            else if(i == nums.length-1) result[i] = a[i-1];
            else result[i] = a[i-1] * b[i+1];
        }
        return result;
    }
}  
