class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        subsets.add(new LinkedList<>());

        //Base case - empty nums, 0 etc.

        for (int num: nums) {
            List<List<Integer>> subsetsSoFar = subsets.stream()
            .map(LinkedList::new)
            .collect(Collectors.toCollection(ArrayList::new));

            for (ListIterator<List<Integer>> it = subsetsSoFar.listIterator(); it.hasNext(); ) {
                List<Integer> currList = it.next();
                currList.add(num);
                it.set(currList);             
            }
            subsets.addAll(subsetsSoFar);
        }
        return subsets;
    }
}
