import java.util.*;

class Solution {
    /**
     * 접근 방법:
     * 주어진 동전을 사용하여 특정 금액(amount)을 만드는 데 필요한 최소 동전 개수를 찾는 문제.
     * 각 동전의 사용 횟수는 무제한이므로, 모든 가능한 조합을 탐색.
     * 
     * - BFS를 사용 이유:
     *   1. 각 단계에서 동전을 추가할 때마다 가능한 모든 금액을 탐색하므로, 
     *      가장 먼저 목표 금액을 달성하는 경로가 최소 동전 개수.
     *   2. BFS는 최단 경로 탐색에 적합-> 동전의 조합으로 금액을 만드는 데 필요한 최소 동전 수 탐색.
     */
    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        Queue<Entry> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[amount + 1];
        queue.add(new Entry(amount, 0));

        while (!queue.isEmpty()) {
            Entry cur = queue.remove();

            for (int i = 0; i < coins.length; i++) {
                int nextAmount = cur.amount - coins[i];
                if (nextAmount == 0) 
                    return cur.count + 1;
                else if (nextAmount > 0 && !visit[nextAmount]) {
                    queue.add(new Entry(nextAmount, cur.count + 1));
                    visit[nextAmount] = true;
                }
            }
        }
        return -1;
    }

    static class Entry {
        int amount;
        int count;

        public Entry(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }
    }
}
