class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Set<String> validOperators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        //Base case: zero len.
        Deque<Integer> resultStack = new LinkedList<>();
        for (String token: tokens) {

            if (validOperators.contains(token)) {
                Integer rhs = resultStack.pollLast();
                Integer lhs = resultStack.pollLast();
                Integer val = performOperation(lhs, rhs, token);
                resultStack.offerLast(val);
            } else {
                Integer currVal = Integer.parseInt(token);
                resultStack.offerLast(currVal);
            }
        }
        // If Integer, push to Stack
        // If operator, pop the last two, perform the operation
        // push the result into the stack
        result = resultStack.pollLast();
        return result;
    }

    private Integer performOperation(final Integer lhs, final Integer rhs, final String token) {
        switch (token) {
            case "+":
                return lhs + rhs;
            case "-":
                return lhs - rhs;
            case "*":
                return lhs * rhs;
            case "/":
                return lhs / rhs;
            default:
                return 0;
        }
    }
}
