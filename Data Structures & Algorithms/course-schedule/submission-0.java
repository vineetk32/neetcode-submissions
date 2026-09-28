class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjacencyList = buildAdjacencyList(numCourses, prerequisites);
        
        return topologicalSort(adjacencyList);
    }


    private Map<Integer, Set<Integer>> buildEligibilityMap(Map<Integer, Set<Integer>> list) {
        Map<Integer, Set<Integer>> eligibilityMap = new HashMap<>();//{1: [0], 0: []}
        for (Map.Entry<Integer, Set<Integer>> entry: list.entrySet()) { //{0: [1], 1: []}
            int course = entry.getKey();//0
            Set<Integer> prereqs = entry.getValue();//1

            for (int prereq: prereqs) {
                if (!eligibilityMap.containsKey(prereq)) {
                    eligibilityMap.put(prereq, new HashSet<>());
                }

                eligibilityMap.get(prereq).add(course);
            }
        }
        //eligibility map - course: list of now eligible courses

        return eligibilityMap;
    }

    private Map<Integer, Set<Integer>> buildAdjacencyList(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0;i < numCourses; i++) {//0 - 1
            adjacencyList.put(i, new HashSet<>()); //{0: [1], 1: []}
        }

        for (int[] prereq: prerequisites) {
            int firstCourse = prereq[1]; 
            int secondCourse = prereq[0];
            adjacencyList.get(secondCourse).add(firstCourse);
        }
        //Adjacency list - course: list of prereqs

        return adjacencyList;
    }

 private boolean topologicalSort(Map<Integer, Set<Integer>> adjacencyList) {
    Map<Integer, Set<Integer>> dependents = buildEligibilityMap(adjacencyList);
    Queue<Integer> processingQueue = new LinkedList<>();

    // Courses with no prereqs are ready immediately
    for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
        if (entry.getValue().isEmpty()) {
            processingQueue.offer(entry.getKey());
        }
    }

    int completed = 0;
    while (!processingQueue.isEmpty()) {
        int course = processingQueue.poll();
        completed++;

        for (int dependent : dependents.getOrDefault(course, Collections.emptySet())) {
            Set<Integer> prereqs = adjacencyList.get(dependent);
            prereqs.remove(course);
            if (prereqs.isEmpty()) {
                processingQueue.offer(dependent);
            }
        }
    }

    return completed == adjacencyList.size();
}
}
