class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Base case - different lengths, zero etc
        Map<Character, Integer> charCounts = getCharCounts(s1, 0, s1.length());

        int windowSize = s1.length();
        for (int i = 0; i + windowSize <= s2.length(); i++) {
            Map<Character, Integer> currCounts = getCharCounts(s2, i, i + windowSize);

            if (charCounts.equals(currCounts)) return true;
        }

        return false;
    }

    Map<Character, Integer> getCharCounts(String s1, int start, int end) {
        Map<Character, Integer> charCounts = new TreeMap<Character, Integer>();
        for (int i = start; i < end; i++) {
            Character currChar = s1.charAt(i);
            charCounts.put(currChar, charCounts.getOrDefault(currChar, 0) + 1);
        }

        return charCounts;
    }
}
