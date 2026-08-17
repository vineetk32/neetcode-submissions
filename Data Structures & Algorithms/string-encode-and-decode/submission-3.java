class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        List<Integer> lengths = new LinkedList<>();

        for (int i = 0; i < strs.size(); i++) {
            lengths.add(strs.get(i).length());
            sb.append(strs.get(i));
        }

        String outputString = "";
        for (int length: lengths) {
            outputString += Character.toString(length);
        }
        outputString += '#';
        outputString += sb.toString();
        return outputString;
    }

    public List<String> decode(String str) {
        List<Integer> lengths = new LinkedList<>();
        int startIndex = 0;
        for (int i = 0; i < 100; i++) {
            char currChar = str.charAt(i);
            if (currChar == '#') {
                startIndex = i + 1;
                break;
            }
            int currLen = Integer.valueOf(currChar);
            System.out.println("CurrChar - " + currChar);
            lengths.add(currLen);
        }

        List<String> strings = new LinkedList<>();

        for (int length: lengths) {
            strings.add(str.substring(startIndex, startIndex + length));
            startIndex += length;
        }

        return strings;
    }
}
