 class Solution {
     public boolean isNStraightHand(int[] hand, int groupSize) {
         int n = hand.length;
         if(n % groupSize != 0) return false;
         Map<Integer, Integer> count = new HashMap<>();
         Arrays.sort(hand);

         for(int i = 0; i < n; i++) {
             count.put(hand[i], count.getOrDefault(hand[i], 0) + 1);
         }

         for(int num : hand) {
             if(count.get(num) > 0) {
                 for(int next = num; next < num + groupSize; next++) {
                     if(count.getOrDefault(next, 0) == 0) return false;
                     count.put(next, count.get(next) - 1);
                 }
             }
         }
         return true;
     }
 }