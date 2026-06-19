
class Solution {
    class Distance {
        double distance;
        int index;

        Distance(double distance, int index) {
            this.distance = distance;
            this.index = index;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        PriorityQueue<Distance> queue = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        for(int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(Math.pow(0 - points[i][0], 2) + Math.pow(0 - points[i][1], 2));
            queue.add(new Distance(distance, i));
        }

        for(int i = 0; i < k; i++) {
            Distance d = queue.poll();
            int point[] = points[d.index];
            result.add(point);
        }

        return result.toArray(new int[0][]);
    }
}
