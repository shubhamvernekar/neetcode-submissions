class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : strs) {
            String sorted = sortString(s);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(s);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
