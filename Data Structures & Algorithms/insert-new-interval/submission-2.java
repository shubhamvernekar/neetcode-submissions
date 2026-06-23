class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        int n = intervals.length;
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        while(i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[0][]);
    }
}
