class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        getPalindronPartions(0, s, new ArrayList<String>());
        return result;
    }

    public boolean isPalindron(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public void getPalindronPartions(int i, String s, List<String> list) {
        if(i == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        int j = i;
        while(j < s.length()) {
            if(isPalindron(i , j, s)) {
                list.add(s.substring(i, j+1));
                getPalindronPartions(j+1, s, list);
                list.remove(s.substring(i, j+1));
            }
            j++;
        }
    }
}
