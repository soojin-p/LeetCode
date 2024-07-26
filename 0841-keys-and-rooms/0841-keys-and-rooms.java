import java.util.*;
import java.io.*;

class Solution {
    // rooms 배열이 주어짐, 배열의 원소값은 배열에 젒근할 수 있는 인덱스값
    // 모든 방을 방문할 수 있으면 ture, 아니면 false
    // for 문으로 배열을 순회하면서
    // 방을 탐색하는 함수 실행
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        //bfs(rooms, visited);
        dfs(rooms, visited, 0);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false)
                return false;
        }
        return true;
    }

    private void bfs(List<List<Integer>> rooms, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int key : rooms.get(cur)) {
                if (!visited[key]) {
                    queue.add(key);
                    visited[key] = true;
                }
            }
        }
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int start) {
        visited[start] = true;

        for (int key : rooms.get(start)) {
            if (!visited[key]) {
                visited[key] = true;
                dfs(rooms, visited, key);
            }
        }
    }
}