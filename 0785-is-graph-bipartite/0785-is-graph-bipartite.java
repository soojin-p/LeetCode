import java.util.*;

class Solution {
    // 그래프가 이분 그래프인지 판별하는 문제
    public boolean isBipartite(int[][] graph) {
        // 방문 여부 및 그룹 할당을 저장하는 배열 (0: 방문 안 함, 1: 그룹 A, 2: 그룹 B)
        int[] visited = new int[graph.length];
        
        // 모든 노드를 탐색
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {  //  방문하지 않은 노드만 탐색 시작
                if (!bfs(graph, visited, i)) {
                    return false;  // 이분 그래프가 아닌 경우
                }
            }
        }
        return true;  // 모든 컴포넌트가 이분 그래프인 경우
    }

    private boolean bfs(int[][] graph, int[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;  // 시작 노드를 그룹 A로 지정

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (visited[next] == 0) {
                    // 현재 노드와 다른 그룹으로 분류
                    visited[next] = (visited[cur] == 1) ? 2 : 1;
                    queue.add(next);
                } else if (visited[next] == visited[cur]) {
                    // 인접한 노드가 같은 그룹에 속해 있으면 이분 그래프가 아님
                    return false;
                }
            }
        }
        return true;
    }
}
