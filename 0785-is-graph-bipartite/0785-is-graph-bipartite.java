class Solution {
    public boolean isBipartite(int[][] graph) {
        char marking[] = new char[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (marking[i] == 0) {
                if (!bfs(graph, marking, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, char[] marking, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        marking[start] = 'A';

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (marking[next] == 0) {
                    marking[next] = (marking[curr] == 'A') ? 'B' : 'A';
                    queue.offer(next);
                } else if (marking[next] == marking[curr])
                    return false;
            }
        }
        return true;
    }
}