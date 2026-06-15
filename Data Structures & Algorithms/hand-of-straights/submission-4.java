class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        TreeMap<Integer, Integer> freq = new TreeMap<Integer, Integer>();

        for(int i = 0; i < n; i++) {
            freq.put(hand[i], freq.getOrDefault(hand[i], 0) + 1);
        }

        for(int num : freq.keySet()) {
            int count = freq.get(num);
            if(count == 0) continue;

            for(int next = num; next < num + groupSize; next++) {
                if(freq.getOrDefault(next, 0) < count) return false;
                freq.put(next, freq.get(next) - count);
            }
        }

        return true;
    }
}