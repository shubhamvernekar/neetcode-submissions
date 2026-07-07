class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        
        if(n1 > n2) return false;

        int s1_char_count[] = new int[26];
        int s2_char_count[] = new int[26];
        
        for(char ch : s1.toCharArray()) {
            s1_char_count[ch - 'a']++;
        }

        for(int i = 0; i < n1; i++) {
            s2_char_count[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1_char_count, s2_char_count)) return true;

        for(int i = n1; i < n2; i++) {
            s2_char_count[s2.charAt(i) - 'a']++;
            s2_char_count[s2.charAt(i - n1)- 'a']--;
            if(Arrays.equals(s1_char_count, s2_char_count)) return true;
        }

        return false;
    }
}
