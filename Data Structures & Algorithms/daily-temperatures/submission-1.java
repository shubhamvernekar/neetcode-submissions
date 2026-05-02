class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int res[] = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int idx = stack.pop()[1];
                res[idx] = i - idx;
            }
            stack.push(new int[]{temp, i});
        }
        return res;
    }
}
