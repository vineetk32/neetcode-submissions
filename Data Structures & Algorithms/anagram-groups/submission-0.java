class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedStrings = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> currList = groupedStrings.getOrDefault(key, new LinkedList<>());
            currList.add(str);
            groupedStrings.put(key, currList);
        }

        return groupedStrings.values()
        .stream()
        .collect(Collectors.toList());
    }
}
