class Solution {
    // n개의 노드와 tine이 주어짐.
    // times[i] = (ui, vi, wi)
    // u: 출발노드,v: 도착노드, w: 가중치

    // k로 신호를 보냈을 때 모든 노드가 신호를 수신하는데 걸린 시간
    // 모든 노드가 수신하지 못하면 -1

    // 다익스트라 알고리즘
    // 방문 못한 노드 찾기
    // 최소값중에서 최대값 구하기
    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프 구현
        Map<Integer, List<int[]>> edges = Arrays.stream(times)
                .collect(Collectors.groupingBy(t -> t[0]));

        // visited[방문노드] = 최단거리
        int[] visited = new int [n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
         // 우선순위 큐: {노드, 해당 노드까지의 시간} 형태로 저장
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.add(new int[]{k, 0});  // 시작 노드 k에서 출발, 초기 거리는 0
        visited[k] = 0;

        int maxTime =0;
        int visitCount =1;

        while (!pq.isEmpty()) {
            int cur[] =pq.remove();
            int u = cur[0], time = cur[1];
            if(visited[u]<time) continue; // 이미 더 짧은 거리로 방문한 경우 건너뜀
            maxTime= time;

            if(!edges.containsKey(u)) continue;  // 현재 노드에서 출발하는 간선이 없으면 다음으로
            for(int[] edge: edges.get(u)){
                int v = edge[1]; // 도착 노드
                int w= edge[2]; // 가중치
                // 다음 노드가 이미 더 찗은 거리로 방문한 적이 있는 경우 건너뜀.
                if(time +w >=visited[v]) continue;
                  // 처음 방문하는 노드라면 방문 카운트 증가
                if(visited[v] == Integer.MAX_VALUE) visitCount++; 
                visited[v] = time + w; // 방문 노드의 최단 거리 업데이트
                pq.add(new int[]{ v, time + w }); // 도착 노드를 큐에 추가
            }

        }
        return visitCount == n ? maxTime : -1;
    }
}