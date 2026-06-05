class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int prev[] = new int[n+1];

        for(int i = 1; i < m+1; i++) {
            int current[] = new int[n+1];
            for(int j = 1; j < n+1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    current[j] = 1 + prev[j-1];
                } else {
                    current[j] = Math.max(current[j-1], prev[j]);
                }
            }
            prev = current;
        }
    return prev[n];
    }
}
