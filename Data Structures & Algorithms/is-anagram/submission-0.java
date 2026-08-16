class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap sCount = getCharCount(s);
        HashMap tCount = getCharCount(t);

        if (sCount.equals(tCount)) {
            return true;
        } else {
            return false;
        }
    }

    private static HashMap<Character, Integer> getCharCount(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }
}
