class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequency_count = new HashMap<Character, Integer>();
        int result = 0;
        int i = 0, j = 0;
        int curr_most = 0;

        while(j < s.length()) {
            frequency_count.put(s.charAt(j), frequency_count.getOrDefault(s.charAt(j), 0) + 1);
            curr_most = Math.max(curr_most, frequency_count.get(s.charAt(j)));
            if((j-i + 1) - curr_most <= k) {
                result = Math.max(result, j-i+1);
            } else {
                while(i < j && (j-i + 1) - curr_most > k) {
                    frequency_count.put(s.charAt(i), frequency_count.get(s.charAt(i)) - 1);
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
