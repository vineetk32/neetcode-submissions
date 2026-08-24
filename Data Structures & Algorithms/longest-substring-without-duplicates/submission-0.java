class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int longestSoFar = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (!charSet.contains(curr)) {
                charSet.add(curr);
                longestSoFar = Math.max(longestSoFar, i - start + 1);
            } else {
                for (Character c: s.substring(start, i).toCharArray()) {
                    charSet.remove(c);
                    start++;
                    if (c.equals(curr)) {
                        charSet.add(curr);
                        break;
                    }
                }
            }
        }
        return longestSoFar;
    }
}
