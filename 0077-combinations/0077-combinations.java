
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), n , k, 1);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> curr, int n, int k ,int start){
        if (curr.size()==k){
            result.add(new ArrayList<>(curr));
            System.out.println(curr);
        }
        for(int i=start; i<= n; i++){
            curr.add(i);
            backtrack(result, curr, n, k,i+1);
            curr.remove(curr.size()-1);
            
        }
    }
}