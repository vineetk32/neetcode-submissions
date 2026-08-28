class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();// 
        Map<Character, Character> validMap = new HashMap<>();
        validMap.put(')', '(');
        validMap.put('}', '{');
        validMap.put(']', '[');
        for (Character c: s.toCharArray()) {
            if (!validMap.containsKey(c)) {
                stack.addLast(c);
                // System.out.println("Adding "+ c);
            }
            else if (validMap.get(c) == stack.peekLast()) {
                Character p = stack.pollLast();
                // System.out.println("Popping "+ p);
            }
            else return false;
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
