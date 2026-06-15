class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Arrays.sort(hand);
        int tmp_n = n / groupSize;
        int tmp_arr[] = new int[tmp_n];
        Arrays.fill(tmp_arr, -1);
        int tmp_arr_size[] = new int[tmp_n];

        for(int i = 0; i < n; i++) {
            boolean found = false;
            System.out.println(Arrays.toString(tmp_arr));
            for(int j = 0; j < tmp_n; j++) {
                if(tmp_arr_size[j] == groupSize) continue;
                if(tmp_arr[j] == -1 || hand[i] - tmp_arr[j] == 1) {
                    found = true;
                    tmp_arr[j] = hand[i];
                    tmp_arr_size[j]++;
                    break;
                }
            }

            if(!found) return false;
        }

        return true;
    }
}
