class Solution {
 public int longestConsecutive(int[] nums) {
        int longestCnt =0;
        HashSet<Integer> hash = new HashSet<>();
        for(int num: nums){
            hash.add(num);
        }

        for(int num: hash){
            if(!hash.contains(num-1)){
                int cnt =1;
                int nextnum = num+1;
                while (hash.contains(nextnum)) {
                    nextnum++;
                    cnt++;
                }
                longestCnt = Math.max(cnt, longestCnt);
            }
        }
        return longestCnt;
    }
}