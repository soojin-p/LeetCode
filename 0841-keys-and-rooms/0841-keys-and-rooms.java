class Solution {
public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int visitedcnt =1;

        //큐가 비어있지 않는동안:
        while (!queue.isEmpty()) {
            //큐에서 현재 room 꺼냄
            int room  = queue.poll();
            //room에서 얻은 key 개수만큼 반복
            for(int key:rooms.get(room)){
                //방문검사
                if(!visited[key]){
                    queue.offer(key);
                    visited[key] = true; // --> 방문 체크를 빼먹어서 시간초과 발생
                    visitedcnt++;
                }
            }
        }
        //room을 방문한 횟수와 rooms.size가 같은지 체크:
        return visitedcnt==rooms.size();
    }
}