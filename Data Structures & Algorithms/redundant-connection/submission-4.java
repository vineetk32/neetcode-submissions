class Solution {
    private Map<Integer, Integer> connectedComponents;

    private int find(int v) {
        if (!connectedComponents.containsKey(v)) {
            connectedComponents.put(v, v);
            return v;
        }
        int currComponent = v;
        int parent = connectedComponents.get(currComponent);
        while (parent != currComponent) {
            currComponent = parent;
            parent = connectedComponents.get(parent);
        }
        return parent;
    }

    private boolean addEdge(int[] edge) {
        int e1 = edge[0];
        int e2 = edge[1];
        int c1 = find(e1);        
        int c2 = find(e2);

        if (c1 == c2) return false;
        if (c1 < c2) connectedComponents.put(c2, c1);
        else if (c2 < c1) connectedComponents.put(c1, c2);

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        //[[3,4],[1,2],[2,4],[3,5],[2,5]]
        this.connectedComponents = new HashMap<>();
        for (int[] edge: edges) {
            if (!addEdge(edge)) return edge;
            //System.out.println(this.connectedComponents);
        }
        return new int[2];
    }
}
