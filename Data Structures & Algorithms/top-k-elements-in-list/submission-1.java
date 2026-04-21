class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Min heap / priority queue
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size() > k) {
                heap.poll();
            }
        }
        int result[] = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }
        return result;
    }

    // public int[] topKFrequent(int[] nums, int k) {
    //     // Bucket sort
        
    // }
}
