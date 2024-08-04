class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        int[] order = new int[numCourses];

        int count = 0;
        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) {
                queue.add(c);
                visited[c] = true;
                order[count] = c;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        visited[next] = true;
                        order[count] = next;
                        count++;
                        queue.add(next);
                    }
                }
            }
        }
         return (count == numCourses)? order : new int[]{};
    }
}