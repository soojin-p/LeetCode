class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        int hash[101] = { 0 }, count = 0;
																		 // 0 1 2 3 4 5 6 7 8 
	for (auto num : nums) hash[num]++; // 0 1 2 1 0 0 0 0 1
	for (int i = 0; i < 101; i++) {
		if (hash[i] != 0) {//앞에 있는 정수를 더해서 hash[i]에 입력
			int t = hash[i];	 //t=1
			hash[i] = count; 
			count += t; //cnt=1+2 -> 3보다 작은 값의 갯수 
		}
	}
	vector<int> ans; //4 0 1 1 3
	for (auto num : nums) ans.push_back(hash[num]);
	return ans;
    }
};