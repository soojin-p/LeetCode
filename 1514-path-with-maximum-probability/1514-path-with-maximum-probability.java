
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<double[]>> graph = new HashMap<>();
        // 그래프 만들기
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new double[] { v, prob });
            graph.get(v).add(new double[] { u, prob });
        }

        // 우선순위 큐를 사용하여 최대 확룰 경로 탐색
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double[] prob = new double[n];
        prob[start_node] = 0.0; 
        pq.add(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int curNode = (int)cur[0];
            double curProb = cur[1];

            if (curNode == end_node) return curProb;
            // 현재 노드의 확률이 기록된 최대 확률보다 작으면 무시
            if(prob[curNode] > curProb)continue; 

            // 현재 노드와 연결된 노드들에 대해 확률 계산
            for(double[] node: graph.getOrDefault(curNode, Collections.emptyList())){
                int nextNode = (int) node[0];
                double nextprob = node[1]*curProb;

                 // 새로운 확률이 기존 확률보다 크면 업데이트하고 큐에 추가
                if(nextprob>prob[nextNode]){
                    prob[nextNode]= nextprob;
                    pq.add(new double[]{nextNode,nextprob});
                }
            }
        }
        return 0.0;
    }
}