
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            queue.add(new int[]{distance, points[i][0], points[i][1]});
        }

        int result[][] = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] point = queue.poll();
            result[i] = new int[]{point[1], point[2]};
        }

        return result;
    }
}
